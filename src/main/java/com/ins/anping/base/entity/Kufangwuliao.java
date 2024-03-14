package com.ins.anping.base.entity;

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
 * @since 2024-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangwuliao对象", description="")
public class Kufangwuliao implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Long id;

    @ApiModelProperty(value = "物料编码")
    @TableField("WuLiaoBianMa")
    private String wuliaobianma;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "物料类别")
    @TableField("WuLiaoLeiBie")
    private String wuliaoleibie;

    @ApiModelProperty(value = "组合物料")
    @TableField("ZuHeWuLiao")
    private String zuhewuliao;

    @ApiModelProperty(value = "计量单位")
    @TableField("JiLiangDanWei")
    private String jiliangdanwei;

    @ApiModelProperty(value = "价格")
    @TableField("JiaGe")
    private String jiage;

    @ApiModelProperty(value = "长度")
    @TableField("ZhangDu")
    private String zhangdu;

    @ApiModelProperty(value = "物料重量")
    @TableField("WuLiaoZhongLiang")
    private String wuliaozhongliang;

    @ApiModelProperty(value = "操作人")
    @TableField("UserName")
    private String username;

    @ApiModelProperty(value = "新增数据时间")
    @TableField("Insert_Time")
    private String insertTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("Update_Time")
    private String updateTime;


}
