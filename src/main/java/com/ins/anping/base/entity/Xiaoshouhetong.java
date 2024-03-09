package com.ins.anping.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 销售合同
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Xiaoshouhetong对象", description="销售合同")
public class Xiaoshouhetong implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同编号")
    @TableField("HeTongBianHao")
    private String hetongbianhao;

    @ApiModelProperty(value = "客户名称")
    @TableField("KeHuMingCheng")
    private String kehumingcheng;

    @ApiModelProperty(value = "产品名称")
    @TableField("ChanPinMingCheng")
    private String chanpinmingcheng;

    @ApiModelProperty(value = "吨数")
    @TableField("DunShu")
    private String dunshu;

    @ApiModelProperty(value = "单价")
    @TableField("DanJia")
    private String danjia;

    @ApiModelProperty(value = "定金")
    @TableField("DingJin")
    private String dingjin;

    @ApiModelProperty(value = "合同总额")
    @TableField("HeTongZongE")
    private String hetongzonge;

    @ApiModelProperty(value = "可用余额")
    @TableField("KeYongYuE")
    private String keyongyue;

    @ApiModelProperty(value = "应收金额")
    @TableField("YingShouJinE")
    private String yingshoujine;

    @ApiModelProperty(value = "是否开票")
    @TableField("ShiFouKaiPiao")
    private String shifoukaipiao;

    @ApiModelProperty(value = "合同状态")
    @TableField("HeTongZhuangTai")
    private String hetongzhuangtai;

    @ApiModelProperty(value = "签订人")
    @TableField("QianDingRen")
    private String qiandingren;

    @ApiModelProperty(value = "状态")
    @TableField("ZhuangTai")
    private String zhuangtai;

    @ApiModelProperty(value = "定金状态")
    @TableField("DingJinZhuangTai")
    private String dingjinzhuangtai;

    @ApiModelProperty(value = "合同模板")
    @TableField("HeTongMuBan")
    private String hetongmuban;

    @ApiModelProperty(value = "合同进度")
    @TableField("HeTongJinDu")
    private String hetongjindu;

    @ApiModelProperty(value = "用户名")
    @TableField("UserName")
    private String username;

    @ApiModelProperty(value = "新增记录时间")
    @TableField("InsertTime")
    private String inserttime;

    @ApiModelProperty(value = "修改记录时间")
    @TableField("UpdateTime")
    private String updatetime;


}
