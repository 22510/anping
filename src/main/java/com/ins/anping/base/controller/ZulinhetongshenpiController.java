package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Zulinhetongshenpi;
import com.ins.anping.base.service.impl.ZulinhetongshenpiServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 租赁合同审批 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/zulinhetongshenpi")
public class ZulinhetongshenpiController {

    
    @Autowired
    private ZulinhetongshenpiServiceImpl  zulinhetongshenpiService;
    
    @ApiOperation("查询所有租赁合同审批")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Zulinhetongshenpi> list= zulinhetongshenpiService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Zulinhetongshenpi result = zulinhetongshenpiService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Zulinhetongshenpi> page){
        IPage<Zulinhetongshenpi> zulinhetongshenpiIPage= zulinhetongshenpiService.page(page);
        if(zulinhetongshenpiIPage != null) {
            return ResponseResult.okResult(200, "success", zulinhetongshenpiIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Zulinhetongshenpi zulinhetongshenpi){
        if (zulinhetongshenpiService.save(zulinhetongshenpi)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Zulinhetongshenpi zulinhetongshenpi){
        if (zulinhetongshenpiService.updateById(zulinhetongshenpi)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (zulinhetongshenpiService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

