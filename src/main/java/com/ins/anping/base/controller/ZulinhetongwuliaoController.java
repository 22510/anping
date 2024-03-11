package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Zulinhetongwuliao;
import com.ins.anping.base.service.impl.ZulinhetongwuliaoServiceImpl;
import com.ins.anping.model.common.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 租赁合同物料 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/zulinhetongwuliao")
public class ZulinhetongwuliaoController {

    
    @Autowired
    private ZulinhetongwuliaoServiceImpl  zulinhetongwuliaoService;
    
    @ApiOperation("查询所有租赁合同物料")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Zulinhetongwuliao> list= zulinhetongwuliaoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Zulinhetongwuliao result = zulinhetongwuliaoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Zulinhetongwuliao> page){
        IPage<Zulinhetongwuliao> zulinhetongwuliaoIPage= zulinhetongwuliaoService.page(page);
        if(zulinhetongwuliaoIPage != null) {
            return ResponseResult.okResult(200, "success", zulinhetongwuliaoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Zulinhetongwuliao zulinhetongwuliao){
        if (zulinhetongwuliaoService.save(zulinhetongwuliao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Zulinhetongwuliao zulinhetongwuliao){
        if (zulinhetongwuliaoService.updateById(zulinhetongwuliao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (zulinhetongwuliaoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

