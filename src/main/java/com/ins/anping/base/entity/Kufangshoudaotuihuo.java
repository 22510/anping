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
 * 库房收到退货
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangshoudaotuihuo对象", description="库房收到退货")
public class Kufangshoudaotuihuo implements Serializable {

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

    @ApiModelProperty(value = "丢失明细")
    @TableField("DiuShiMingXi")
    private String diushimingxi;

    @ApiModelProperty(value = "损坏明细")
    @TableField("SunHuaiMingXi")
    private String sunhuaimingxi;

    @ApiModelProperty(value = "收货人")
    @TableField("ShouHuoRen")
    private String shouhuoren;

    @ApiModelProperty(value = "收货人联系方式")
    @TableField("ShouHuoRenLianXiFangShi")
    private String shouhuorenlianxifangshi;

    @ApiModelProperty(value = "收货时间")
    @TableField("ShouHuoShiJian")
    private String shouhuoshijian;

    @ApiModelProperty(value = "驾驶人")
    @TableField("JiaShiRen")
    private String jiashiren;

    @ApiModelProperty(value = "车辆信息")
    @TableField("CheLiangXinXi")
    private String cheliangxinxi;

    @ApiModelProperty(value = "运费")
    @TableField("YunFei")
    private String yunfei;

    @ApiModelProperty(value = "是否垫付")
    @TableField("ShiFouDianFu")
    private String shifoudianfu;

    @ApiModelProperty(value = "垫付价格")
    @TableField("DianFuJiaGe")
    private String dianfujiage;

    @ApiModelProperty(value = "货物状态")
    @TableField("HuoWuZhuangTai")
    private String huowuzhuangtai;

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
