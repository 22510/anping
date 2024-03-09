package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Gouziluomuxiaopian;
import com.ins.anping.base.service.impl.GouziluomuxiaopianServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 钩子螺母销片 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/gouziluomuxiaopian")
public class GouziluomuxiaopianController {

    
    @Autowired
    private GouziluomuxiaopianServiceImpl  gouziluomuxiaopianService;
    
    @ApiOperation("查询所有钩子螺母销片")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Gouziluomuxiaopian> list= gouziluomuxiaopianService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Gouziluomuxiaopian result = gouziluomuxiaopianService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Gouziluomuxiaopian> page){
        IPage<Gouziluomuxiaopian> gouziluomuxiaopianIPage= gouziluomuxiaopianService.page(page);
        if(gouziluomuxiaopianIPage != null) {
            return ResponseResult.okResult(200, "success", gouziluomuxiaopianIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Gouziluomuxiaopian gouziluomuxiaopian){
        if (gouziluomuxiaopianService.save(gouziluomuxiaopian)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Gouziluomuxiaopian gouziluomuxiaopian){
        if (gouziluomuxiaopianService.updateById(gouziluomuxiaopian)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (gouziluomuxiaopianService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

