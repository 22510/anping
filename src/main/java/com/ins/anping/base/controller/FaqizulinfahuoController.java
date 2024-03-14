package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Faqizulinfahuo;
import com.ins.anping.base.service.impl.FaqizulinfahuoServiceImpl;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.TimeUtils.MyTimeUtils;
import com.ins.anping.utils.UserHolder;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 发起租赁发货 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/faqizulinfahuo")
public class FaqizulinfahuoController {

    
    @Autowired
    private FaqizulinfahuoServiceImpl  faqizulinfahuoService;
    
    @ApiOperation("查询所有发起租赁发货")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Faqizulinfahuo> list= faqizulinfahuoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

        @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Faqizulinfahuo result = faqizulinfahuoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Faqizulinfahuo> page){
        IPage<Faqizulinfahuo> faqizulinfahuoIPage= faqizulinfahuoService.page(page);
        if(faqizulinfahuoIPage != null) {
            return ResponseResult.okResult(200, "success", faqizulinfahuoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Faqizulinfahuo faqizulinfahuo){
        faqizulinfahuo.setUsername(UserHolder.getUser().getUsername());
        faqizulinfahuo.setInserttime(MyTimeUtils.getNow());
        // TODO: 考虑一份合同多次发货 ( 一种货物, 可能分几次完成发货 )
        // 每次发货要记录发货流程
        // 在租赁合同物料里记录一种物料总的数量, 然后
        if (faqizulinfahuoService.save(faqizulinfahuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Faqizulinfahuo faqizulinfahuo){
        if (faqizulinfahuoService.updateById(faqizulinfahuo)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
    
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (faqizulinfahuoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

