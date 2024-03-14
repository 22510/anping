package com.ins.anping.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 库房备货查询
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangbeihuo对象", description="库房备货查询")
public class Kufangbeihuo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同编号")
    @TableField("HeTongBianHao")
    private String hetongbianhao;

    @ApiModelProperty(value = "物料编号")
    @TableField("WuLiaoBianHao")
    private String wuliaobianhao;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "合同要求数量")
    @TableField("ZuLinShuLiang")
    private String zulinshuliang;

    @ApiModelProperty(value = "库房备货数量")
    @TableField("KuFangBeiHuoShuLiang")
    private String kufangbeihuoshuliang;

    @ApiModelProperty(value = "备货状态")
    @TableField("BeiHuoZhuangTai")
    private String beihuozhuangtai;

    @ApiModelProperty(value = "备货完成时间")
    @TableField("BeiHuoWanChengShiJian")
    private String beihuowanchengshijian;

    @ApiModelProperty(value = "备货人员")
    @TableField("BeiHuoRenYuan")
    private String beihuorenyuan;

    @ApiModelProperty(value = "备货说明")
    @TableField("BeiHuoShuoMing")
    private String beihuoshuoming;

    @ApiModelProperty(value = "收货人")
    @TableField("ShouHuoRen")
    private String shouhuoren;

    @ApiModelProperty(value = "收货人联系方式")
    @TableField("ShouHuoRenLianXiFangShi")
    private String shouhuorenlianxifangshi;

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
