package com.ins.anping.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author INS
 * @since 2024-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Xiaoxituisonglog对象", description="")
public class Xiaoxituisonglog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息通信记录ID")
    private Long id;

    @ApiModelProperty(value = "消息内容")
    @TableField("XiaoXiNeiRong")
    private String xiaoxineirong;

    @ApiModelProperty(value = "消息发送者的用户ID")
    @TableField("FaSongFangId")
    private String fasongfangid;

    @ApiModelProperty(value = "消息接收者的用户ID")
    @TableField("JieShouFangId")
    private String jieshoufangid;

    @ApiModelProperty(value = "消息状态: sent, read, 已发送, 已读")
    private String status;

    @ApiModelProperty(value = "消息类型: info, remind, warn, 通知, 提醒, 警告")
    private String type;

    @ApiModelProperty(value = "用户名, 执行此操作的用户信息 ( 不确定是否需要 )")
    @TableField("UserName")
    private String username;

    @ApiModelProperty(value = "消息发送时间")
    @TableField("InsertTime")
    private String inserttime;

    @ApiModelProperty(value = "消息更新时间 ( 可以用来记录接收方读取该消息的时间 )")
    @TableField("UpdateTime")
    private String updatetime;


}
