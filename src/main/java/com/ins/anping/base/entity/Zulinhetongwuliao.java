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
 * 租赁合同物料
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Zulinhetongwuliao对象", description="租赁合同物料")
public class Zulinhetongwuliao implements Serializable {

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

    @ApiModelProperty(value = "租赁价格(含税)")
    @TableField("ZuLinJiaGeHanShui")
    private String zulinjiagehanshui;

    @ApiModelProperty(value = "租赁价格(不含税)")
    @TableField("ZuLinJiaGeBuHanShui")
    private String zulinjiagebuhanshui;

    @ApiModelProperty(value = "租赁数量")
    @TableField("ZuLinShuLiang")
    private Long zulinshuliang;

    @ApiModelProperty(value = "损坏赔偿")
    @TableField("SunHuaiPeiChang")
    private String sunhuaipeichang;

    @ApiModelProperty(value = "丢失赔偿")
    @TableField("DiuShiPeiChang")
    private String diushipeichang;

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
