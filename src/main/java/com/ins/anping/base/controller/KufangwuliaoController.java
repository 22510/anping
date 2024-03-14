package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Kufangwuliao;
import com.ins.anping.base.service.impl.KufangwuliaoServiceImpl;
import com.ins.anping.model.common.QueryDto;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.TimeUtils.MyTimeUtils;
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
 * 库房物料总体管理 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangwuliao")
public class KufangwuliaoController {


    @Autowired
    private KufangwuliaoServiceImpl kufangwuliaoService;

    @ApiOperation("查询所有库房物料总体管理")
    @GetMapping("")
    public ResponseResult<?> list(){
        QueryWrapper<Kufangwuliao> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete", 0);
        List<Kufangwuliao> list= kufangwuliaoService.list(queryWrapper);
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有库房物料总体管理 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取库房物料总体管理详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangwuliao result = kufangwuliaoService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取库房物料总体管理详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询库房物料总体管理")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangwuliao> page){
        IPage<Kufangwuliao> kufangwuliaoIPage= kufangwuliaoService.page(page);
        try{
            if(kufangwuliaoIPage != null) {
                return ResponseResult.okResult(200, "success", kufangwuliaoIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询库房物料总体管理 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("新增库房物料总体管理")
    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangwuliao kufangwuliao){
        /**
         * {
         *   "wuliaobianhao": "string",
         *   "wuliaomingcheng": "string",
         *   "wuliaoleibie": "string",
         *   "wuliaoguige": "string",
         *   "wuliaoxinghao": "string",
         *   "jiliangdanwei": "string",
         *   "zhangdu": "string",
         *   "wuliaozhongliang": "string",
         *   "wuliaomianji": "string",
         *   "xianyoukucun": 0,
         *   "beizhu": "string",
         *   "zuhewuliao": "string",
         *   "zulinjiage": "string",
         *   "xiaoshoujiage": "string",
         * }
         */
        kufangwuliao.setUsername(UserHolder.getUser().getUsername());
        kufangwuliao.setInsertTime(MyTimeUtils.getNow());
        if (kufangwuliaoService.save(kufangwuliao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改库房物料总体管理")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Map<String, Object> map)  {
        UpdateWrapper<Kufangwuliao> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", map.get("id"));
        map.remove("id");
        for (Map.Entry<String, Object> entry : map.entrySet()){
            updateWrapper.set(entry.getKey(), entry.getValue());
        }
        if (kufangwuliaoService.update(updateWrapper)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除库房物料总体管理")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        UpdateWrapper<Kufangwuliao> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("is_delete", 1);
        if (kufangwuliaoService.update(updateWrapper)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询库房物料总体管理")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Kufangwuliao> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Kufangwuliao> list = kufangwuliaoService.list(queryWrapper);
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

