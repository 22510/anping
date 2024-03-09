package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Fahuoxinxichaxun;
import com.ins.anping.base.service.impl.FahuoxinxichaxunServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发货信息查询 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/fahuoxinxichaxun")
public class FahuoxinxichaxunController {

    
    @Autowired
    private FahuoxinxichaxunServiceImpl  fahuoxinxichaxunService;
    
    @ApiOperation("查询所有发货信息查询")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Fahuoxinxichaxun> list= fahuoxinxichaxunService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Fahuoxinxichaxun result = fahuoxinxichaxunService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Fahuoxinxichaxun> page){
        IPage<Fahuoxinxichaxun> fahuoxinxichaxunIPage= fahuoxinxichaxunService.page(page);
        if(fahuoxinxichaxunIPage != null) {
            return ResponseResult.okResult(200, "success", fahuoxinxichaxunIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Fahuoxinxichaxun fahuoxinxichaxun){
        if (fahuoxinxichaxunService.save(fahuoxinxichaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Fahuoxinxichaxun fahuoxinxichaxun){
        if (fahuoxinxichaxunService.updateById(fahuoxinxichaxun)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (fahuoxinxichaxunService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

