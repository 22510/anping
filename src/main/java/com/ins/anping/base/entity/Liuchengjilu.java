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
@ApiModel(value="Liuchengjilu对象", description="")
public class Liuchengjilu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField("YongHuMing")
    private String yonghuming;

    @ApiModelProperty(value = "流程名称")
    @TableField("LiuChengMingCheng")
    private String liuchengmingcheng;

    @ApiModelProperty(value = "执行所到节点")
    @TableField("ShunXu")
    private String shunxu;

    @ApiModelProperty(value = "业务标识(索引到具体业务信息)")
    @TableField("YeWuBiaoShi")
    private String yewubiaoshi;

    @ApiModelProperty(value = "时间")
    private String time;

    @ApiModelProperty(value = "流程在该节点的处理结果(继续/回退)")
    @TableField("ChuLiJieGuo")
    private String chulijieguo;

    @ApiModelProperty(value = "处理结果备注")
    @TableField("BeiZhu")
    private String beizhu;


}
