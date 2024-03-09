package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Chaxiao;
import com.ins.anping.base.service.impl.ChaxiaoServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 插销 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/chaxiao")
public class ChaxiaoController {

    
    @Autowired
    private ChaxiaoServiceImpl  chaxiaoService;
    
    @ApiOperation("查询所有插销")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Chaxiao> list= chaxiaoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Chaxiao result = chaxiaoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Chaxiao> page){
        IPage<Chaxiao> chaxiaoIPage= chaxiaoService.page(page);
        if(chaxiaoIPage != null) {
            return ResponseResult.okResult(200, "success", chaxiaoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Chaxiao chaxiao){
        if (chaxiaoService.save(chaxiao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Chaxiao chaxiao){
        if (chaxiaoService.updateById(chaxiao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (chaxiaoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

