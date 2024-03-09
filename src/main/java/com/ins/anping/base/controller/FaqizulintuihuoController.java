package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Faqizulintuihuo;
import com.ins.anping.base.service.impl.FaqizulintuihuoServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发起租赁退货 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/faqizulintuihuo")
public class FaqizulintuihuoController {

    
    @Autowired
    private FaqizulintuihuoServiceImpl  faqizulintuihuoService;
    
    @ApiOperation("查询所有发起租赁退货")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Faqizulintuihuo> list= faqizulintuihuoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Faqizulintuihuo result = faqizulintuihuoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Faqizulintuihuo> page){
        IPage<Faqizulintuihuo> faqizulintuihuoIPage= faqizulintuihuoService.page(page);
        if(faqizulintuihuoIPage != null) {
            return ResponseResult.okResult(200, "success", faqizulintuihuoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Faqizulintuihuo faqizulintuihuo){
        if (faqizulintuihuoService.save(faqizulintuihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Faqizulintuihuo faqizulintuihuo){
        if (faqizulintuihuoService.updateById(faqizulintuihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (faqizulintuihuoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

