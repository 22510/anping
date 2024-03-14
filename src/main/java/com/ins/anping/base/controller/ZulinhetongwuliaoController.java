package com.ins.anping.base.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ins.anping.base.entity.Daibanshixiang;
import com.ins.anping.base.entity.Kufangbeihuo;
import com.ins.anping.base.entity.MessageLog;
import com.ins.anping.base.entity.Zulinhetongwuliao;
import com.ins.anping.base.service.impl.DaibanshixiangServiceImpl;
import com.ins.anping.base.service.impl.KufangbeihuoServiceImpl;
import com.ins.anping.base.service.impl.MessageLogServiceImpl;
import com.ins.anping.base.service.impl.ZulinhetongwuliaoServiceImpl;
import com.ins.anping.model.common.QueryDto;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.TimeUtils.MyTimeUtils;
import com.ins.anping.utils.UserHolder;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 租赁合同物料 前端控制器
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@RestController
@Slf4j
@RequestMapping("api/busi/table/zulinhetongwuliao")
public class ZulinhetongwuliaoController {

    @Autowired
    private ZulinhetongwuliaoServiceImpl zulinhetongwuliaoService;

    @Autowired
    private MessageLogServiceImpl messageLogService;

    @Autowired
    private DaibanshixiangServiceImpl daibanshixiangService;

    @Autowired
    private KufangbeihuoServiceImpl kufangbeihuoService;

    @ApiOperation("查询所有租赁合同物料")
    @GetMapping("")
    public ResponseResult<?> list(){
        List<Zulinhetongwuliao> list= zulinhetongwuliaoService.list();
        try{
            if(!list.isEmpty()){
                return ResponseResult.okResult(200, "success", list);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 查询所有租赁合同物料 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("获取租赁合同物料详细信息")
    @GetMapping(value = "/{id}")
    public ResponseResult<?> getById(@PathVariable Long id){
        Zulinhetongwuliao result = zulinhetongwuliaoService.getById(id);
        try{
            if (result != null) {
                return ResponseResult.okResult(200, "success", result);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 获取租赁合同物料详细信息 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @ApiOperation("分页查询租赁合同物料")
    @GetMapping("/page")
    public ResponseResult<?> page(@RequestBody Page<Zulinhetongwuliao> page){
        IPage<Zulinhetongwuliao> zulinhetongwuliaoIPage= zulinhetongwuliaoService.page(page);
        try{
            if(zulinhetongwuliaoIPage != null) {
                return ResponseResult.okResult(200, "success", zulinhetongwuliaoIPage);
            }else{
                return ResponseResult.okResult(200, "success", new ArrayList<>());
            }
        }catch (Exception e){
            log.error("[MyBatisPlus] 分页查询租赁合同物料 发生异常", e);
            return ResponseResult.errorResult(500, "操作失败");
        }
    }

    @Transactional
    @ApiOperation("新增租赁合同物料")
    @PostMapping
    public ResponseResult<?> save(@RequestBody  List<Map<String, Object>> list){
        Integer length = (Integer) list.get(0).get("length");
        List<Zulinhetongwuliao> zulinhetongwuliaoList = new ArrayList<>();
        List<Kufangbeihuo> kufangbeihuoList = new ArrayList<>();
        for (int i = 1; i <= length; i++){
            zulinhetongwuliaoList.add(BeanUtil.toBean(list.get(i), Zulinhetongwuliao.class));
            kufangbeihuoList.add(BeanUtil.toBean(list.get(i), Kufangbeihuo.class));
        }
        length++;
        MessageLog messageLog = BeanUtil.toBean(list.get(length), MessageLog.class);
        if (zulinhetongwuliaoService.saveBatch(zulinhetongwuliaoList) && kufangbeihuoService.saveBatch(kufangbeihuoList)){
            Daibanshixiang daibanshixiang_yewujingli = new Daibanshixiang();
            daibanshixiang_yewujingli.setStatu("未完成");
            daibanshixiang_yewujingli.setShixiangming("新合同物料待备货");
            daibanshixiang_yewujingli.setZhongyaochengdu("比较紧急");
            daibanshixiang_yewujingli.setYonghuming(messageLog.getToUser());
            daibanshixiang_yewujingli.setNeirong("待审核, 合同编号"+list.get(1).get("hetongbianhao")+", 负责业务员:"+UserHolder.getUser().getUsername());
            daibanshixiang_yewujingli.setInserttime(MyTimeUtils.getNow());
            daibanshixiang_yewujingli.setEndtime(MyTimeUtils.getAfterTime(3L));
            daibanshixiangService.save(daibanshixiang_yewujingli);

            messageLog.setFromUser(UserHolder.getUser().getUsername());
            messageLog.setIsSystemMessage("false");
            messageLog.setSendTime(MyTimeUtils.getNow());
            messageLog.setStatus("no");
            messageLog.setType("warn");
            messageLogService.save(messageLog);
            log.info("[租赁合同] 租赁合同{}物料信息保存", list.get(1).get("hetongbianhao"));
            log.info("[租赁合同] 租赁合同{}物料待备货状态建立", list.get(1).get("hetongbianhao"));
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("修改租赁合同物料")
    @PutMapping
    public ResponseResult<?> updateById(@RequestBody Zulinhetongwuliao zulinhetongwuliao){
        if (zulinhetongwuliaoService.updateById(zulinhetongwuliao)){
            return ResponseResult.okResult(200, "操作成功", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("删除租赁合同物料")
    @DeleteMapping("/{id}")
    public ResponseResult<?> remove(@PathVariable Long id){
        if (zulinhetongwuliaoService.removeById(id)){
            return ResponseResult.okResult(200, "success", null);
        }
        return ResponseResult.errorResult(500, "操作失败");
    }

    @ApiOperation("条件查询租赁合同物料")
    @PostMapping("/conditionQuery")
    public ResponseResult<?> conditionQuery(@RequestBody List<QueryDto> queryDtoList){
        try{
            QueryWrapper<Zulinhetongwuliao> queryWrapper = new QueryWrapper<>();
            queryDtoList.forEach((queryDto -> {
                if(queryDto.getIsLike() == 0){
                    queryWrapper.eq(queryDto.getField(), queryDto.getValue());
                }else{
                    queryWrapper.like(queryDto.getField(), queryDto.getValue());
                }
            }));
            List<Zulinhetongwuliao> list = zulinhetongwuliaoService.list(queryWrapper);
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

