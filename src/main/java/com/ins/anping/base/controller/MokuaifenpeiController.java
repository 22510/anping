package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Mokuaifenpei;
import com.ins.anping.base.service.impl.MokuaifenpeiServiceImpl;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.GetMenus.GetMenus;
import com.ins.anping.utils.UserHolder;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 模块分配 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/mokuaifenpei")
public class MokuaifenpeiController {

    
    @Autowired
    private MokuaifenpeiServiceImpl  mokuaifenpeiService;
    
    @ApiOperation("查询所有模块分配")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Mokuaifenpei> list= mokuaifenpeiService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Mokuaifenpei result = mokuaifenpeiService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Mokuaifenpei> page){
        IPage<Mokuaifenpei> mokuaifenpeiIPage= mokuaifenpeiService.page(page);
        if(mokuaifenpeiIPage != null) {
            return ResponseResult.okResult(200, "success", mokuaifenpeiIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Mokuaifenpei mokuaifenpei){
        if (mokuaifenpeiService.save(mokuaifenpei)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Mokuaifenpei mokuaifenpei){
        if (mokuaifenpeiService.updateById(mokuaifenpei)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (mokuaifenpeiService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
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

