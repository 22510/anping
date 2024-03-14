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
 * 用户管理
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Yonghuguanli对象", description="用户管理")
public class Yonghuguanli implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField("YongHuMing")
    private String yonghuming;

    @ApiModelProperty(value = "角色")
    @TableField("JueSe")
    private String juese;

    @ApiModelProperty(value = "用户性质")
    @TableField("YongHuXingZhi")
    private String yonghuxingzhi;

    @ApiModelProperty(value = "联系电话")
    @TableField("LianXiDianHua")
    private String lianxidianhua;

    @ApiModelProperty(value = "手机")
    @TableField("ShouJi")
    private String shouji;

    @ApiModelProperty(value = "姓名")
    @TableField("XingMing")
    private String xingming;

    @ApiModelProperty(value = "邮箱")
    @TableField("YouXiang")
    private String youxiang;

    @ApiModelProperty(value = "单位")
    @TableField("DanWei")
    private String danwei;

    @ApiModelProperty(value = "地址")
    @TableField("DiZhi")
    private String dizhi;

    @ApiModelProperty(value = "用户状态")
    @TableField("YongHuZhuangTai")
    private String yonghuzhuangtai;

    @ApiModelProperty(value = "密码")
    @TableField("MiMa")
    private String mima;

    @ApiModelProperty(value = "账号有效期")
    @TableField("ZhangHaoYouXiaoQi")
    private String zhanghaoyouxiaoqi;

    @ApiModelProperty(value = "注册时间")
    @TableField("ZhuCeShiJian")
    private String zhuceshijian;

    @ApiModelProperty(value = "上级名字")
    @TableField("Leader")
    private String leader;

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
