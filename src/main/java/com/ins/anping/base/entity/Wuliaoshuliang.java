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
 * 物料数量
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Wuliaoshuliang对象", description="物料数量")
public class Wuliaoshuliang implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品编号")
    @TableField("ShangPinBianHao")
    private String shangpinbianhao;

    @ApiModelProperty(value = "商品数量")
    @TableField("ShangPinShuLiang")
    private String shangpinshuliang;

    @ApiModelProperty(value = "商品库存")
    @TableField("ShangPinKuCun")
    private String shangpinkucun;

    @ApiModelProperty(value = "商品缺货")
    @TableField("ShangPinQueHuo")
    private String shangpinquehuo;

    @ApiModelProperty(value = "购买上限")
    @TableField("GouMaiShangXian")
    private String goumaishangxian;

    @ApiModelProperty(value = "购买下限")
    @TableField("GouMaiXiaXian")
    private String goumaixiaxian;

    @ApiModelProperty(value = "进货上限")
    @TableField("JinHuoShangXian")
    private String jinhuoshangxian;

    @ApiModelProperty(value = "进货下限")
    @TableField("JinHuoXiaXian")
    private String jinhuoxiaxian;

    @ApiModelProperty(value = "总进货数量")
    @TableField("ZongJinHuoShuLiang")
    private String zongjinhuoshuliang;

    @ApiModelProperty(value = "本次进货数量")
    @TableField("BenCiJinHuoShuLiang")
    private String bencijinhuoshuliang;

    @ApiModelProperty(value = "本次进货时间")
    @TableField("BenCiJinHuoShiJian")
    private String bencijinhuoshijian;

    @ApiModelProperty(value = "历史进货数量")
    @TableField("LiShiJinHuoShuLiang")
    private String lishijinhuoshuliang;

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
