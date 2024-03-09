package com.ins.anping.utils.WebSocket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author QingheLi
 * @描述 WebSocket消息推送控制器
 */
@RestController
public class WebSocketController {

    // 推送数据到websocket客户端 接口
    @GetMapping("/api/busi/socket/push/{cid}")
    public Map pushMessage(@PathVariable("cid") String cid, String message) {
        Map<String, Object> result = new HashMap<>();
        try {
            WebSocketServer.sendMessage(message, cid);
            result.put("code", cid);
            result.put("msg", message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
