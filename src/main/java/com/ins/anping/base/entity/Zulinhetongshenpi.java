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
 * 租赁合同审批
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Zulinhetongshenpi对象", description="租赁合同审批")
public class Zulinhetongshenpi implements Serializable {

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

    @ApiModelProperty(value = "承租方社会")
    @TableField("ChengZuFangSheHui")
    private String chengzufangshehui;

    @ApiModelProperty(value = "承租方开户")
    @TableField("ChengZuFangKaiHu")
    private String chengzufangkaihu;

    @ApiModelProperty(value = "项目地址")
    @TableField("XiangMuDiZhi")
    private String xiangmudizhi;

    @ApiModelProperty(value = "接收人")
    @TableField("JieShouRen")
    private String jieshouren;

    @ApiModelProperty(value = "接收人联系")
    @TableField("JieShouRenLianXi")
    private String jieshourenlianxi;

    @ApiModelProperty(value = "合同类型")
    @TableField("HeTongLeiXing")
    private String hetongleixing;

    @ApiModelProperty(value = "物料明细")
    @TableField("WuLiaoMingXi")
    private String wuliaomingxi;

    @ApiModelProperty(value = "起始日期")
    @TableField("QiShiRiQi")
    private String qishiriqi;

    @ApiModelProperty(value = "截至日期")
    @TableField("JieZhiRiQi")
    private String jiezhiriqi;

    @ApiModelProperty(value = "付款节点")
    @TableField("FuKuanJieDian")
    private String fukuanjiedian;

    @ApiModelProperty(value = "物料运费")
    @TableField("WuLiaoYunFei")
    private String wuliaoyunfei;

    @ApiModelProperty(value = "合同图片")
    @TableField("HeTongTuPian")
    private String hetongtupian;

    @ApiModelProperty(value = "合同附加信")
    @TableField("HeTongFuJiaXin")
    private String hetongfujiaxin;

    @ApiModelProperty(value = "物料单价")
    @TableField("WuLiaoDanJia")
    private String wuliaodanjia;

    @ApiModelProperty(value = "赔偿单价")
    @TableField("PeiChangDanJia")
    private String peichangdanjia;

    @ApiModelProperty(value = "计划租量")
    @TableField("JiHuaZuLiang")
    private String jihuazuliang;

    @ApiModelProperty(value = "折扣率")
    @TableField("ZheKouLu")
    private String zhekoulu;

    @ApiModelProperty(value = "备注原因")
    @TableField("BeiZhuYuanYin")
    private String beizhuyuanyin;

    @ApiModelProperty(value = "业务员")
    @TableField("YeWuYuan")
    private String yewuyuan;

    @ApiModelProperty(value = "同执行进度")
    @TableField("TongZhiXingJinDu")
    private String tongzhixingjindu;

    @ApiModelProperty(value = "是否通过审批")
    @TableField("ShiFouTongGuoShenPi")
    private String shifoutongguoshenpi;

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
