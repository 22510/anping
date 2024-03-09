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
 * 审核流程
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Shenheliucheng对象", description="审核流程")
public class Shenheliucheng implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "审核名称")
    @TableField("ShenHeMingCheng")
    private String shenhemingcheng;

    @ApiModelProperty(value = "业务名称")
    @TableField("YeWuMingCheng")
    private String yewumingcheng;

    @ApiModelProperty(value = "关键字段")
    @TableField("GuanJianZiDuan")
    private String guanjianziduan;

    @ApiModelProperty(value = "审核字段")
    @TableField("ShenHeZiDuan")
    private String shenheziduan;

    @ApiModelProperty(value = "角色")
    @TableField("JueSe")
    private String juese;

    @ApiModelProperty(value = "数据范围")
    @TableField("ShuJuFanWei")
    private String shujufanwei;

    @ApiModelProperty(value = "通过语")
    @TableField("TongGuoYu")
    private String tongguoyu;

    @ApiModelProperty(value = "拒绝语")
    @TableField("JuJueYu")
    private String jujueyu;

    @ApiModelProperty(value = "审核查询名称")
    @TableField("ShenHeZhaXunMingCheng")
    private String shenhezhaxunmingcheng;

    @ApiModelProperty(value = "修改业务字段")
    @TableField("XiuGaiYeWuZiDuan")
    private String xiugaiyewuziduan;

    @ApiModelProperty(value = "审核序号")
    @TableField("ShenHeXuHao")
    private String shenhexuhao;

    @ApiModelProperty(value = "审核顺序")
    @TableField("ShenHeShunXu")
    private String shenheshunxu;

    @ApiModelProperty(value = "字段排除")
    @TableField("ZiDuanPaiChu")
    private String ziduanpaichu;

    @ApiModelProperty(value = "字段指定")
    @TableField("ZiDuanZhiDing")
    private String ziduanzhiding;

    @ApiModelProperty(value = "字段增加")
    @TableField("ZiDuanZengJia")
    private String ziduanzengjia;

    @ApiModelProperty(value = "备注")
    @TableField("BeiZhu")
    private String beizhu;

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
