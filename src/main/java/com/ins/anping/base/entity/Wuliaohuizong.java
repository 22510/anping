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
 * 物料汇总
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Wuliaohuizong对象", description="物料汇总")
public class Wuliaohuizong implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "计量单位")
    @TableField("JiLiangDanWei")
    private String jiliangdanwei;

    @ApiModelProperty(value = "长度")
    @TableField("ZhangDu")
    private String zhangdu;

    @ApiModelProperty(value = "物料面积")
    @TableField("WuLiaoMianJi")
    private String wuliaomianji;

    @ApiModelProperty(value = "备注")
    @TableField("BeiZhu")
    private String beizhu;

    @ApiModelProperty(value = "物料单价")
    @TableField("WuLiaoDanJia")
    private String wuliaodanjia;

    @ApiModelProperty(value = "现有库存")
    @TableField("XianYouKuCun")
    private String xianyoukucun;

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
