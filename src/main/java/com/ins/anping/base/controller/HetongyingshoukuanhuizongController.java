package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Hetongyingshoukuanhuizong;
import com.ins.anping.base.service.impl.HetongyingshoukuanhuizongServiceImpl;
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
 * 合同应收款汇总 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/hetongyingshoukuanhuizong")
public class HetongyingshoukuanhuizongController {


    @Autowired
    private HetongyingshoukuanhuizongServiceImpl hetongyingshoukuanhuizongService;

    @ApiOperation("查询所有合同应收款汇总")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Hetongyingshoukuanhuizong> list= hetongyingshoukuanhuizongService.list();
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有合同应收款汇总 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取合同应收款汇总详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Hetongyingshoukuanhuizong result = hetongyingshoukuanhuizongService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取合同应收款汇总详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询合同应收款汇总")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Hetongyingshoukuanhuizong> page){
        IPage<Hetongyingshoukuanhuizong> hetongyingshoukuanhuizongIPage= hetongyingshoukuanhuizongService.page(page);
        try{
            if(hetongyingshoukuanhuizongIPage != null) {
                return ResponseResult.okResult(200, "success", hetongyingshoukuanhuizongIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询合同应收款汇总 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("新增合同应收款汇总")
    @PostMapping
    public ResponseResult<?> save(@RequestBody Hetongyingshoukuanhuizong hetongyingshoukuanhuizong){
        if (hetongyingshoukuanhuizongService.save(hetongyingshoukuanhuizong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改合同应收款汇总")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Hetongyingshoukuanhuizong hetongyingshoukuanhuizong){
        if (hetongyingshoukuanhuizongService.updateById(hetongyingshoukuanhuizong)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除合同应收款汇总")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (hetongyingshoukuanhuizongService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询合同应收款汇总")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Hetongyingshoukuanhuizong> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Hetongyingshoukuanhuizong> list = hetongyingshoukuanhuizongService.list(queryWrapper);
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

