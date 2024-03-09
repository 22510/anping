//package com.ins.anping.base.controller;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.ins.anping.base.entity.Zulinhetong;
//import com.ins.anping.base.service.impl.ZulinhetongServiceImpl;
//import com.ins.anping.model.common.ResponseResult;
//import com.ins.anping.utils.OCRByBaiDu.AccurateBasic;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * <p>
// * 租赁合同 前端控制器
// * </p>
// *
// * @author INS
// * @since 2024-03-06
// */
//@Slf4j
//@RestController
//@RequestMapping("api/busi/table/zulinhetong")
//public class ZulinhetongController {
//
//
//    @Autowired
//    private ZulinhetongServiceImpl  zulinhetongService;
//
//    @ApiOperation("查询所有租赁合同")
//    @GetMapping("")
//    public ResponseResult<?> list(){
//        List<Zulinhetong> list= zulinhetongService.list();
//        if(!list.isEmpty()){
//            return ResponseResult.okResult(200, "success", list);
//        }
//        return ResponseResult.errorResult(500, "操作失败");
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseResult<?> getById(@PathVariable Long id){
//        Zulinhetong result = zulinhetongService.getById(id);
//        if (result != null) {
//            return ResponseResult.okResult(200, "success", result);
//        }
//        return ResponseResult.errorResult(500, "操作失败");
//    }
//
//    @GetMapping("/page")
//    public ResponseResult<?> page(@RequestBody Page<Zulinhetong> page){
//        IPage<Zulinhetong> zulinhetongIPage= zulinhetongService.page(page);
//        if(zulinhetongIPage != null) {
//            return ResponseResult.okResult(200, "success", zulinhetongIPage);
//        }
//        return ResponseResult.errorResult(500, "操作失败");
//    }
//
//    @PostMapping
//    public ResponseResult<?> save(@RequestBody Zulinhetong zulinhetong){
//        if (zulinhetongService.save(zulinhetong)){
//            return ResponseResult.okResult(200, "操作成功", null);
//        }
//        return ResponseResult.errorResult(500, "操作失败");
//    }
//
//    @PutMapping
//    public ResponseResult<?> updateById(@RequestBody Zulinhetong zulinhetong){
//        if (zulinhetongService.updateById(zulinhetong)){
//            return ResponseResult.okResult(200, "操作成功", null);
//        }
//        return ResponseResult.errorResult(500, "操作失败");
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseResult<?> remove(@PathVariable Long id){
//        if (zulinhetongService.removeById(id)){
//            return ResponseResult.okResult(200, "success", null);
//        }
//        return ResponseResult.errorResult(500, "操作失败");
//    }
//
//    /**
//     * 通过拍照添加合同信息
//     * @param files
//     * @return
//     * @throws IOException
//     */
//    @PostMapping(value = "/photo")
//    public ResponseResult<?> photoOCR(@RequestParam(value = "files") List<MultipartFile> files) throws IOException {
//        Map<String, String> contents = new HashMap<>();
//        contents.put("合同编号", "合同编号：(.*)");
//        contents.put("承租方", "承租方：(.*)");
//        contents.put("出租方", "出租方：(.*)");
//        contents.put("项目名称", "(项目名称|工程名称)：(.*)");
//        contents.put("项目地址", "(项目地址|工程地点)：(.*)");
//        contents.put("开户行", "(开户银行|开户行)：(.*)");
//        contents.put("账号", "账号：(.*)");
//        Map<String, Object> returnMap = new HashMap<>();
//        for(MultipartFile file : files) {
//            String OCRJson = AccurateBasic.accurateBasic(file.getBytes());
//            log.warn(OCRJson);
//            if (OCRJson == null) {
//                continue;
//            }
//            JSONObject obj = new JSONObject(OCRJson);
//            JSONArray wordsResults = obj.getJSONArray("words_result");
////                {"合同编号：(.*)", "承租方：(.*)", "出租方：(.*)", "(项目名称|工程名称)：(.*)", "(项目地址|工程地点)：(.*)", "(开户银行|开户行)：(.*)", "账号：(.*)"};
//            LinkedList<String> content2Match = new LinkedList<>();
//            for (int i = 0; i < wordsResults.length(); i++) {
//                String word = wordsResults.getJSONObject(i).getString("words");
//                for (Map.Entry<String, String> entry : contents.entrySet()) {
//                    Pattern pattern = Pattern.compile(entry.getValue());
//                    Matcher matcher = pattern.matcher(word);
//                    int index = 1;
//                    if (entry.getValue().contains("|")) {
//                        index = 2;
//                    }
//                    if (matcher.find()) {
//                        if (returnMap.get(entry.getKey()) != null) {
//                            returnMap.put(entry.getKey() + "_乙方", matcher.group(index));
//                        } else {
//                            returnMap.put(entry.getKey(), matcher.group(index));
//                        }
//                    }
//                }
//            }
//        }
//        if (returnMap.isEmpty()){
//            throw new RuntimeException("系统异常，联系管理员");
//        }
//        return ResponseResult.okResult(200, "操作成功", returnMap);
//    }
//}
//
