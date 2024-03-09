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
 * 库房备货查询
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangbeihuochaxun对象", description="库房备货查询")
public class Kufangbeihuochaxun implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同编号")
    @TableField("HeTongBianHao")
    private String hetongbianhao;

    @ApiModelProperty(value = "物料编码")
    @TableField("WuLiaoBianMa")
    private String wuliaobianma;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "物料类别")
    @TableField("WuLiaoLeiBie")
    private String wuliaoleibie;

    @ApiModelProperty(value = "计量单位")
    @TableField("JiLiangDanWei")
    private String jiliangdanwei;

    @ApiModelProperty(value = "物料数量")
    @TableField("WuLiaoShuLiang")
    private String wuliaoshuliang;

    @ApiModelProperty(value = "备货状态")
    @TableField("BeiHuoZhuangTai")
    private String beihuozhuangtai;

    @ApiModelProperty(value = "执行人")
    @TableField("ZhiXingRen")
    private String zhixingren;

    @ApiModelProperty(value = "使用时间")
    @TableField("ShiYongShiJian")
    private String shiyongshijian;

    @ApiModelProperty(value = "备货说明")
    @TableField("BeiHuoShuoMing")
    private String beihuoshuoming;

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
