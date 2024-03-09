package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Xiaoshouhetong;
import com.ins.anping.base.service.impl.XiaoshouhetongServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 销售合同 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/xiaoshouhetong")
public class XiaoshouhetongController {

    
    @Autowired
    private XiaoshouhetongServiceImpl  xiaoshouhetongService;
    
    @ApiOperation("查询所有销售合同")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Xiaoshouhetong> list= xiaoshouhetongService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Xiaoshouhetong result = xiaoshouhetongService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Xiaoshouhetong> page){
        IPage<Xiaoshouhetong> xiaoshouhetongIPage= xiaoshouhetongService.page(page);
        if(xiaoshouhetongIPage != null) {
            return ResponseResult.okResult(200, "success", xiaoshouhetongIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Xiaoshouhetong xiaoshouhetong){
        if (xiaoshouhetongService.save(xiaoshouhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Xiaoshouhetong xiaoshouhetong){
        if (xiaoshouhetongService.updateById(xiaoshouhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (xiaoshouhetongService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

