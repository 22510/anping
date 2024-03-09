package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Yibeihuoweifahuo;
import com.ins.anping.base.service.impl.YibeihuoweifahuoServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 已备货未发货 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/yibeihuoweifahuo")
public class YibeihuoweifahuoController {

    
    @Autowired
    private YibeihuoweifahuoServiceImpl  yibeihuoweifahuoService;
    
    @ApiOperation("查询所有已备货未发货")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Yibeihuoweifahuo> list= yibeihuoweifahuoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Yibeihuoweifahuo result = yibeihuoweifahuoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Yibeihuoweifahuo> page){
        IPage<Yibeihuoweifahuo> yibeihuoweifahuoIPage= yibeihuoweifahuoService.page(page);
        if(yibeihuoweifahuoIPage != null) {
            return ResponseResult.okResult(200, "success", yibeihuoweifahuoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Yibeihuoweifahuo yibeihuoweifahuo){
        if (yibeihuoweifahuoService.save(yibeihuoweifahuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Yibeihuoweifahuo yibeihuoweifahuo){
        if (yibeihuoweifahuoService.updateById(yibeihuoweifahuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (yibeihuoweifahuoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

