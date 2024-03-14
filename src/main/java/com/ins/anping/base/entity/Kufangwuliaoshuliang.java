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
 * 物料数量
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangwuliaoshuliang对象", description="物料数量")
public class Kufangwuliaoshuliang implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "物料编号	")
    @TableField("WuLiaoBianHao")
    private String wuliaobianhao;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "物料缺货指标, 当库存数量少于x时标记为缺货")
    @TableField("ShangPinQueHuo")
    private Long shangpinquehuo;

    @ApiModelProperty(value = "销售合同卖出时, 别人购买数量的上限")
    @TableField("GouMaiShangXian")
    private Long goumaishangxian;

    @ApiModelProperty(value = "销售合同卖出时, 别人购买数量的购买下限")
    @TableField("GouMaiXiaXian")
    private Long goumaixiaxian;

    @ApiModelProperty(value = "租赁合同租出时, 别人租用数量的上限")
    @TableField("ZuLinShangXian")
    private Long zulinshangxian;

    @ApiModelProperty(value = "租赁合同租出时, 别人租用数量的下限")
    @TableField("ZuLinXiaXian")
    private Long zulinxiaxian;

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
