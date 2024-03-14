package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Kufangwuliaobiandonglog;
import com.ins.anping.base.service.impl.KufangwuliaobiandonglogServiceImpl;
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
 * 库房物料数量变动日志 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangwuliaobiandonglog")
public class KufangwuliaobiandonglogController {


    @Autowired
    private KufangwuliaobiandonglogServiceImpl kufangwuliaobiandonglogService;

    @ApiOperation("查询所有库房物料数量变动日志")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangwuliaobiandonglog> list= kufangwuliaobiandonglogService.list();
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有库房物料数量变动日志 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取库房物料数量变动日志详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangwuliaobiandonglog result = kufangwuliaobiandonglogService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取库房物料数量变动日志详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询库房物料数量变动日志")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangwuliaobiandonglog> page){
        IPage<Kufangwuliaobiandonglog> kufangwuliaobiandonglogIPage= kufangwuliaobiandonglogService.page(page);
        try{
            if(kufangwuliaobiandonglogIPage != null) {
                return ResponseResult.okResult(200, "success", kufangwuliaobiandonglogIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询库房物料数量变动日志 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("新增库房物料数量变动日志")
    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangwuliaobiandonglog kufangwuliaobiandonglog){
        if (kufangwuliaobiandonglogService.save(kufangwuliaobiandonglog)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改库房物料数量变动日志")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangwuliaobiandonglog kufangwuliaobiandonglog){
        if (kufangwuliaobiandonglogService.updateById(kufangwuliaobiandonglog)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除库房物料数量变动日志")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangwuliaobiandonglogService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询库房物料数量变动日志")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Kufangwuliaobiandonglog> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Kufangwuliaobiandonglog> list = kufangwuliaobiandonglogService.list(queryWrapper);
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

