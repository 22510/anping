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
 * 租赁合同
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Zulinhetong对象", description="租赁合同")
public class Zulinhetong implements Serializable {

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

    @ApiModelProperty(value = "出租单位")
    @TableField("ChuZuDanWei")
    private String chuzudanwei;

    @ApiModelProperty(value = "承租单位")
    @TableField("ChengZuDanWei")
    private String chengzudanwei;

    @ApiModelProperty(value = "承租方社会信息代码")
    @TableField("ChengZuFangSheHuiXinXiDaiMa")
    private String chengzufangshehuixinxidaima;

    @ApiModelProperty(value = "承租方开户行")
    @TableField("ChengZuFangKaiHuXing")
    private String chengzufangkaihuxing;

    @ApiModelProperty(value = "项目地址")
    @TableField("XiangMuDiZhi")
    private String xiangmudizhi;

    @ApiModelProperty(value = "接收人")
    @TableField("JieShouRen")
    private String jieshouren;

    @ApiModelProperty(value = "接收人联系方式")
    @TableField("JieShouRenLianXiFangShi")
    private String jieshourenlianxifangshi;

    @ApiModelProperty(value = "合同类型")
    @TableField("HeTongLeiXing")
    private String hetongleixing;

    @ApiModelProperty(value = "起始日期")
    @TableField("QiShiRiQi")
    private String qishiriqi;

    @ApiModelProperty(value = "截至日期")
    @TableField("JieZhiRiQi")
    private String jiezhiriqi;

    @ApiModelProperty(value = "运费计算: 一份合同下, 租赁物料的运输费用相关事宜")
    @TableField("YunFeiJiSuan")
    private String yunfeijisuan;

    @ApiModelProperty(value = "合同资料")
    @TableField("HeTongTuPian")
    private String hetongtupian;

    @ApiModelProperty(value = "合同附加信息")
    @TableField("HeTongFuJiaXinXi")
    private String hetongfujiaxinxi;

    @ApiModelProperty(value = "备注原因")
    @TableField("BeiZhuYuanYin")
    private String beizhuyuanyin;

    @ApiModelProperty(value = "业务员")
    @TableField("YeWuYuan")
    private String yewuyuan;

    @ApiModelProperty(value = "合同执行进度: 待审核, 审批中, 待备货, 待发货, 发货中, 租赁中, 退货中, 已完成. 已作废.")
    @TableField("HeTongZhiXingJinDu")
    private String hetongzhixingjindu;

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
