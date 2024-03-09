package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Hetongyingshoukuanhuizong;
import com.ins.anping.base.service.impl.HetongyingshoukuanhuizongServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 合同应收款汇总 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/hetongyingshoukuanhuizong")
public class HetongyingshoukuanhuizongController {

    
    @Autowired
    private HetongyingshoukuanhuizongServiceImpl  hetongyingshoukuanhuizongService;
    
    @ApiOperation("查询所有合同应收款汇总")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Hetongyingshoukuanhuizong> list= hetongyingshoukuanhuizongService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Hetongyingshoukuanhuizong result = hetongyingshoukuanhuizongService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Hetongyingshoukuanhuizong> page){
        IPage<Hetongyingshoukuanhuizong> hetongyingshoukuanhuizongIPage= hetongyingshoukuanhuizongService.page(page);
        if(hetongyingshoukuanhuizongIPage != null) {
            return ResponseResult.okResult(200, "success", hetongyingshoukuanhuizongIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Hetongyingshoukuanhuizong hetongyingshoukuanhuizong){
        if (hetongyingshoukuanhuizongService.save(hetongyingshoukuanhuizong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Hetongyingshoukuanhuizong hetongyingshoukuanhuizong){
        if (hetongyingshoukuanhuizongService.updateById(hetongyingshoukuanhuizong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (hetongyingshoukuanhuizongService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

