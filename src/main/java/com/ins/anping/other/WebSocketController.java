package com.ins.anping.other;

import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.WebSocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QingheLi
 * @描述 WebSocket消息推送控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/busi/socket")
public class WebSocketController {

    @Autowired
    private WebSocketServer webSocketServer;
    // 推送数据到websocket客户端 接口
    @PostMapping("/push/{yonghuming}")
    public ResponseResult<?> pushMessage(@PathVariable("yonghuming") String yonghuming, String message) {
        Map<String, Object> result = new HashMap<>();
        WebSocketServer.sendInfo(yonghuming, message);
        result.put("消息接收方", yonghuming);
        result.put("msg", message);
        return ResponseResult.okResult(200, "消息推送成功", result);
    }

//    @PostMapping("/push/{cid}")
//    public ResponseResult<?> sendMessage(@PathVariable("cid") String cid, String message) throws IOException {
//        WebSocketServer.sendMessage(message, cid);
//        return ResponseResult.okResult(200, "操作成功", null);
//    }

}
