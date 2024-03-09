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
 * 方柱扣
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Fangzhukou对象", description="方柱扣")
public class Fangzhukou implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
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
