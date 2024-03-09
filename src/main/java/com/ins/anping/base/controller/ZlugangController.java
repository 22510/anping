package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Zlugang;
import com.ins.anping.base.service.impl.ZlugangServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ZLU杠 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/zlugang")
public class ZlugangController {

    
    @Autowired
    private ZlugangServiceImpl  zlugangService;
    
    @ApiOperation("查询所有ZLU杠")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Zlugang> list= zlugangService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Zlugang result = zlugangService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Zlugang> page){
        IPage<Zlugang> zlugangIPage= zlugangService.page(page);
        if(zlugangIPage != null) {
            return ResponseResult.okResult(200, "success", zlugangIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Zlugang zlugang){
        if (zlugangService.save(zlugang)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Zlugang zlugang){
        if (zlugangService.updateById(zlugang)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (zlugangService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

