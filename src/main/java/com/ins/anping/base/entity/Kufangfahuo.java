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
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangfahuo对象", description="发货信息查询")
public class Kufangfahuo implements Serializable {

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

    @ApiModelProperty(value = "件数")
    @TableField("JianShu")
    private Long jianshu;

    @ApiModelProperty(value = "合同总件数")
    @TableField("ZongJianShu")
    private Long zongjianshu;

    @ApiModelProperty(value = "发货人")
    @TableField("FaHuoRen")
    private String fahuoren;

    @ApiModelProperty(value = "发货人联系方式")
    @TableField("FaHuoRenLianXiFangShi")
    private String fahuorenlianxifangshi;

    @ApiModelProperty(value = "收货人")
    @TableField("ShouHuoRen")
    private String shouhuoren;

    @ApiModelProperty(value = "收货人联系方式")
    @TableField("ShouHuoRenLianXiFangShi")
    private String shouhuorenlianxifangshi;

    @ApiModelProperty(value = "发货订单号( 一次发货生成一条发货单号, 用来关联")
    @TableField("FaHuoDingDanHao")
    private String fahuodingdanhao;

    @ApiModelProperty(value = "发货时间")
    @TableField("FaHuoShiJian")
    private String fahuoshijian;

    @ApiModelProperty(value = "配送车辆( 配送车辆信息 )")
    @TableField("PeiSongCheLiang")
    private String peisongcheliang;

    @ApiModelProperty(value = "配送方式")
    @TableField("PeiSongFangShi")
    private String peisongfangshi;

    @ApiModelProperty(value = "配送司机")
    @TableField("PeiSongSiJi")
    private String peisongsiji;

    @ApiModelProperty(value = "司机电话")
    @TableField("SiJiDianHua")
    private String sijidianhua;

    @ApiModelProperty(value = "监控人")
    @TableField("JianKongRen")
    private String jiankongren;

    @ApiModelProperty(value = "货物状态( 已发货, 已送达)")
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
