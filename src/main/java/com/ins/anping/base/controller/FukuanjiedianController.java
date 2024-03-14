package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Fukuanjiedian;
import com.ins.anping.base.service.impl.FukuanjiedianServiceImpl;
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
 * 付款节点 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/fukuanjiedian")
public class FukuanjiedianController {


    @Autowired
    private FukuanjiedianServiceImpl fukuanjiedianService;

    @ApiOperation("查询所有付款节点")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Fukuanjiedian> list= fukuanjiedianService.list();
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有付款节点 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取付款节点详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Fukuanjiedian result = fukuanjiedianService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取付款节点详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询付款节点")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Fukuanjiedian> page){
        IPage<Fukuanjiedian> fukuanjiedianIPage= fukuanjiedianService.page(page);
        try{
            if(fukuanjiedianIPage != null) {
                return ResponseResult.okResult(200, "success", fukuanjiedianIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询付款节点 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("新增付款节点")
    @PostMapping
    public ResponseResult<?> save(@RequestBody Fukuanjiedian fukuanjiedian){
        if (fukuanjiedianService.save(fukuanjiedian)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改付款节点")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Fukuanjiedian fukuanjiedian){
        if (fukuanjiedianService.updateById(fukuanjiedian)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除付款节点")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (fukuanjiedianService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询付款节点")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Fukuanjiedian> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Fukuanjiedian> list = fukuanjiedianService.list(queryWrapper);
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

