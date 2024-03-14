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
 * 工具栏
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Gongjulan对象", description="工具栏")
public class Gongjulan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String anjianmingcheng;

    @ApiModelProperty(value = "名称")
    @TableField("MingCheng")
    private String mingcheng;

    @ApiModelProperty(value = "父ID")
    @TableField("FuID")
    private String fuid;

    @ApiModelProperty(value = "是否打开窗口")
    @TableField("ShiFouDaKaiChuangKou")
    private String shifoudakaichuangkou;

    @ApiModelProperty(value = "图标")
    @TableField("TuBiao")
    private String tubiao;

    @ApiModelProperty(value = "前景颜色")
    @TableField("QianJingYanSe")
    private String qianjingyanse;

    @ApiModelProperty(value = "背影颜色")
    @TableField("BeiJingYanSe")
    private String beijingyanse;

    @ApiModelProperty(value = "是否选择一行")
    @TableField("ShiFouXuanZeYiXing")
    private String shifouxuanzeyixing;

    @ApiModelProperty(value = "执行操作")
    @TableField("ZhiXingCaoZuo")
    private String zhixingcaozuo;

    @ApiModelProperty(value = "组件类型")
    @TableField("ZuJianLeiXing")
    private String zujianleixing;

    @ApiModelProperty(value = "备注")
    @TableField("BeiZhu")
    private String beizhu;

    @ApiModelProperty(value = "说明")
    @TableField("ShuoMing")
    private String shuoming;

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
