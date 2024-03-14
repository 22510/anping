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
 * 库房物料总体管理
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangwuliao对象", description="库房物料总体管理")
public class Kufangwuliao implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "物料编号	")
    @TableField("WuLiaoBianHao")
    private String wuliaobianhao;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "物料类别")
    @TableField("WuLiaoLeiBie")
    private String wuliaoleibie;

    @ApiModelProperty(value = "规格")
    @TableField("WuLiaoGuiGe")
    private String wuliaoguige;

    @ApiModelProperty(value = "型号")
    @TableField("WuLiaoXingHao")
    private String wuliaoxinghao;

    @ApiModelProperty(value = "计量单位")
    @TableField("JiLiangDanWei")
    private String jiliangdanwei;

    @ApiModelProperty(value = "长度")
    @TableField("ZhangDu")
    private String zhangdu;

    @ApiModelProperty(value = "物料重量")
    @TableField("WuLiaoZhongLiang")
    private String wuliaozhongliang;

    @ApiModelProperty(value = "物料面积")
    @TableField("WuLiaoMianJi")
    private String wuliaomianji;

    @ApiModelProperty(value = "现有库存")
    @TableField("XianYouKuCun")
    private Long xianyoukucun;

    @ApiModelProperty(value = "备注")
    @TableField("BeiZhu")
    private String beizhu;

    @ApiModelProperty(value = "组合物料")
    @TableField("ZuHeWuLiao")
    private String zuhewuliao;

    @ApiModelProperty(value = "租赁价格 ( 基础价格")
    @TableField("ZuLinJiaGe")
    private String zulinjiage;

    @ApiModelProperty(value = "销售价格 ( 基础价格")
    @TableField("XiaoShouJiaGe")
    private String xiaoshoujiage;

    @ApiModelProperty(value = "是否删除, 删除标记1")
    private Integer isDelete;

    @ApiModelProperty(value = "操作人")
    @TableField("UserName")
    private String username;

    @ApiModelProperty(value = "新增数据时间")
    @TableField("Insert_Time")
    private String insertTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("Update_Time")
    private String updateTime;


}
