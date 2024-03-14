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
 * 物流公司管理
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Wuliugongsiguanli对象", description="物流公司管理")
public class Wuliugongsiguanli implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "物流公司名称")
    @TableField("WuLiuGongSiMingCheng")
    private String wuliugongsimingcheng;

    @ApiModelProperty(value = "地址")
    @TableField("DiZhi")
    private String dizhi;

    @ApiModelProperty(value = "联系人")
    @TableField("LianXiRen")
    private String lianxiren;

    @ApiModelProperty(value = "联系电话")
    @TableField("LianXiDianHua")
    private String lianxidianhua;

    @ApiModelProperty(value = "车辆信息")
    @TableField("CheLiangXinXi")
    private String cheliangxinxi;

    @ApiModelProperty(value = "司机姓名")
    @TableField("SiJiXingMing")
    private String sijixingming;

    @ApiModelProperty(value = "司机电话")
    @TableField("SiJiDianHua")
    private String sijidianhua;

    @ApiModelProperty(value = "车辆规格")
    @TableField("CheLiangGuiGe")
    private String cheliangguige;

    @ApiModelProperty(value = "最大载重")
    @TableField("ZuiDaZaiZhong")
    private String zuidazaizhong;

    @ApiModelProperty(value = "车辆保险")
    @TableField("CheLiangBaoXian")
    private String cheliangbaoxian;

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
