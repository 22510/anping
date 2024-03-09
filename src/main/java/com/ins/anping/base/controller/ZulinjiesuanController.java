package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.base.entity.Zulinjiesuan;
import com.ins.anping.base.service.impl.ZulinjiesuanServiceImpl ;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 租赁结算 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/zulinjiesuan")
public class ZulinjiesuanController {

    
    @Autowired
    private ZulinjiesuanServiceImpl  zulinjiesuanService;
    
    @ApiOperation("查询所有租赁结算")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Zulinjiesuan> list= zulinjiesuanService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Zulinjiesuan result = zulinjiesuanService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Zulinjiesuan> page){
        IPage<Zulinjiesuan> zulinjiesuanIPage= zulinjiesuanService.page(page);
        if(zulinjiesuanIPage != null) {
            return ResponseResult.okResult(200, "success", zulinjiesuanIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Zulinjiesuan zulinjiesuan){
        if (zulinjiesuanService.save(zulinjiesuan)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Zulinjiesuan zulinjiesuan){
        if (zulinjiesuanService.updateById(zulinjiesuan)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (zulinjiesuanService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

