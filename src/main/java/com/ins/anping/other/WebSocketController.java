package com.ins.anping.other;

import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.WebSocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author QingheLi
 * @描述 WebSocket消息推送控制器
 */
@Slf4j
@RestController("/api/busi/socket")
public class WebSocketController {

    // 推送数据到websocket客户端 接口
    @GetMapping("/api/busi/socket/push/{cid}")
    public Map pushMessage(@PathVariable("cid") String cid, String message) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (WebSocketServer.sendMessage(message, cid) == null){
                System.out.println("空...");
            }
            result.put("code", cid);
            result.put("msg", message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/push/{cid}")
    public ResponseResult<?> sendMessage(@PathVariable("cid") String cid, String message) throws IOException {
        WebSocketServer.sendMessage(message, cid);
        return ResponseResult.okResult(200, "操作成功", null);
    }

}
