package com.ins.anping.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 库房物料数量变动日志
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangwuliaobiandonglog对象", description="库房物料数量变动日志")
public class Kufangwuliaobiandonglog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID")
    private Long id;

    @ApiModelProperty(value = "物料编号")
    @TableField("WuLiaoBianHao")
    private String wuliaobianhao;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "数量")
    @TableField("ShuLiang")
    private Long shuliang;

    @ApiModelProperty(value = "增加/减少")
    @TableField("BianDong")
    private String biandong;

    @ApiModelProperty(value = "数量变动原因")
    @TableField("YuanYin")
    private String yuanyin;

    @ApiModelProperty(value = "数量变动关联的业务标识")
    @TableField("YeWuBiaoShi")
    private String yewubiaoshi;

    @ApiModelProperty(value = "变动时间")
    @TableField("BianDongShiJian")
    private String biandongshijian;

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
