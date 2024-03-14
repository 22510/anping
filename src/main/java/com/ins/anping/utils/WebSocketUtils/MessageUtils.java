package com.ins.anping.utils.WebSocketUtils;

import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MessageUtils {

    /*
    是否为系统消息, true, false
     */
//    private String isSystemMessage;
//    private String fromUser;
//    private String toUser;
//    private String title;
//    private String message;

    public static String getMessage(String isSystemMessage, String fromUser, String toUser, String title, String message){
        Map<String, Object> messageObj = new HashMap<>();
        messageObj.put("isSystemMessage", isSystemMessage);
        messageObj.put("fromUser", fromUser);
        messageObj.put("toUser", toUser);
        messageObj.put("title", title);
        messageObj.put("message", message);
        return JSONObject.toJSONString(message);
    }
}
