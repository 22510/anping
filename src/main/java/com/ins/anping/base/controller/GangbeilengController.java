package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Gangbeileng;
import com.ins.anping.base.service.impl.GangbeilengServiceImpl;
import com.ins.anping.model.common.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 钢背楞 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/gangbeileng")
public class GangbeilengController {

    
    @Autowired
    private GangbeilengServiceImpl  gangbeilengService;
    
    @ApiOperation("查询所有钢背楞")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Gangbeileng> list= gangbeilengService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Gangbeileng result = gangbeilengService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Gangbeileng> page){
        IPage<Gangbeileng> gangbeilengIPage= gangbeilengService.page(page);
        if(gangbeilengIPage != null) {
            return ResponseResult.okResult(200, "success", gangbeilengIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Gangbeileng gangbeileng){
        if (gangbeilengService.save(gangbeileng)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Gangbeileng gangbeileng){
        if (gangbeilengService.updateById(gangbeileng)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (gangbeilengService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

