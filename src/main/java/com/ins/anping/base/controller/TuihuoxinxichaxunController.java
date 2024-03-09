package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Tuihuoxinxichaxun;
import com.ins.anping.base.service.impl.TuihuoxinxichaxunServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 退货信息查询 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/tuihuoxinxichaxun")
public class TuihuoxinxichaxunController {

    
    @Autowired
    private TuihuoxinxichaxunServiceImpl  tuihuoxinxichaxunService;
    
    @ApiOperation("查询所有退货信息查询")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Tuihuoxinxichaxun> list= tuihuoxinxichaxunService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Tuihuoxinxichaxun result = tuihuoxinxichaxunService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Tuihuoxinxichaxun> page){
        IPage<Tuihuoxinxichaxun> tuihuoxinxichaxunIPage= tuihuoxinxichaxunService.page(page);
        if(tuihuoxinxichaxunIPage != null) {
            return ResponseResult.okResult(200, "success", tuihuoxinxichaxunIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Tuihuoxinxichaxun tuihuoxinxichaxun){
        if (tuihuoxinxichaxunService.save(tuihuoxinxichaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Tuihuoxinxichaxun tuihuoxinxichaxun){
        if (tuihuoxinxichaxunService.updateById(tuihuoxinxichaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (tuihuoxinxichaxunService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

