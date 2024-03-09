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
 * 添加表单测试
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Tianjiabiaodanceshi对象", description="添加表单测试")
public class Tianjiabiaodanceshi implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "姓名")
    @TableField("XingMing")
    private String xingming;

    @ApiModelProperty(value = "性别")
    @TableField("XingBie")
    private String xingbie;

    @ApiModelProperty(value = "出生日期")
    @TableField("ChuShengRiQi")
    private String chushengriqi;

    @ApiModelProperty(value = "血型")
    @TableField("XueXing")
    private String xuexing;

    @ApiModelProperty(value = "是否本地")
    @TableField("ShiFouBenDi")
    private String shifoubendi;

    @ApiModelProperty(value = "公寓楼")
    @TableField("GongYuLou")
    private String gongyulou;

    @ApiModelProperty(value = "家庭成员")
    @TableField("JiaTingChengYuan")
    private String jiatingchengyuan;

    @ApiModelProperty(value = "年龄")
    @TableField("NianLing")
    private String nianling;

    @ApiModelProperty(value = "证件照")
    @TableField("ZhengJianZhao")
    private String zhengjianzhao;

    @ApiModelProperty(value = "日期时间")
    @TableField("RiQiShiJian")
    private String riqishijian;

    @ApiModelProperty(value = "毕业时间")
    @TableField("BiYeShiJian")
    private String biyeshijian;

    @ApiModelProperty(value = "登录密码重置")
    @TableField("DengLuMiMaZhongZhi")
    private String denglumimazhongzhi;

    @ApiModelProperty(value = "是否建党立卡")
    @TableField("ShiFouJianDangLiKa")
    private String shifoujiandanglika;

    @ApiModelProperty(value = "入学时间")
    @TableField("RuXueShiJian")
    private String ruxueshijian;

    @ApiModelProperty(value = "喜欢颜色")
    @TableField("XiHuanYanSe")
    private String xihuanyanse;

    @ApiModelProperty(value = "个人评价")
    @TableField("GeRenPingJia")
    private String gerenpingjia;

    @ApiModelProperty(value = "个人评分")
    @TableField("GeRenPingFen")
    private String gerenpingfen;

    @ApiModelProperty(value = "是否确认")
    @TableField("ShiFouQueRen")
    private String shifouqueren;

    @ApiModelProperty(value = "自动完成")
    @TableField("ZiDongWanCheng")
    private String zidongwancheng;

    @ApiModelProperty(value = "穿梭框")
    @TableField("ChuanSuoKuang")
    private String chuansuokuang;

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
