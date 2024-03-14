package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Mokuaifenpei;
import com.ins.anping.base.service.impl.MokuaifenpeiServiceImpl;
import com.ins.anping.model.common.QueryDto;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.GetMenus.GetMenus;
import com.ins.anping.utils.UserHolder;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 模块分配 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/mokuaifenpei")
public class MokuaifenpeiController {


    @Autowired
    private MokuaifenpeiServiceImpl mokuaifenpeiService;

    @ApiOperation("查询所有模块分配")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Mokuaifenpei> list= mokuaifenpeiService.list();
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有模块分配 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取模块分配详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Mokuaifenpei result = mokuaifenpeiService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取模块分配详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询模块分配")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Mokuaifenpei> page){
        IPage<Mokuaifenpei> mokuaifenpeiIPage= mokuaifenpeiService.page(page);
        try{
            if(mokuaifenpeiIPage != null) {
                return ResponseResult.okResult(200, "success", mokuaifenpeiIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询模块分配 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("新增模块分配")
    @PostMapping
    public ResponseResult<?> save(@RequestBody Mokuaifenpei mokuaifenpei){
        if (mokuaifenpeiService.save(mokuaifenpei)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改模块分配")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Mokuaifenpei mokuaifenpei){
        if (mokuaifenpeiService.updateById(mokuaifenpei)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除模块分配")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (mokuaifenpeiService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询模块分配")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Mokuaifenpei> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Mokuaifenpei> list = mokuaifenpeiService.list(queryWrapper);
            if (list.isEmpty()){
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }else {
                return ResponseResult.okResult(200, "success", list);
            }
        }catch (Exception e){
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @Autowired
    private GetMenus getMenus;
    @GetMapping(value = "/JueSe")
    public ResponseResult<?> getById(){
        List<Map<String, Object>> modules = getMenus.GetModules(Integer.valueOf(UserHolder.getUser().getJueSe()));
        log.warn(modules.toString());
        if (modules != null) {
            return ResponseResult.okResult(200, "success", modules);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

