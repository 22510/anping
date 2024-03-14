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
@ApiModel(value="Liuchengdingyi对象", description="")
public class Liuchengdingyi implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "业务名称")
    @TableField("YeWuMingCheng")
    private String yewumingcheng;

    @ApiModelProperty(value = "流程名")
    @TableField("LiuChengMing")
    private String liuchengming;

    @ApiModelProperty(value = "顺序")
    @TableField("ShunXu")
    private String shunxu;

    @ApiModelProperty(value = "角色")
    @TableField("JueSe")
    private String juese;

    @ApiModelProperty(value = "范围")
    @TableField("FanWei")
    private String fanwei;

    @ApiModelProperty(value = "别名")
    @TableField("BieMing")
    private String bieming;

    @ApiModelProperty(value = "退回位置")
    @TableField("TuiHuiWeiZhi")
    private String tuihuiweizhi;


}
