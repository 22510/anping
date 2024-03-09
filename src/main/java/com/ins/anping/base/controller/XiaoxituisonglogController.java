package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Xiaoxituisonglog;
import com.ins.anping.base.service.impl.XiaoxituisonglogServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-08
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/xiaoxituisonglog")
public class XiaoxituisonglogController {


    @Autowired
    private XiaoxituisonglogServiceImpl  xiaoxituisonglogService;

    @ApiOperation("查询所有")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Xiaoxituisonglog> list= xiaoxituisonglogService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Xiaoxituisonglog result = xiaoxituisonglogService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Xiaoxituisonglog> page){
        IPage<Xiaoxituisonglog> xiaoxituisonglogIPage= xiaoxituisonglogService.page(page);
        if(xiaoxituisonglogIPage != null) {
            return ResponseResult.okResult(200, "success", xiaoxituisonglogIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Xiaoxituisonglog xiaoxituisonglog){
        if (xiaoxituisonglogService.save(xiaoxituisonglog)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Xiaoxituisonglog xiaoxituisonglog){
        if (xiaoxituisonglogService.updateById(xiaoxituisonglog)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (xiaoxituisonglogService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

