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
 * 租赁清算
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Zulinqingsuan对象", description="租赁清算")
public class Zulinqingsuan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "合同编号")
    @TableField("HeTongBianHao")
    private String hetongbianhao;

    @ApiModelProperty(value = "物料名称")
    @TableField("WuLiaoMingCheng")
    private String wuliaomingcheng;

    @ApiModelProperty(value = "物料数量")
    @TableField("WuLiaoShuLiang")
    private String wuliaoshuliang;

    @ApiModelProperty(value = "物料日租金")
    @TableField("WuLiaoRiZuJin")
    private String wuliaorizujin;

    @ApiModelProperty(value = "起租时间")
    @TableField("QiZuShiJian")
    private String qizushijian;

    @ApiModelProperty(value = "退回时间")
    @TableField("TuiHuiShiJian")
    private String tuihuishijian;

    @ApiModelProperty(value = "未损坏价钱")
    @TableField("WeiSunHuaiJiaQian")
    private String weisunhuaijiaqian;

    @ApiModelProperty(value = "物料损坏情")
    @TableField("WuLiaoSunHuaiQing")
    private String wuliaosunhuaiqing;

    @ApiModelProperty(value = "折扣率")
    @TableField("ZheKouLu")
    private String zhekoulu;

    @ApiModelProperty(value = "赔偿价格")
    @TableField("PeiChangJiaGe")
    private String peichangjiage;

    @ApiModelProperty(value = "总计")
    @TableField("ZongJi")
    private String zongji;

    @ApiModelProperty(value = "最终清算价钱")
    @TableField("ZuiZhongQingSuanJiaQian")
    private String zuizhongqingsuanjiaqian;

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
