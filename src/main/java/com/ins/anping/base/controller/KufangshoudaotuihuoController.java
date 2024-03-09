package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Kufangshoudaotuihuo;
import com.ins.anping.base.service.impl.KufangshoudaotuihuoServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库房收到退货 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangshoudaotuihuo")
public class KufangshoudaotuihuoController {

    
    @Autowired
    private KufangshoudaotuihuoServiceImpl  kufangshoudaotuihuoService;
    
    @ApiOperation("查询所有库房收到退货")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangshoudaotuihuo> list= kufangshoudaotuihuoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangshoudaotuihuo result = kufangshoudaotuihuoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangshoudaotuihuo> page){
        IPage<Kufangshoudaotuihuo> kufangshoudaotuihuoIPage= kufangshoudaotuihuoService.page(page);
        if(kufangshoudaotuihuoIPage != null) {
            return ResponseResult.okResult(200, "success", kufangshoudaotuihuoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangshoudaotuihuo kufangshoudaotuihuo){
        if (kufangshoudaotuihuoService.save(kufangshoudaotuihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangshoudaotuihuo kufangshoudaotuihuo){
        if (kufangshoudaotuihuoService.updateById(kufangshoudaotuihuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangshoudaotuihuoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

