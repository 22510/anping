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
 * 库房发货方式管理
 * </p>
 *
 * @author INS
 * @since 2024-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kufangfahuofangshiguanli对象", description="库房发货方式管理")
public class Kufangfahuofangshiguanli implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自动增加的ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "发货订单号")
    @TableField("FaHuoDingDanHao")
    private String fahuodingdanhao;

    @ApiModelProperty(value = "总单号")
    @TableField("ZongDanHao")
    private String zongdanhao;

    @ApiModelProperty(value = "分单号")
    @TableField("FenDanHao")
    private String fendanhao;

    @ApiModelProperty(value = "配送方式")
    @TableField("PeiSongFangShi")
    private String peisongfangshi;

    @ApiModelProperty(value = "配送车辆")
    @TableField("PeiSongCheLiang")
    private String peisongcheliang;

    @ApiModelProperty(value = "配送司机")
    @TableField("PeiSongSiJi")
    private String peisongsiji;

    @ApiModelProperty(value = "司机电话")
    @TableField("SiJiDianHua")
    private String sijidianhua;

    @ApiModelProperty(value = "监控人")
    @TableField("JianKongRen")
    private String jiankongren;

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
