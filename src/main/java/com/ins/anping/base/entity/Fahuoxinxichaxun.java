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
 * 发货信息查询
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Fahuoxinxichaxun对象", description="发货信息查询")
public class Fahuoxinxichaxun implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同编号")
    @TableField("HeTongBianHao")
    private String hetongbianhao;

    @ApiModelProperty(value = "项目名称")
    @TableField("XiangMuMingCheng")
    private String xiangmumingcheng;

    @ApiModelProperty(value = "项目地址")
    @TableField("XiangMuDiZhi")
    private String xiangmudizhi;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "件数")
    @TableField("JianShu")
    private String jianshu;

    @ApiModelProperty(value = "未发件数")
    @TableField("WeiFaJianShu")
    private String weifajianshu;

    @ApiModelProperty(value = "收货人")
    @TableField("ShouHuoRen")
    private String shouhuoren;

    @ApiModelProperty(value = "收货人联系方式")
    @TableField("ShouHuoRenLianXiFangShi")
    private String shouhuorenlianxifangshi;

    @ApiModelProperty(value = "发起人")
    @TableField("FaQiRen")
    private String faqiren;

    @ApiModelProperty(value = "发起时间")
    @TableField("FaQiShiJian")
    private String faqishijian;

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
