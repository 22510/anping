package com.ins.anping.base.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.*;
import com.ins.anping.base.service.impl.*;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.OCRByBaiDu.AccurateBasic;
import com.ins.anping.utils.UserHolder;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    private FukuanjiedianServiceImpl fukuanjiedianService;

    @Autowired
    private ZulinhetongServiceImpl zulinhetongService;

    @Autowired
    private YonghuguanliServiceImpl yonghuguanliService;

    @Autowired
    private DaibanshixiangServiceImpl daibanshixiangService;

    @ApiOperation("查询该业务员的所有租赁合同")
    @GetMapping("/list")
    public ResponseResult<?> list() {
        // 业务员: 看到自己的; 业务经理: 看到其下所有业务员的
        if (UserHolder.getUser().getJueSe().equals("8")) {
            QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
            System.out.println(UserHolder.getUser().getUsername());
            zulinhetongQueryWrapper.eq("YeWuYuan", UserHolder.getUser().getUsername());
            List<Zulinhetong> list = zulinhetongService.list(zulinhetongQueryWrapper);
            System.out.println(list.toString());
            if (!list.isEmpty()) {
                return ResponseResult.okResult(200, "success", list);
            }
            return ResponseResult.errorResult(500, "操作失败");
        } else {
            List<String> heeler = getHeeler(UserHolder.getUser().getUsername());
            QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
            zulinhetongQueryWrapper.in("YeWuYuan", heeler);
            List<Zulinhetong> list = zulinhetongService.list(zulinhetongQueryWrapper);
            return ResponseResult.okResult(200, "操作成功", list);
        }
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
    private LiuchengdingyiServiceImpl liuchengdingyiService;

    @Autowired
    private LiuchengjiluServiceImpl liuchengjiluService;

    @Autowired
    private MessageLogServiceImpl messageLogService;

    @Autowired
    private ZulinhetongwuliaoServiceImpl zulinhetongwuliaoService;

    /**
     * 合同初次录入, 新的合同流程建立
     */
    @Transactional
    @PostMapping
    public ResponseResult<?> save(@RequestBody Map<String, Object> map) {

//        租赁合同信息保存
        Zulinhetong zulinhetong = BeanUtil.toBean(map, Zulinhetong.class);
        QueryWrapper<Ziliao4zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("HeTongBianHao", zulinhetong.getHetongbianhao());
        zulinhetong.setHetongtupian(ziliao4zulinhetongService.list(zulinhetongQueryWrapper)
                .stream()
                .map(Ziliao4zulinhetong::getZiliaopath)
                .collect(Collectors.joining(", "))); // 使用String.join而不是List的toString，以获得更好的格式控制
        zulinhetong.setHetongzhixingjindu("待审核");
        QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
        yonghuguanliQueryWrapper.eq("YongHuMing", UserHolder.getUser().getUsername());
        Yonghuguanli yonghuguanli = yonghuguanliService.getOne(yonghuguanliQueryWrapper);
        log.warn(zulinhetong.toString());
        boolean zulinhetong_save = zulinhetongService.save(zulinhetong);

//        合同物料信息保存, 调用合同物料的Controller吧.


//        通知相关部门
        if (zulinhetong_save) {
            LocalDate today = LocalDate.now();
//            通知业务经理, 审核合同
            Liuchengjilu liuchengjilu_yewujinglishenhe = new Liuchengjilu();
            liuchengjilu_yewujinglishenhe.setYonghuming(UserHolder.getUser().getUsername());
            liuchengjilu_yewujinglishenhe.setLiuchengmingcheng("租赁合同相关流程");
            liuchengjilu_yewujinglishenhe.setShunxu("0");
            liuchengjilu_yewujinglishenhe.setYewubiaoshi(zulinhetong.getHetongbianhao());
            liuchengjilu_yewujinglishenhe.setTime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            liuchengjilu_yewujinglishenhe.setChulijieguo("待审核");
            liuchengjilu_yewujinglishenhe.setBeizhu("null");
            liuchengjiluService.save(liuchengjilu_yewujinglishenhe);

            Daibanshixiang daibanshixiang_yewujingli = new Daibanshixiang();
            daibanshixiang_yewujingli.setStatu("未完成");
            daibanshixiang_yewujingli.setShixiangming("合同待审核");
            daibanshixiang_yewujingli.setZhongyaochengdu("比较紧急");
            daibanshixiang_yewujingli.setYonghuming(yonghuguanli.getLeader());
            daibanshixiang_yewujingli.setNeirong("待审核, 合同编号"+zulinhetong.getHetongbianhao()+", 负责业务员:"+zulinhetong.getYewuyuan());
            daibanshixiang_yewujingli.setInserttime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiang_yewujingli.setEndtime(today.plusDays(3).format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiangService.save(daibanshixiang_yewujingli);

            MessageLog messageLog_yewujingli = BeanUtil.toBean(map, MessageLog.class);
            messageLog_yewujingli.setIsSystemMessage("false");
            messageLog_yewujingli.setSendTime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            messageLog_yewujingli.setStatus("no");
            messageLog_yewujingli.setType("warn");
            messageLogService.save(messageLog_yewujingli);
//            通知库房, 检查库房存量, 判断是否需要转租业务
            /**
             * TODO: 库房相关待完善:
             * 1. 合同物料录入
             */
            //            List<Zulinhetongwuliao> zulinhetongwuliao_list = new ArrayList<>();
            //            // 从前端传回的内容取, 假设是个List
            //            map.get("合同物料");
            //            zulinhetongwuliao_list.add(new Zulinhetongwuliao());
            //            zulinhetongwuliaoService.saveBatch(zulinhetongwuliao_list);

            Daibanshixiang daibanshixiang_kufang = new Daibanshixiang();
            daibanshixiang_kufang.setStatu("未完成");
            daibanshixiang_kufang.setShixiangming("合同待备货");
            daibanshixiang_kufang.setZhongyaochengdu("比较紧急");
            daibanshixiang_kufang.setYonghuming("库房名字");
            daibanshixiang_kufang.setNeirong("待备货, 合同编号"+zulinhetong.getHetongbianhao()+", 负责业务员:"+zulinhetong.getYewuyuan());
            daibanshixiang_kufang.setInserttime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiang_kufang.setEndtime(today.plusDays(3).format(DateTimeFormatter.ISO_LOCAL_DATE));

            MessageLog messageLog_kufang = BeanUtil.toBean(map, MessageLog.class);
            messageLog_kufang.setIsSystemMessage("false");
            messageLog_kufang.setSendTime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            messageLog_kufang.setStatus("no");
            messageLog_kufang.setType("warn");
            messageLogService.save(messageLog_kufang);

            // TODO: 待思考, 可能这套消息系统是冗余的...
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    /**
     * 合同相关内容更新
     */
    @Transactional
    @PutMapping
    public ResponseResult<?> updateById(Map<String, Object> map) {
        Zulinhetong zulinhetong = BeanUtil.toBean(map, Zulinhetong.class);
        boolean hetong_update = zulinhetongService.updateById(zulinhetong);
        if (hetong_update) {
            /**
             * 合同状态修改, 需要通知业务经理和库房查看合同内容.
             */
            QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
            yonghuguanliQueryWrapper.eq("YongHuMing", UserHolder.getUser().getUsername());
            Yonghuguanli yonghuguanli = yonghuguanliService.getOne(yonghuguanliQueryWrapper);

            LocalDate today = LocalDate.now();
//            通知业务经理, 审核合同
            Liuchengjilu liuchengjilu_yewujinglishenhe = new Liuchengjilu();
            liuchengjilu_yewujinglishenhe.setYonghuming(UserHolder.getUser().getUsername());
            liuchengjilu_yewujinglishenhe.setLiuchengmingcheng("租赁合同相关流程");
            liuchengjilu_yewujinglishenhe.setShunxu("0");
            liuchengjilu_yewujinglishenhe.setYewubiaoshi(zulinhetong.getHetongbianhao());
            liuchengjilu_yewujinglishenhe.setTime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            liuchengjilu_yewujinglishenhe.setChulijieguo("待审核");
            liuchengjilu_yewujinglishenhe.setBeizhu("null");
            liuchengjiluService.save(liuchengjilu_yewujinglishenhe);

            Daibanshixiang daibanshixiang_yewujingli = new Daibanshixiang();
            daibanshixiang_yewujingli.setStatu("未完成");
            daibanshixiang_yewujingli.setShixiangming("合同待审核");
            daibanshixiang_yewujingli.setZhongyaochengdu("比较紧急");
            daibanshixiang_yewujingli.setYonghuming(yonghuguanli.getLeader());
            daibanshixiang_yewujingli.setNeirong("待审核, 合同编号"+zulinhetong.getHetongbianhao()+", 负责业务员:"+zulinhetong.getYewuyuan());
            daibanshixiang_yewujingli.setInserttime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiang_yewujingli.setEndtime(today.plusDays(3).format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiangService.save(daibanshixiang_yewujingli);

            MessageLog messageLog_yewujingli = BeanUtil.toBean(map, MessageLog.class);
            messageLog_yewujingli.setIsSystemMessage("false");
            messageLog_yewujingli.setSendTime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            messageLog_yewujingli.setStatus("no");
            messageLog_yewujingli.setType("warn");
            messageLogService.save(messageLog_yewujingli);
//            通知库房, 检查库房存量, 判断是否需要转租业务
            /**
             * TODO: 库房相关待完善:
             * 1. 合同物料录入
             */
            //            List<Zulinhetongwuliao> zulinhetongwuliao_list = new ArrayList<>();
            //            // 从前端传回的内容取, 假设是个List
            //            map.get("合同物料");
            //            zulinhetongwuliao_list.add(new Zulinhetongwuliao());
            //            zulinhetongwuliaoService.saveBatch(zulinhetongwuliao_list);

            Daibanshixiang daibanshixiang_kufang = new Daibanshixiang();
            daibanshixiang_kufang.setStatu("未完成");
            daibanshixiang_kufang.setShixiangming("合同待备货");
            daibanshixiang_kufang.setZhongyaochengdu("比较紧急");
            daibanshixiang_kufang.setYonghuming("库房名字");
            daibanshixiang_kufang.setNeirong("待备货, 合同编号"+zulinhetong.getHetongbianhao()+", 负责业务员:"+zulinhetong.getYewuyuan());
            daibanshixiang_kufang.setInserttime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiang_kufang.setEndtime(today.plusDays(3).format(DateTimeFormatter.ISO_LOCAL_DATE));

            MessageLog messageLog_kufang = BeanUtil.toBean(map, MessageLog.class);
            messageLog_kufang.setIsSystemMessage("false");
            messageLog_kufang.setSendTime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            messageLog_kufang.setStatus("no");
            messageLog_kufang.setType("warn");
            messageLogService.save(messageLog_kufang);

            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    /**
     * 删除合同
     */
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
        Map<String, List<String>> returnMap = new HashMap<>();
//        log.info(files.toString());
        Map<String, MultipartFile> fileMap = files.getFileMap();
        log.warn("Files Length:" + fileMap.size());
        for (MultipartFile file : fileMap.values()) {
            System.out.println("文件名为:" + file.getOriginalFilename());
            List<MultipartFile> fileList = files.getFiles("files");
//        for(MultipartFile file : files) {
//        for(MultipartFile file : fileList) {
            String OCRJson = AccurateBasic.accurateBasic(file.getBytes());
            log.warn("识别结果"+OCRJson);
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
//                        if (returnMap.containsKey(key)) {
////                            Integer count = keyCount.getOrDefault(key, 0) + 1;
////                            keyCount.put(key, count);
////                            key = key + "_" + count;
//                            Object dValue = returnMap.get(key);
//                            ArrayList<String> list;
//                            if (dValue instanceof ArrayList) {
//                                list = (ArrayList<String>) dValue;
//                            } else {
//                                list = new ArrayList<>();
//                                list.add(dValue.toString());
//                            }
//                            list.add(matcher.group(index));
//                            returnMap.put(key, list);
//                        } else {
//                            returnMap.put(key, matcher.group(index));
//                        }
                        returnMap.computeIfAbsent(key, k-> new ArrayList<>()).add(matcher.group(index));
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

    /**
     * 合同附件提交
     */
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

    /**
     * 合同附件添加 ( 提交后补交 )
     */
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
        if (ziliao4zulinhetongService.remove(ziliao4zulinhetongQueryWrapper)) {
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

    @Transactional
    @PostMapping("/shenPi")
    public ResponseResult<?> examineHeTong(@RequestBody Map<String, String> map) {
        Liuchengjilu liuchengjilu = new Liuchengjilu();
        liuchengjilu.setYonghuming(map.get("YongHuMing"));
        liuchengjilu.setLiuchengmingcheng("租赁合同审批");

        QueryWrapper<Liuchengdingyi> liuchengdingyiQueryWrapper = new QueryWrapper<>();
        liuchengdingyiQueryWrapper.and(wrapper->wrapper.eq("LiuChengMing", "租赁合同审批").eq("JueSe", UserHolder.getUser().getJueSe()));
        Liuchengdingyi liuchengdingyi = liuchengdingyiService.getOne(liuchengdingyiQueryWrapper);

        QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
        yonghuguanliQueryWrapper.eq("YongHuMing", UserHolder.getUser().getUsername());
        Yonghuguanli yonghuguanli = yonghuguanliService.getOne(yonghuguanliQueryWrapper);

        if (map.get("ChuLiJieGuo").equals("通过")) {
            liuchengjilu.setShunxu(liuchengdingyi.getShunxu());
            QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
            zulinhetongQueryWrapper.eq("HeTongBianHao", map.get("HeTongBianHao"));
            Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
            zulinhetong.setHetongzhixingjindu("审核中");
            zulinhetongService.updateById(zulinhetong);

            Daibanshixiang daibanshixiang = new Daibanshixiang();
            daibanshixiang.setStatu("未完成");
            daibanshixiang.setShixiangming("合同待发货");
            daibanshixiang.setZhongyaochengdu("比较紧急");
            daibanshixiang.setYonghuming(yonghuguanli.getLeader());
            daibanshixiang.setNeirong("合同编号"+map.get("HeTongBianHao"));
            LocalDate today = LocalDate.now();
            daibanshixiang.setInserttime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiang.setEndtime(today.plusDays(3).format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiangService.save(daibanshixiang);
        }else{
            liuchengjilu.setShunxu(String.valueOf(0));
            Daibanshixiang daibanshixiang = new Daibanshixiang();
            daibanshixiang.setStatu("未完成");
            daibanshixiang.setShixiangming("合同审核未通过");
            daibanshixiang.setZhongyaochengdu("非常紧急");
            daibanshixiang.setYonghuming(map.get("YongHuMing"));
            daibanshixiang.setNeirong("合同未通过审核, 审核拒绝人员:"+UserHolder.getUser().getUsername());
            LocalDate today = LocalDate.now();
            daibanshixiang.setInserttime(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiang.setEndtime(today.plusDays(3).format(DateTimeFormatter.ISO_LOCAL_DATE));
            daibanshixiangService.save(daibanshixiang);
        }
        liuchengjilu.setYewubiaoshi(map.get("HeTongBianHao"));
        liuchengjilu.setChulijieguo(map.get("ChuLiJieGuo"));
        liuchengjilu.setTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        liuchengjilu.setBeizhu(map.get("BeiZhu"));

        if (liuchengjiluService.save(liuchengjilu)) {
            log.warn("管理员审批...");
//            String xiaoxiNeiRong = "有租赁合同需要审批, 合同编号:" + zulinhetong.getHetongbianhao() + ", 负责业务员:" + UserHolder.getUser().getUsername();
//            Map<String, String> xiaoxi = new HashMap<>();
//            xiaoxi.put("neirong", xiaoxiNeiRong);
//            xiaoxi.put("type", "info");
//            // xiaoxi.put
////            System.out.println(yonghuguanli.getLeader());
//            JSONObject json = new JSONObject(xiaoxi);
//            WebSocketServer.sendInfo(yonghuguanli.getLeader(),json.toString());
//            String xiaoxiNeiRong = "合同编号:" + map.get("HeTongBianHao") + ", 审批结果为:" + map.get("ChuLiJieGuo") + ".";
//            Map<String, String> xiaoxi = new HashMap<>();
//            xiaoxi.put("title", "合同审批");
//            xiaoxi.put("neirong", xiaoxiNeiRong);
//            xiaoxi.put("type", "info");
//            // xiaoxi.put
//            JSONObject json = new JSONObject(xiaoxi);
//            WebSocketServer.sendInfo(map.get("YongHuMing"), json.toString());
//            Xiaoxituisonglog xiaoxituisonglog = new Xiaoxituisonglog();
//            xiaoxituisonglog.setXiaoxineirong(xiaoxiNeiRong);
//            xiaoxituisonglog.setFasongfangid(UserHolder.getUser().getUsername());
//            xiaoxituisonglog.setJieshoufangid(map.get("YongHuMing"));
//            xiaoxituisonglog.setType("info");
//            xiaoxituisonglog.setInserttime(LocalDateTime.now().toString());
//            xiaoxituisonglogService.save(xiaoxituisonglog);
            return ResponseResult.okResult(200, "操作成功", null);
        } else {
            throw new RuntimeException("审核失败.");
        }
    }

    public List<String> getHeeler(String YongHuMing) {
        QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
        yonghuguanliQueryWrapper.eq("Leader", YongHuMing).select("YongHuMing");
        List<Yonghuguanli> list = yonghuguanliService.list(yonghuguanliQueryWrapper);
        List<String> heeler = new ArrayList<>();
        for (Yonghuguanli yonghuguanli : list) {
            heeler.add(yonghuguanli.getYonghuming());
        }
        log.info(heeler.toString());
        return heeler;
    }

//    @GetMapping("/heelerHeTong")
//    public ResponseResult<?> getHeelerHeTong() {
//    }

    private List<Liuchengjilu> getShenPi(String YongHuMing) {
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper = new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("YeWuYuan", YongHuMing);
        List<Zulinhetong> list = zulinhetongService.list(zulinhetongQueryWrapper);
        List<Liuchengjilu> liuchengjilus = new ArrayList<>();
        System.out.println(list);
        QueryWrapper<Liuchengjilu> liuchengjiluQueryWrapper = new QueryWrapper<>();
        for (Zulinhetong zulinhetong : list) {
            liuchengjiluQueryWrapper.orderBy(true, false, "id").last("limit 1").eq("YeWuBiaoShi", zulinhetong.getHetongbianhao()).eq("YongHuMing", YongHuMing);
            Liuchengjilu liuchengjilu = liuchengjiluService.getOne(liuchengjiluQueryWrapper);
            if (liuchengjilu != null) {
                liuchengjilus.add(liuchengjilu);
            }
        }
        log.warn(liuchengjilus.toString());
        return liuchengjilus;
    }

    @GetMapping("/shenpiList")
    public ResponseResult<?> shenpiList() {
        List<Liuchengjilu> shenPi = getShenPi(UserHolder.getUser().getUsername());
        return ResponseResult.okResult(200, "操作成功", shenPi);
    }



    @GetMapping("/shenpiJinDu/{HeTongBianHao}/{YeWuYuan}")
    public ResponseResult<?> ShenPiJinDu(@PathVariable("HeTongBianHao") String HeTongBianHao, @PathVariable("YeWuYuan") String YeWuYuan) {
        return ResponseResult.okResult(200, "ok", getHeTongShenPiJingDu(HeTongBianHao, YeWuYuan));
    }

    private Map<String, Object> getHeTongShenPiJingDu(String HeTongBianHao, String YeWuYuan) {
        QueryWrapper<Liuchengdingyi> liuchengdingyiQueryWrapper = new QueryWrapper<>();
        liuchengdingyiQueryWrapper.eq("YeWuMingCheng", "租赁合同");
        List<Liuchengdingyi> list = liuchengdingyiService.list(liuchengdingyiQueryWrapper);

        QueryWrapper<Liuchengjilu> liuchengjiluQueryWrapper = new QueryWrapper<>();
//        liuchengjiluQueryWrapper.orderBy(true, false, "id").last("limit 1").eq("YeWuBiaoShi", HeTongBianHao).eq("YongHuMing", YeWuYuan);
        liuchengjiluQueryWrapper.orderBy(true, false, "id").eq("YeWuBiaoShi", HeTongBianHao).eq("YongHuMing", YeWuYuan);
//        Liuchengjilu liuchengjilu = liuchengjiluService.getOne(liuchengjiluQueryWrapper);
        List<Liuchengjilu> list1 = liuchengjiluService.list(liuchengjiluQueryWrapper);
        Liuchengjilu liuchengjilu = list1.get(0);
        int index = Integer.parseInt(liuchengjilu.getShunxu());
        List<Liuchengjilu> liuchengjiluInfo = new ArrayList<>();
        for (int i = 0; i < index; i++){
            liuchengjiluInfo.add(list1.get(i));
        }
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("ShenPiLiuCheng", list);
        returnMap.put("ShenPiJinDu", liuchengjilu);
        returnMap.put("ShenPiJiLu", liuchengjiluInfo);
        return returnMap;
    }
}

