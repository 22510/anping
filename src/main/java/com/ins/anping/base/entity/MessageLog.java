package com.ins.anping.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author INS
 * @since 2024-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MessageLog对象", description="")
public class MessageLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增ID")
    private Long id;

    @ApiModelProperty(value = "是否为系统消息, true/false")
    private String isSystemMessage;

    @ApiModelProperty(value = "消息来自用户名")
    private String fromUser;

    @ApiModelProperty(value = "消息发往用户名")
    private String toUser;

    @ApiModelProperty(value = "消息标题")
    private String title;

    @ApiModelProperty(value = "消息内容")
    private String message;

    @ApiModelProperty(value = "消息发送时间")
    private String sendTime;

    @ApiModelProperty(value = "是否已读, yes/no")
    private String status;

    @ApiModelProperty(value = "消息类型: info, warn, 通知, 警告")
    private String type;

    @TableField("UserName")
    private String username;

    @TableField("InsertTime")
    private String inserttime;

    @TableField("UpdateTime")
    private String updatetime;


}
