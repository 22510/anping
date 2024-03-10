package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.*;
import com.ins.anping.base.service.impl.*;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.OCRByBaiDu.AccurateBasic;
import com.ins.anping.utils.UserHolder;
import com.ins.anping.utils.WebSocket.WebSocketServer;
import com.ins.anping.utils.fileSave.SaveLocal;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 租赁合同 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06zu
 */
@Slf4j
@RestController
@RequestMapping("api/busi/table/zulinhetong")
public class ZulinhetongController {


    @Autowired
    private ZulinhetongwuliaoServiceImpl zulinhetongwuliaoService;

    @Autowired
    private FukuanjiedianServiceImpl fukuanjiedianService;

    @Autowired
    private ZulinhetongServiceImpl zulinhetongService;

    @Autowired
    private YonghuguanliServiceImpl yonghuguanliService;

    @ApiOperation("查询该业务员的所有租赁合同")
    @GetMapping("/list")
    public ResponseResult<?> list() {
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        System.out.println(UserHolder.getUser().getUsername());
        zulinhetongQueryWrapper.eq("YeWuYuan", UserHolder.getUser().getUsername());
        List<Zulinhetong> list = zulinhetongService.list(zulinhetongQueryWrapper);
        System.out.println(list.toString());
        if (!list.isEmpty()) {
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id) {
        Zulinhetong result = zulinhetongService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Zulinhetong> page) {
        IPage<Zulinhetong> zulinhetongIPage = zulinhetongService.page(page);
        if (zulinhetongIPage != null) {
            return ResponseResult.okResult(200, "success", zulinhetongIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private XiaoxituisonglogServiceImpl xiaoxituisonglogService;

    @Autowired
    private LiuchengdingyiServiceImpl liuchengdingyiService;

    @Autowired
    private LiuchengjiluServiceImpl liuchengjiluService;

    @PostMapping
    public ResponseResult<?> save(@RequestBody Zulinhetong zulinhetong) {
//        System.out.println(zulinhetong);
        QueryWrapper<Ziliao4zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("HeTongBianHao", zulinhetong.getHetongbianhao());
        List<Ziliao4zulinhetong> list = ziliao4zulinhetongService.list(zulinhetongQueryWrapper);

        zulinhetong.setYewuyuan(UserHolder.getUser().getUsername());

        List<String> urls = new ArrayList<>();
        for (Ziliao4zulinhetong str : list){
            urls.add(str.getZiliaopath());
        }
        zulinhetong.setHetongtupian(urls.toString());
        zulinhetong.setHetongzhixingjindu("待审批");
        QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
        yonghuguanliQueryWrapper.eq("YongHuMing", UserHolder.getUser().getUsername());
        Yonghuguanli yonghuguanli = yonghuguanliService.getOne(yonghuguanliQueryWrapper);
//        log.info(yonghuguanli.toString());

        if (zulinhetongService.save(zulinhetong)) {
            String xiaoxiNeiRong = "有租赁合同需要审批, 合同编号:" + zulinhetong.getHetongbianhao() + ", 负责业务员:" + UserHolder.getUser().getUsername();
            Map<String, String> xiaoxi = new HashMap<>();
            xiaoxi.put("neirong", xiaoxiNeiRong);
            xiaoxi.put("type", "info");
            // xiaoxi.put
//            System.out.println(yonghuguanli.getLeader());
            WebSocketServer.sendInfo(yonghuguanli.getLeader(), xiaoxi.toString());
            Xiaoxituisonglog xiaoxituisonglog = new Xiaoxituisonglog();
            xiaoxituisonglog.setXiaoxineirong(xiaoxiNeiRong);
            xiaoxituisonglog.setFasongfangid(UserHolder.getUser().getUsername());
            xiaoxituisonglog.setJieshoufangid(yonghuguanli.getLeader());
            xiaoxituisonglog.setType("info");
            xiaoxituisonglog.setInserttime(LocalDateTime.now().toString());
            xiaoxituisonglogService.save(xiaoxituisonglog);

            Liuchengjilu liuchengjilu = new Liuchengjilu();
            liuchengjilu.setYonghuming(UserHolder.getUser().getUsername());
            liuchengjilu.setLiuchengmingcheng("租赁合同审批");
            liuchengjilu.setShunxu("0");
            liuchengjilu.setYewubiaoshi(zulinhetong.getHetongbianhao());
            liuchengjilu.setTime(LocalDateTime.now().toString());
            liuchengjilu.setChulijieguo("待审核");
            liuchengjilu.setBeizhu("null");

            liuchengjiluService.save(liuchengjilu);
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Zulinhetong zulinhetong) {

        if (zulinhetongService.updateById(zulinhetong)) {
            QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
            yonghuguanliQueryWrapper.eq("YongHuMing", UserHolder.getUser().getUsername());
            Yonghuguanli yonghuguanli = yonghuguanliService.getOne(yonghuguanliQueryWrapper);

            String xiaoxiNeiRong = "有租赁合同需要审批, 合同编号:" + zulinhetong.getHetongbianhao() + ", 负责业务员:" + UserHolder.getUser().getUsername();
            Map<String, String> xiaoxi = new HashMap<>();
            xiaoxi.put("neirong", xiaoxiNeiRong);
            xiaoxi.put("type", "info");
            // xiaoxi.put
//            System.out.println(yonghuguanli.getLeader());
            WebSocketServer.sendInfo(yonghuguanli.getLeader(), xiaoxi.toString());
            Xiaoxituisonglog xiaoxituisonglog = new Xiaoxituisonglog();
            xiaoxituisonglog.setXiaoxineirong(xiaoxiNeiRong);
            xiaoxituisonglog.setFasongfangid(UserHolder.getUser().getUsername());
            xiaoxituisonglog.setJieshoufangid(yonghuguanli.getLeader());
            xiaoxituisonglog.setType("info");
            xiaoxituisonglog.setInserttime(LocalDateTime.now().toString());
            xiaoxituisonglogService.save(xiaoxituisonglog);

            Liuchengjilu liuchengjilu = new Liuchengjilu();
            liuchengjilu.setYonghuming(UserHolder.getUser().getUsername());
            liuchengjilu.setLiuchengmingcheng("租赁合同审批");
            liuchengjilu.setShunxu("0");
            liuchengjilu.setYewubiaoshi(zulinhetong.getHetongbianhao());
            liuchengjilu.setTime(LocalDateTime.now().toString());
            liuchengjilu.setChulijieguo("待审核");
            liuchengjilu.setBeizhu("null");
            liuchengjiluService.save(liuchengjilu);

            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id) {
        Zulinhetong hetong = zulinhetongService.getById(id);
        hetong.setHetongzhixingjindu("已作废");
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("id", id);
        if (zulinhetongService.update(hetong, zulinhetongQueryWrapper)) {
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    /**
     * 通过拍照添加合同信息
     */
    @PostMapping(value = "/photoOCR", headers = "Content-Type=multipart/form-data")
//    public ResponseResult<?> photoOCR(@RequestParam(value = "files") List<MultipartFile> files) throws IOException {
    public ResponseResult<?> photoOCR(MultipartRequest files) throws IOException {
//        System.out.println(files.get(0));
        Map<String, String> contents = new HashMap<>();
        contents.put("合同编号", "合同编号：(.*)");
        contents.put("承租单位", "承租方：(.*)");
        contents.put("出租单位", "出租方：(.*)");
        contents.put("项目名称", "(项目名称|工程名称)：(.*)");
        contents.put("项目地址", "(项目地址|工程地点)：(.*)");
        contents.put("开户行", "(开户银行|开户行)：(.*)");
        contents.put("账号", "账号：(.*)");
        Map<String, Object> returnMap = new HashMap<>();
        Map<String, Integer> keyCount = new HashMap<>();
        log.info(files.toString());
        Map<String, MultipartFile> fileMap = files.getFileMap();
        log.warn("Length:" + fileMap.size());
        for (MultipartFile file : fileMap.values()) {
            System.out.println("文件名为:" + file.getOriginalFilename());
            List<MultipartFile> fileList = files.getFiles("files");
//        for(MultipartFile file : files) {
            log.info(String.valueOf(fileList.size()));
//        for(MultipartFile file : fileList) {
            log.warn("图片名:" + file.getOriginalFilename());
            String OCRJson = AccurateBasic.accurateBasic(file.getBytes());
            log.warn(OCRJson);
            if (OCRJson == null) {
                continue;
            }
            JSONObject obj = new JSONObject(OCRJson);
            JSONArray wordsResults = obj.getJSONArray("words_result");
//                {"合同编号：(.*)", "承租方：(.*)", "出租方：(.*)", "(项目名称|工程名称)：(.*)", "(项目地址|工程地点)：(.*)", "(开户银行|开户行)：(.*)", "账号：(.*)"};
            for (int i = 0; i < wordsResults.length(); i++) {
                String word = wordsResults.getJSONObject(i).getString("words");
                for (Map.Entry<String, String> entry : contents.entrySet()) {
                    Pattern pattern = Pattern.compile(entry.getValue());
                    Matcher matcher = pattern.matcher(word);
                    int index = 1;
                    if (entry.getValue().contains("|")) {
                        index = 2;
                    }
                    if (matcher.find()) {
                        String key = entry.getKey();
                        if (returnMap.containsKey(key)) {
//                            Integer count = keyCount.getOrDefault(key, 0) + 1;
//                            keyCount.put(key, count);
//                            key = key + "_" + count;
                            Object dValue = returnMap.get(key);
                            ArrayList<String> list;
                            if (dValue instanceof ArrayList) {
                                list = (ArrayList<String>) dValue;
                            } else {
                                list = new ArrayList<>();
                                list.add(dValue.toString());
                            }
                            list.add(matcher.group(index));
                            returnMap.put(key, list);
                        } else {
                            returnMap.put(key, matcher.group(index));
                        }
                    }
                }
            }
        }
        if (returnMap.isEmpty()) {
            throw new RuntimeException("系统异常，联系管理员");
        }
        return ResponseResult.okResult(200, "操作成功", returnMap);
    }

    /**
     * 获取一分合同清单的详细信息
     *
     * @param id 数据表ID
     * @return map
     */
    @GetMapping("/detail/{id}")
    public ResponseResult<?> getDetail(@PathVariable Long id) {
        Map<String, Object> returnMap = new HashMap<>();
        Zulinhetong zulinhetong = zulinhetongService.getById(id);
        if (zulinhetong == null) {
            return ResponseResult.errorResult(500, "合同索引错误");
        }
        returnMap.put("ZuLinHeTong", zulinhetong);

        String HeTongBianHao = zulinhetong.getHetongbianhao();

        QueryWrapper<Zulinhetongwuliao> zulinhetongwuliaoQueryWrapper = new QueryWrapper<>();
        zulinhetongwuliaoQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        returnMap.put("ZuLinHeTongWuLiao", zulinhetongwuliaoService.list(zulinhetongwuliaoQueryWrapper));

//        QueryWrapper<Zulinjiesuan> zulinjiesuanQueryWrapper = new QueryWrapper<>();
//        zulinjiesuanQueryWrapper.eq("HeTongBianHao",HeTongBianHao);
//        returnMap.put("ZuLinJieSuan", zulinjiesuanService.getOne(zulinjiesuanQueryWrapper));

        QueryWrapper<Fukuanjiedian> fukuanjiedianQueryWrapper = new QueryWrapper<>();
        fukuanjiedianQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        returnMap.put("FuKuanJieDian", fukuanjiedianService.list(fukuanjiedianQueryWrapper));

        log.info(returnMap.toString());
        if (!returnMap.isEmpty()) {
            return ResponseResult.okResult(200, "success", returnMap);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }


    @Autowired
    private Ziliao4zulinhetongServiceImpl ziliao4zulinhetongService;
    //    @PostMapping(value = "/photoOCR", headers = "Content-Type=multipart/form-data")
////    public ResponseResult<?> photoOCR(@RequestParam(value = "files") List<MultipartFile> files) throws IOException {
//    public ResponseResult<?> photoOCR(MultipartRequest files) throws IOException {
    @Transactional
    @PostMapping(value = "/materialSubmit/{HeTongBianHao}", headers = "Content-Type=multipart/form-data")
    public ResponseResult<?> materialSubmit(@PathVariable String HeTongBianHao, MultipartRequest files) throws IOException {
        // List<MultipartFile> fileMap = (List<MultipartFile>) files.getFileMap().values();
        Map<String, MultipartFile> fileMap1 = files.getFileMap();
        List<MultipartFile> fileMap = new ArrayList<>();
        Set<Map.Entry<String, MultipartFile>> entries = fileMap1.entrySet();
        for (Map.Entry<String, MultipartFile> entry : entries) {
            fileMap.add(entry.getValue());
        }
        if (fileMap.isEmpty()) {
            return ResponseResult.errorResult(500, "合同资料为空");
        }
        Map<String, String> url2Files = SaveLocal.saveFileLocal(fileMap, HeTongBianHao);
        if (url2Files.size() != fileMap.size()) {
            throw new RuntimeException("合同资料保存失败.");
        }
        List<Ziliao4zulinhetong> ziliao4zulinhetongs = new ArrayList<>();
        for (Map.Entry<String, String> entry : url2Files.entrySet()) {
            Ziliao4zulinhetong ziliao4zulinhetong = new Ziliao4zulinhetong();
            ziliao4zulinhetong.setHetongbianhao(HeTongBianHao);
            ziliao4zulinhetong.setZiliaomingcheng(entry.getKey());
            ziliao4zulinhetong.setZiliaopath(entry.getValue());
            ziliao4zulinhetongs.add(ziliao4zulinhetong);
        }
        // TODO 可以抽取出公共代码丢Ziliao4zulinhetongServiceImpl里
        //   for(Ziliao4zulinhetong item : ziliao4zulinhetongs){
        //        ziliao4zulinhetongService.save(item);
        //    }
        if (!ziliao4zulinhetongService.saveBatch(ziliao4zulinhetongs)) {
            throw new RuntimeException("合同保存失败.");
        }
//        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
//        zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
//        Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
//        zulinhetong.setHetongtupian(ziliao4zulinhetongs.toString());
//        if (!zulinhetongService.update(zulinhetong, zulinhetongQueryWrapper)) {
//            throw new RuntimeException("合同资料保存失败.");
//        }
        log.info("合同{" + HeTongBianHao + "}资料保存");
        return ResponseResult.okResult(200, "操作成功", ziliao4zulinhetongs);
    }
//    @PostMapping(value = "/materialSubmit/{HeTongBianHao}", headers = "Content-Type=multipart/form-data")
//    public ResponseResult<?> materialSubmit(@PathVariable("HeTongBianHao") String HeTongBianHao, MultipartRequest files) throws IOException {
//        Map<String, MultipartFile> files_map = files.getFileMap();
//        List<MultipartFile> fileMap = new ArrayList<>(files_map.values());
////        List<MultipartFile> fileMap = (List<MultipartFile>) files.getFileMap().values();
//
//        if (fileMap.isEmpty()) {
//            return ResponseResult.errorResult(500, "合同资料为空");
//        }
//        log.warn("length4Files:"+fileMap.size());
//        Map<String, String> url2Files = SaveLocal.saveFileLocal(fileMap, "\\ZuLinHeTongGuanli\\" + HeTongBianHao);
//        log.warn(url2Files.toString());
//        if (url2Files.size() != fileMap.size()) {
//            throw new RuntimeException("合同资料保存失败.");
//        }
//        List<Ziliao4zulinhetong> ziliao4zulinhetongs = new ArrayList<>();
//        for (Map.Entry<String, String> entry : url2Files.entrySet()) {
//            Ziliao4zulinhetong ziliao4zulinhetong = new Ziliao4zulinhetong();
//            ziliao4zulinhetong.setHetongbianhao(HeTongBianHao);
//            ziliao4zulinhetong.setZiliaomingcheng(entry.getKey());
//            ziliao4zulinhetong.setZiliaopath(entry.getValue());
//            ziliao4zulinhetongs.add(ziliao4zulinhetong);
//        }
//        // TODO 可以抽取出公共代码丢Ziliao4zulinhetongServiceImpl里
//        if (!ziliao4zulinhetongService.saveBatch(ziliao4zulinhetongs)) {
//            throw new RuntimeException("合同保存失败.");
//        }
//        log.info("ZiLiao4ZuLinHeTong:"+ziliao4zulinhetongs);
//        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
//        zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
//        Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
//        zulinhetong.setHetongtupian(url2Files.toString());
//        if (!zulinhetongService.update(zulinhetong, zulinhetongQueryWrapper)) {
//            throw new RuntimeException("合同资料保存失败.");
//        }
//        log.info("合同{" + HeTongBianHao + "}资料保存");
//        return ResponseResult.okResult(200, "操作成功", null);
//    }

    @PostMapping("/materialAdd/{HeTongBianHao}")
//    public ResponseResult<?> materialAdd(@PathVariable String HeTongBianHao, @RequestParam(value = "files") List<MultipartFile> files) throws IOException {
    public ResponseResult<?> materialAdd(@PathVariable String HeTongBianHao, MultipartRequest files) throws IOException {
        Map<String, MultipartFile> fileMap1 = files.getFileMap();
        List<MultipartFile> fileMap = new ArrayList<>();
        Set<Map.Entry<String, MultipartFile>> entries = fileMap1.entrySet();
        for (Map.Entry<String, MultipartFile> entry : entries) {
            fileMap.add(entry.getValue());
        }
        if (fileMap.isEmpty()) {
            return ResponseResult.errorResult(500, "合同资料为空");
        }
        Map<String, String> url2Files = SaveLocal.saveFileLocal(fileMap, "\\ZuLinHeTongGuanli\\" + HeTongBianHao);
        if (url2Files.size() != fileMap.size()) {
            throw new RuntimeException("合同资料保存失败.");
        }
        QueryWrapper<Ziliao4zulinhetong> ziliao4zulinhetongQueryWrapper = new QueryWrapper<>();
        ziliao4zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        List<Ziliao4zulinhetong> list = ziliao4zulinhetongService.list(ziliao4zulinhetongQueryWrapper);
        List<Ziliao4zulinhetong> ziliao4zulinhetongs = new ArrayList<>();
        for (Map.Entry<String, String> entry : url2Files.entrySet()) {
            Ziliao4zulinhetong ziliao4zulinhetong = new Ziliao4zulinhetong();
            ziliao4zulinhetong.setHetongbianhao(HeTongBianHao);
            ziliao4zulinhetong.setZiliaomingcheng(entry.getKey());
            ziliao4zulinhetong.setZiliaopath(entry.getValue());
            ziliao4zulinhetongs.add(ziliao4zulinhetong);
        }

        list.addAll(ziliao4zulinhetongs);

        if (!ziliao4zulinhetongService.saveBatch(list)) {
            throw new RuntimeException("合同保存失败.");
        }

        // TODO: 这里关于ZuLinHeTong里的
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
        zulinhetong.setHetongtupian(list.toString());
        if (!zulinhetongService.update(zulinhetong, zulinhetongQueryWrapper)) {
            throw new RuntimeException("合同保存失败.");
        }
        log.info("合同" + HeTongBianHao + "保存");
        return ResponseResult.okResult(200, "操作成功", null);
    }

//    @PostMapping("/materialAdd/{HeTongBianHao}")
////    public ResponseResult<?> materialAdd(@PathVariable String HeTongBianHao, @RequestParam(value = "files") List<MultipartFile> files) throws IOException {
//    public ResponseResult<?> materialAdd(@PathVariable String HeTongBianHao, MultipartRequest files) throws IOException {
//        Map<String, MultipartFile> fileMap1 = files.getFileMap();
//        List<MultipartFile> fileMap = new ArrayList<>();
//        Set<Map.Entry<String, MultipartFile>> entries = fileMap1.entrySet();
//        for (Map.Entry<String, MultipartFile> entry : entries) {
//            fileMap.add(entry.getValue());
//        }
//        if (fileMap.isEmpty()) {
//            return ResponseResult.errorResult(500, "合同资料为空");
//        }
//        Map<String, String> url2Files = SaveLocal.saveFileLocal(fileMap, "\\ZuLinHeTongGuanli\\" + HeTongBianHao);
//        if (url2Files.size() != fileMap.size()) {
//            throw new RuntimeException("合同资料保存失败.");
//        }
//        QueryWrapper<Ziliao4zulinhetong> ziliao4zulinhetongQueryWrapper = new QueryWrapper<>();
//        ziliao4zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
//        List<Ziliao4zulinhetong> list = ziliao4zulinhetongService.list(ziliao4zulinhetongQueryWrapper);
//        List<Ziliao4zulinhetong> ziliao4zulinhetongs = new ArrayList<>();
//        for (Map.Entry<String, String> entry : url2Files.entrySet()) {
//            Ziliao4zulinhetong ziliao4zulinhetong = new Ziliao4zulinhetong();
//            ziliao4zulinhetong.setHetongbianhao(HeTongBianHao);
//            ziliao4zulinhetong.setZiliaomingcheng(entry.getKey());
//            ziliao4zulinhetong.setZiliaopath(entry.getValue());
//            ziliao4zulinhetongs.add(ziliao4zulinhetong);
//        }
//
//        list.addAll(ziliao4zulinhetongs);
//
//        if (!ziliao4zulinhetongService.saveBatch(list)) {
//            throw new RuntimeException("合同资料保存失败.");
//        }
//
//        // TODO: 这里关于ZuLinHeTong里的
//        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
//        zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
//        Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
//        zulinhetong.setHetongtupian(list.toString());
//        if (!zulinhetongService.update(zulinhetong, zulinhetongQueryWrapper)) {
//            throw new RuntimeException("合同更新失败.");
//        }
//        log.info("合同" + HeTongBianHao + "保存");
//        return ResponseResult.okResult(200, "操作成功", null);
//    }


    @Transactional
    @PostMapping("/materialDelete/{HeTongBianHao}")
//    public ResponseResult<?> materialAdd(@PathVariable String HeTongBianHao, @RequestParam(value = "files") List<MultipartFile> files) throws IOException {
    public ResponseResult<?> materialDelete(@PathVariable String HeTongBianHao, List<String> ziliao2Delete) throws IOException {
        QueryWrapper<Ziliao4zulinhetong> ziliao4zulinhetongQueryWrapper = new QueryWrapper<>();
        ziliao4zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao).in("ZiLiaoMingCheng", ziliao2Delete);
        if (ziliao4zulinhetongService.remove(ziliao4zulinhetongQueryWrapper)){
            return ResponseResult.okResult(200, "资料删除成功", null);
        }
        ziliao4zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        List<Ziliao4zulinhetong> list = ziliao4zulinhetongService.list(ziliao4zulinhetongQueryWrapper);
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
        zulinhetong.setHetongtupian(list.toString());
        if (!zulinhetongService.update(zulinhetong, zulinhetongQueryWrapper)) {
            throw new RuntimeException("合同保存失败.");
        }
        log.info("合同" + HeTongBianHao + "保存");
        return ResponseResult.okResult(200, "操作成功", null);
    }

    @PostMapping("/shenHe")
    public ResponseResult<?> examineHeTong(Map<String, String> map){
        Liuchengjilu liuchengjilu = new Liuchengjilu();
        liuchengjilu.setYonghuming(map.get("YongHuMing"));
        liuchengjilu.setLiuchengmingcheng("租赁合同审批");

        QueryWrapper<Liuchengdingyi> liuchengdingyiQueryWrapper = new QueryWrapper<>();
        liuchengdingyiQueryWrapper.eq("LiuChengMingCheng", "租赁合同审批").eq("JueSe", UserHolder.getUser().getJueSe());
        Liuchengdingyi liuchengdingyi = liuchengdingyiService.getOne(liuchengdingyiQueryWrapper);

        liuchengjilu.setShunxu(liuchengdingyi.getShunxu());
        liuchengjilu.setYewubiaoshi(map.get("HeTongBianHao"));
        liuchengjilu.setChulijieguo(map.get("ChuLiJieGuo"));
        liuchengjilu.setTime(LocalDateTime.now().toString());
        liuchengjilu.setBeizhu(map.get("BeiZhu"));

        if (liuchengjiluService.save(liuchengjilu)) {
            String xiaoxiNeiRong = "合同编号:" + map.get("HeTongBianHao") + "审批结果为:" + map.get("ChuLiJieGuo")+".";
            Map<String, String> xiaoxi = new HashMap<>();
            xiaoxi.put("neirong", xiaoxiNeiRong);
            xiaoxi.put("type", "info");
            // xiaoxi.put
            WebSocketServer.sendInfo(map.get("YongHuMing"), xiaoxi.toString());
            Xiaoxituisonglog xiaoxituisonglog = new Xiaoxituisonglog();
            xiaoxituisonglog.setXiaoxineirong(xiaoxiNeiRong);
            xiaoxituisonglog.setFasongfangid(UserHolder.getUser().getUsername());
            xiaoxituisonglog.setJieshoufangid(map.get("YongHuMing"));
            xiaoxituisonglog.setType("info");
            xiaoxituisonglog.setInserttime(LocalDateTime.now().toString());
            xiaoxituisonglogService.save(xiaoxituisonglog);

            return ResponseResult.okResult(200, "操作成功", null);
        }else {
            throw  new RuntimeException("审核失败.");
        }
    }

    public List<String> getHeeler(String YongHuMing){
        QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
        yonghuguanliQueryWrapper.eq("Leader", YongHuMing).select("YongHuMing");
        List<Yonghuguanli> list = yonghuguanliService.list(yonghuguanliQueryWrapper);
        List<String> heeler = new ArrayList<>();
        for (Yonghuguanli yonghuguanli : list){
            heeler.add(yonghuguanli.getYonghuming());
        }
        log.info(heeler.toString());
        return heeler;
    }

    @GetMapping("/heelerHeTong")
    public ResponseResult<?> getHeelerHeTong(){
        List<String> heeler = getHeeler(UserHolder.getUser().getUsername());
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.in("YeWuYuan", heeler);
        List<Zulinhetong> list = zulinhetongService.list(zulinhetongQueryWrapper);
        return ResponseResult.okResult(200, "操作成功", list);
    }

    private List<Liuchengjilu> getShenPi(String YongHuMing){
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("YeWuYuan", YongHuMing);
        List<Zulinhetong> list = zulinhetongService.list(zulinhetongQueryWrapper);
        List<Liuchengjilu> liuchengjilus = new ArrayList<>();
        System.out.println(list);
        QueryWrapper<Liuchengjilu> liuchengjiluQueryWrapper = new QueryWrapper<>();
        for(Zulinhetong zulinhetong : list){
            liuchengjiluQueryWrapper.orderBy(true,false, "id" ).last("limit 1").eq("YeWuBiaoShi", zulinhetong.getHetongbianhao()).eq("YongHuMing", YongHuMing);
            Liuchengjilu liuchengjilu = liuchengjiluService.getOne(liuchengjiluQueryWrapper);
            if (liuchengjilu != null){
                liuchengjilus.add(liuchengjilu);
            }
        }
        log.warn(liuchengjilus.toString());
        return liuchengjilus;
    }

    @GetMapping("/shenpiList")
    public ResponseResult<?> shenpiList(){
        List<Liuchengjilu> shenPi = getShenPi(UserHolder.getUser().getUsername());
        return ResponseResult.okResult(200, "操作成功", shenPi);
    }

    private Map<String, Object> getHeTongShenPiJingDu(String HeTongBianHao){
        QueryWrapper<Liuchengdingyi> liuchengdingyiQueryWrapper = new QueryWrapper<>();
        liuchengdingyiQueryWrapper.eq("YeWuMingCheng", "租赁合同");
        List<Liuchengdingyi> list = liuchengdingyiService.list(liuchengdingyiQueryWrapper);

        QueryWrapper<Liuchengjilu> liuchengjiluQueryWrapper = new QueryWrapper<>();
        liuchengjiluQueryWrapper.orderBy(true,false, "id" ).last("limit 1").eq("YeWuBiaoShi", HeTongBianHao).eq("YongHuMing", UserHolder.getUser().getUsername());
        Liuchengjilu liuchengjilu = liuchengjiluService.getOne(liuchengjiluQueryWrapper);

        Map<String , Object> returnMap = new HashMap<>();
        returnMap.put("ShenPiLiuCheng", list);
        returnMap.put("ShenPiJinDu", liuchengjilu);
        return returnMap;
    }

    @GetMapping("/shenpiJinDu/{HeTongBianHao}")
    public ResponseResult<?> ShenPiJinDu(@PathVariable("HeTongBianHao") String HeTongBianHao){
        return ResponseResult.okResult(200, "ok", getHeTongShenPiJingDu(HeTongBianHao));
    }
}

