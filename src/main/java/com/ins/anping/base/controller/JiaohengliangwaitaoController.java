package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Jiaohengliangwaitao;
import com.ins.anping.base.service.impl.JiaohengliangwaitaoServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角横梁外套 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/jiaohengliangwaitao")
public class JiaohengliangwaitaoController {

    
    @Autowired
    private JiaohengliangwaitaoServiceImpl  jiaohengliangwaitaoService;
    
    @ApiOperation("查询所有角横梁外套")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Jiaohengliangwaitao> list= jiaohengliangwaitaoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Jiaohengliangwaitao result = jiaohengliangwaitaoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Jiaohengliangwaitao> page){
        IPage<Jiaohengliangwaitao> jiaohengliangwaitaoIPage= jiaohengliangwaitaoService.page(page);
        if(jiaohengliangwaitaoIPage != null) {
            return ResponseResult.okResult(200, "success", jiaohengliangwaitaoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Jiaohengliangwaitao jiaohengliangwaitao){
        if (jiaohengliangwaitaoService.save(jiaohengliangwaitao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Jiaohengliangwaitao jiaohengliangwaitao){
        if (jiaohengliangwaitaoService.updateById(jiaohengliangwaitao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (jiaohengliangwaitaoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

