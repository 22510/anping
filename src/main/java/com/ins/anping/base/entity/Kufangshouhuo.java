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
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangshouhuo对象", description="库房收到退货")
public class Kufangshouhuo implements Serializable {

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

    @ApiModelProperty(value = "物料编号")
    @TableField("WuLiaoBianHao")
    private String wuliaobianhao;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "件数 ( 取出损失丢失后, 可收回的件数 )")
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

    @ApiModelProperty(value = "收货订单号")
    @TableField("ShouHuoDingDanHao")
    private String shouhuodingdanhao;

    @ApiModelProperty(value = "车辆信息")
    @TableField("CheLiangXinXi")
    private String cheliangxinxi;

    @ApiModelProperty(value = "配送司机")
    @TableField("PeiSongSiJi")
    private String peisongsiji;

    @ApiModelProperty(value = "货物状态(已收到, 未收到)退货")
    @TableField("HuoWuZhuangTai")
    private String huowuzhuangtai;

    @ApiModelProperty(value = "司机电话")
    @TableField("SiJiDianHua")
    private String sijidianhua;

    @ApiModelProperty(value = "监控人")
    @TableField("JianKongRen")
    private String jiankongren;

    @ApiModelProperty(value = "配送方式")
    @TableField("PeiSongFangShi")
    private String peisongfangshi;

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
