package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Wuliaoshuliang;
import com.ins.anping.base.service.impl.WuliaoshuliangServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物料数量 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/wuliaoshuliang")
public class WuliaoshuliangController {

    
    @Autowired
    private WuliaoshuliangServiceImpl  wuliaoshuliangService;
    
    @ApiOperation("查询所有物料数量")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Wuliaoshuliang> list= wuliaoshuliangService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Wuliaoshuliang result = wuliaoshuliangService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Wuliaoshuliang> page){
        IPage<Wuliaoshuliang> wuliaoshuliangIPage= wuliaoshuliangService.page(page);
        if(wuliaoshuliangIPage != null) {
            return ResponseResult.okResult(200, "success", wuliaoshuliangIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Wuliaoshuliang wuliaoshuliang){
        if (wuliaoshuliangService.save(wuliaoshuliang)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Wuliaoshuliang wuliaoshuliang){
        if (wuliaoshuliangService.updateById(wuliaoshuliang)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (wuliaoshuliangService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

