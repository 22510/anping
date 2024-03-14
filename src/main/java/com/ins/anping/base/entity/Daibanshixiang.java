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
 * 
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Daibanshixiang对象", description="")
public class Daibanshixiang implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "待办事项名")
    @TableField("ShiXiangMing")
    private String shixiangming;

    @ApiModelProperty(value = "重要程度")
    @TableField("ZhongYaoChengDu")
    private String zhongyaochengdu;

    @ApiModelProperty(value = "用户名")
    @TableField("YongHuMing")
    private String yonghuming;

    @ApiModelProperty(value = "待办内容")
    @TableField("NeiRong")
    private String neirong;

    @ApiModelProperty(value = "创建/插入时间")
    @TableField("InsertTime")
    private String inserttime;

    @ApiModelProperty(value = "截至时间")
    @TableField("EndTime")
    private String endtime;

    @ApiModelProperty(value = "待办事项状态, 已完成/未完成/已删除")
    @TableField("Statu")
    private String statu;


}
