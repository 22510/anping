package com.ins.anping.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Kufangwuliao;
import com.ins.anping.base.service.impl.KufangwuliaoServiceImpl;
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
 *  前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-13
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/kufangwuliao")
public class KufangwuliaoController {


    @Autowired
    private KufangwuliaoServiceImpl  kufangwuliaoService;

    @ApiOperation("查询所有")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Kufangwuliao> list= kufangwuliaoService.list();
        if(!list.isEmpty()){
            return ResponseResult.okResult(200, "success", list);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Kufangwuliao result = kufangwuliaoService.getById(id);
        if (result != null) {
            return ResponseResult.okResult(200, "success", result);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Kufangwuliao> page){
        IPage<Kufangwuliao> kufangwuliaoIPage= kufangwuliaoService.page(page);
        if(kufangwuliaoIPage != null) {
            return ResponseResult.okResult(200, "success", kufangwuliaoIPage);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PostMapping
    public ResponseResult<?> save(@RequestBody Kufangwuliao kufangwuliao){
        /**输入参数
         * {
         *   "wuliaobianma": "FZ-001",
         *   "wuliaomingcheng": "方柱",
         *   "wuliaoleibie": "方柱",
         *   "zuhewuliao": "",
         *   "jiliangdanwei": "个/根",
         *   "jiage": "100元/根",
         *   "zhangdu": "2m",
         *   "wuliaozhongliang": "2kg"
         * }
         */
        kufangwuliao.setUsername(UserHolder.getUser().getUsername());
        kufangwuliao.setInsertTime(MyTimeUtils.getNow());
        // TODO: 是否需要库房物料变更记录表
        if (kufangwuliaoService.save(kufangwuliao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Kufangwuliao kufangwuliao){
        kufangwuliao.setUsername(UserHolder.getUser().getUsername());
        kufangwuliao.setInsertTime(MyTimeUtils.getNow());
        if (kufangwuliaoService.updateById(kufangwuliao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (kufangwuliaoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }
}

