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
 * 租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.
 * </p>
 *
 * @author INS
 * @since 2024-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Ziliao4zulinhetong对象", description="租赁合同的资料表	保存一份合同相关的图片和文档等.	关联租赁合同表.")
public class Ziliao4zulinhetong implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "租赁合同的编号")
    @TableField("HeTongBianHao")
    private String hetongbianhao;

    @ApiModelProperty(value = "资料文件的名字")
    @TableField("ZiLiaoMingCheng")
    private String ziliaomingcheng;

    @ApiModelProperty(value = "资料保存的路径")
    @TableField("ZiLiaoPath")
    private String ziliaopath;

    @ApiModelProperty(value = "用户名")
    @TableField("UserName")
    private String username;

    @ApiModelProperty(value = "插入时间")
    @TableField("InsertTime")
    private String inserttime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UpdateTime")
    private String updatetime;


}
