package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Ziliao4zulinhetong;
import com.ins.anping.base.service.impl.Ziliao4zulinhetongServiceImpl;
import com.ins.anping.model.common.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表. 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-08
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/ziliao4-zulinhetong")
public class Ziliao4zulinhetongController {


    @Autowired
    private Ziliao4zulinhetongServiceImpl  ziliao4zulinhetongService;

    @ApiOperation("查询所有租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Ziliao4zulinhetong> list= ziliao4zulinhetongService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Ziliao4zulinhetong result = ziliao4zulinhetongService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Ziliao4zulinhetong> page){
        IPage<Ziliao4zulinhetong> ziliao4zulinhetongIPage= ziliao4zulinhetongService.page(page);
        if(ziliao4zulinhetongIPage != null) {
            return ResponseResult.okResult(200, "success", ziliao4zulinhetongIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Ziliao4zulinhetong ziliao4zulinhetong){
        if (ziliao4zulinhetongService.save(ziliao4zulinhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Ziliao4zulinhetong ziliao4zulinhetong){
        if (ziliao4zulinhetongService.updateById(ziliao4zulinhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (ziliao4zulinhetongService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

