package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Ziliao4zulinhetong;
import com.ins.anping.base.service.impl.Ziliao4zulinhetongServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 以下内容需要根据实际情况修改
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.model.common.QueryDto;



import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表. 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/ziliao4-zulinhetong")
public class Ziliao4zulinhetongController {


    @Autowired
    private Ziliao4zulinhetongServiceImpl ziliao4zulinhetongService;

    @ApiOperation("查询所有租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Ziliao4zulinhetong> list= ziliao4zulinhetongService.list();
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表. 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Ziliao4zulinhetong result = ziliao4zulinhetongService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Ziliao4zulinhetong> page){
        IPage<Ziliao4zulinhetong> ziliao4zulinhetongIPage= ziliao4zulinhetongService.page(page);
        try{
            if(ziliao4zulinhetongIPage != null) {
                return ResponseResult.okResult(200, "success", ziliao4zulinhetongIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表. 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("新增租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
    @PostMapping
    public ResponseResult<?> save(@RequestBody Ziliao4zulinhetong ziliao4zulinhetong){
        if (ziliao4zulinhetongService.save(ziliao4zulinhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Ziliao4zulinhetong ziliao4zulinhetong){
        if (ziliao4zulinhetongService.updateById(ziliao4zulinhetong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (ziliao4zulinhetongService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Ziliao4zulinhetong> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Ziliao4zulinhetong> list = ziliao4zulinhetongService.list(queryWrapper);
            if (list.isEmpty()){
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }else {
                return ResponseResult.okResult(200, "success", list);
            }
        }catch (Exception e){
            return ResponseResult.errorResult(500, "操作失败");
        }
    }
}

