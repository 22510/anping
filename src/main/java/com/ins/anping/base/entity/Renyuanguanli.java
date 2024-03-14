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
 * 人员管理
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Renyuanguanli对象", description="人员管理")
public class Renyuanguanli implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "姓名")
    @TableField("XingMing")
    private String xingming;

    @ApiModelProperty(value = "年龄")
    @TableField("NianLing")
    private String nianling;

    @ApiModelProperty(value = "性别")
    @TableField("XingBie")
    private String xingbie;

    @ApiModelProperty(value = "家庭住址")
    @TableField("JiaTingZhuZhi")
    private String jiatingzhuzhi;

    @ApiModelProperty(value = "邮箱")
    @TableField("YouXiang")
    private String youxiang;

    @ApiModelProperty(value = "电话")
    @TableField("DianHua")
    private String dianhua;

    @ApiModelProperty(value = "手机")
    @TableField("ShouJi")
    private String shouji;

    @ApiModelProperty(value = "职务")
    @TableField("ZhiWu")
    private String zhiwu;

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
