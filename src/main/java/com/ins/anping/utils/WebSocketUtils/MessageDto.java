package com.ins.anping.utils.WebSocketUtils;

import lombok.Data;

import java.util.List;

/**
 * 前端发送JSON形式数据, 对应的类
 * {
 *     "toUser":xxx,
 *     "title":xxx,
 *     "message":xxx
 * }
 */
@Data
public class MessageDto {
    private String isSystemMessage;
    private List<String> toUser;
    private String title;
    private String message;
}
