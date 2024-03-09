package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Fukuanjiedian;
import com.ins.anping.base.entity.Ziliao4zulinhetong;
import com.ins.anping.base.entity.Zulinhetong;
import com.ins.anping.base.entity.Zulinhetongwuliao;
import com.ins.anping.base.service.impl.*;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.OCRByBaiDu.AccurateBasic;
import com.ins.anping.utils.fileSave.SaveLocal;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 租赁合同 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Slf4j
@RestController
@RequestMapping("api/busi/table/zulinhetong")
public class ZulinhetongController {


    @Autowired
    private ZulinhetongServiceImpl  zulinhetongService;

    @ApiOperation("查询所有租赁合同")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Zulinhetong> list= zulinhetongService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Zulinhetong result = zulinhetongService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Zulinhetong> page){
        IPage<Zulinhetong> zulinhetongIPage= zulinhetongService.page(page);
        if(zulinhetongIPage != null) {
            return ResponseResult.okResult(200, "success", zulinhetongIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Zulinhetong zulinhetong){
        if (zulinhetongService.save(zulinhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Zulinhetong zulinhetong){
        if (zulinhetongService.updateById(zulinhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (zulinhetongService.removeById(id)){
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
        contents.put("承租方", "承租方：(.*)");
        contents.put("出租方", "出租方：(.*)");
        contents.put("项目名称", "(项目名称|工程名称)：(.*)");
        contents.put("项目地址", "(项目地址|工程地点)：(.*)");
        contents.put("开户行", "(开户银行|开户行)：(.*)");
        contents.put("账号", "账号：(.*)");
        Map<String, Object> returnMap = new HashMap<>();
        Map<String, Integer> keyCount = new HashMap<>();
        log.info(files.toString());
        Map<String, MultipartFile> fileMap = files.getFileMap();
        log.warn("Length:"+fileMap.size());
        for (MultipartFile file: fileMap.values()){

        System.out.println("文件名为:"+file.getOriginalFilename());
        List<MultipartFile> fileList = files.getFiles("files");
//        for(MultipartFile file : files) {
        log.info(String.valueOf(fileList.size()));
//        for(MultipartFile file : fileList) {
            log.warn("图片名:"+file.getOriginalFilename());
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
                        String key =entry.getKey();
//                        if (returnMap.get(entry.getKey()) != null) {
//                            returnMap.put(entry.getKey() + "_乙方", matcher.group(index));
//                        } else {
//                            returnMap.put(entry.getKey(), matcher.group(index));
//                        }
                        if(returnMap.containsKey(key)){
                            Integer count = keyCount.getOrDefault(key, 0)+1;
                            keyCount.put(key, count);
                            key = key+"_"+count;
                        }else {
                            keyCount.put(key, 1);
                        }
                        returnMap.put(key, matcher.group(index));
                    }
                }
            }
        }
        if (returnMap.isEmpty()){
            throw new RuntimeException("系统异常，联系管理员");
        }
        return ResponseResult.okResult(200, "操作成功", returnMap);
    }

    @Autowired
    private ZulinhetongwuliaoServiceImpl zulinhetongwuliaoService;

    @Autowired
    private ZulinjiesuanServiceImpl zulinjiesuanService;

    @Autowired
    private FukuanjiedianServiceImpl fukuanjiedianService;
    /**
     * 获取一分合同清单的详细信息
     * @param id 数据表ID
     * @return map
     */
    @GetMapping("/detail/{id}")
    public ResponseResult<?> getDetail(@PathVariable Long id){
        Map<String, Object> returnMap = new HashMap<>();
        Zulinhetong zulinhetong = zulinhetongService.getById(id);
        if (zulinhetong == null){
            return ResponseResult.errorResult(500, "合同索引错误");
        }
        returnMap.put("ZuLinHeTong", zulinhetong);

        String HeTongBianHao = zulinhetong.getHetongbianhao();

        QueryWrapper<Zulinhetongwuliao> zulinhetongwuliaoQueryWrapper = new QueryWrapper<>();
        zulinhetongwuliaoQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        returnMap.put("ZuLinHeTongWuLiao",  zulinhetongwuliaoService.list(zulinhetongwuliaoQueryWrapper));

//        QueryWrapper<Zulinjiesuan> zulinjiesuanQueryWrapper = new QueryWrapper<>();
//        zulinjiesuanQueryWrapper.eq("HeTongBianHao",HeTongBianHao);
//        returnMap.put("ZuLinJieSuan", zulinjiesuanService.getOne(zulinjiesuanQueryWrapper));

        QueryWrapper<Fukuanjiedian> fukuanjiedianQueryWrapper = new QueryWrapper<>();
        fukuanjiedianQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        returnMap.put("FuKuanJieDian", fukuanjiedianService.list(fukuanjiedianQueryWrapper));

        log.info(returnMap.toString());
        if(!returnMap.isEmpty()) {
            return ResponseResult.okResult(200, "success", returnMap);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }


    @Autowired
    private Ziliao4zulinhetongServiceImpl ziliao4zulinhetongService;
    //    @Transactional
    @PostMapping("/materialSubmit/{HeTongBianHao}")
    public ResponseResult<?> materialSubmit(@PathVariable String HeTongBianHao, @RequestParam(value = "files") List<MultipartFile> files) throws IOException {
        if (files.isEmpty()){
            return ResponseResult.errorResult(500, "合同资料为空");
        }
        Map<String, String> url2Files = SaveLocal.saveFileLocal(files, "\\ZuLinHeTongGuanli\\"+HeTongBianHao);
        if(url2Files.size() != files.size()){
            throw new RuntimeException("合同资料保存失败.");
        }
        List<Ziliao4zulinhetong> ziliao4zulinhetongs = new ArrayList<>();
        for(Map.Entry<String, String> entry : url2Files.entrySet()){
            Ziliao4zulinhetong ziliao4zulinhetong = new Ziliao4zulinhetong();
            ziliao4zulinhetong.setHetongbianhao(HeTongBianHao);
            ziliao4zulinhetong.setZiliaomingcheng(entry.getKey());
            ziliao4zulinhetong.setZiliaopath(entry.getValue());
            ziliao4zulinhetongs.add(ziliao4zulinhetong);
        }
        // TODO 可以抽取出公共代码丢Ziliao4zulinhetongServiceImpl里
        if(!ziliao4zulinhetongService.saveBatch(ziliao4zulinhetongs)){
            throw new RuntimeException("合同保存失败.");
        }
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper =new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
        zulinhetong.setHetongtupian(url2Files.toString());
        if (!zulinhetongService.update(zulinhetong, zulinhetongQueryWrapper)){
            throw new RuntimeException("合同资料保存失败.");
        }
        log.info("合同{"+HeTongBianHao+"}资料保存");
        return ResponseResult.okResult(200, "操作成功", null);
    }

    @PostMapping("/materialAdd/{HeTongBianHao}")
    public ResponseResult<?> materialAdd(@PathVariable String HeTongBianHao, @RequestParam(value = "files") List<MultipartFile> files) throws IOException {
        if (files.isEmpty()){
            return ResponseResult.errorResult(500, "合同照片为空");
        }
        Map<String, String> url2Files = SaveLocal.saveFileLocal(files, "\\ZuLinHeTongGuanli\\"+HeTongBianHao);

        if(url2Files.size() != files.size()){
            throw new RuntimeException("合同保存失败.");
        }
        List<Ziliao4zulinhetong> ziliao4zulinhetongs = new ArrayList<>();
        for(Map.Entry<String, String> entry : url2Files.entrySet()){
            Ziliao4zulinhetong ziliao4zulinhetong = new Ziliao4zulinhetong();
            ziliao4zulinhetong.setHetongbianhao(HeTongBianHao);
            ziliao4zulinhetong.setZiliaomingcheng(entry.getKey());
            ziliao4zulinhetong.setZiliaopath(entry.getValue());
            ziliao4zulinhetongs.add(ziliao4zulinhetong);
        }
        if(!ziliao4zulinhetongService.saveBatch(ziliao4zulinhetongs)){
            throw new RuntimeException("合同保存失败.");
        }

        // TODO: 这里关于ZuLinHeTong里的
        QueryWrapper<Zulinhetong> zulinhetongQueryWrapper =new QueryWrapper<>();
        zulinhetongQueryWrapper.eq("HeTongBianHao", HeTongBianHao);
        Zulinhetong zulinhetong = zulinhetongService.getOne(zulinhetongQueryWrapper);
        String savePath = zulinhetong.getHetongtupian();
        zulinhetong.setHetongtupian(url2Files+savePath);
        if (!zulinhetongService.update(zulinhetong, zulinhetongQueryWrapper)){
            throw new RuntimeException("合同保存失败.");
        }
        log.info("合同"+HeTongBianHao+"保存");
        return ResponseResult.okResult(200, "操作成功", null);
    }


}

