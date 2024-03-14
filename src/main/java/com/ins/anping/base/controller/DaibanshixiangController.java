package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Daibanshixiang;
import com.ins.anping.base.service.impl.DaibanshixiangServiceImpl;
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
 *  前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/daibanshixiang")
public class DaibanshixiangController {


    @Autowired
    private DaibanshixiangServiceImpl daibanshixiangService;

    @ApiOperation("查询所有")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Daibanshixiang> list= daibanshixiangService.list();
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Daibanshixiang result = daibanshixiangService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Daibanshixiang> page){
        IPage<Daibanshixiang> daibanshixiangIPage= daibanshixiangService.page(page);
        try{
            if(daibanshixiangIPage != null) {
                return ResponseResult.okResult(200, "success", daibanshixiangIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("新增")
    @PostMapping
    public ResponseResult<?> save(@RequestBody Daibanshixiang daibanshixiang){
        if (daibanshixiangService.save(daibanshixiang)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Daibanshixiang daibanshixiang){
        if (daibanshixiangService.updateById(daibanshixiang)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (daibanshixiangService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Daibanshixiang> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Daibanshixiang> list = daibanshixiangService.list(queryWrapper);
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

