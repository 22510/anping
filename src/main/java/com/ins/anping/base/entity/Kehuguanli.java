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
 * 客户管理
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kehuguanli对象", description="客户管理")
public class Kehuguanli implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "客户名称")
    @TableField("KeHuMingCheng")
    private String kehumingcheng;

    @ApiModelProperty(value = "客户简称")
    @TableField("KeHuJianCheng")
    private String kehujiancheng;

    @ApiModelProperty(value = "税号")
    @TableField("ShuiHao")
    private String shuihao;

    @ApiModelProperty(value = "单位地址")
    @TableField("DanWeiDiZhi")
    private String danweidizhi;

    @ApiModelProperty(value = "电话")
    @TableField("DianHua")
    private String dianhua;

    @ApiModelProperty(value = "开户行")
    @TableField("KaiHuXing")
    private String kaihuxing;

    @ApiModelProperty(value = "银行账户")
    @TableField("YinHangZhangHu")
    private String yinhangzhanghu;

    @ApiModelProperty(value = "联系人")
    @TableField("LianXiRen")
    private String lianxiren;

    @ApiModelProperty(value = "联系电话")
    @TableField("LianXiDianHua")
    private String lianxidianhua;

    @ApiModelProperty(value = "财务人员")
    @TableField("CaiWuRenYuan")
    private String caiwurenyuan;

    @ApiModelProperty(value = "财务固定电话")
    @TableField("CaiWuGuDingDianHua")
    private String caiwugudingdianhua;

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
