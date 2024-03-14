//package com.ins.anping.other;
//
//import com.alibaba.fastjson2.JSONObject;
//import com.ins.anping.model.common.ResponseResult;
//import com.ins.anping.utils.WebSocket.WebSocketServer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
///**
// * @author QingheLi
// * @描述 WebSocket消息推送控制器
// */
//@Slf4j
//@RestController
//@RequestMapping("/api/busi/socket")
//public class WebSocketController {
//
//    @Autowired
//    private WebSocketServer webSocketServer;
//    // 推送数据到websocket客户端 接口
//    @PostMapping("/push/{yonghuming}")
//    public ResponseResult<?> pushMessage(@PathVariable("yonghuming") String yonghuming, @RequestBody Map<String, String> message) {
//        WebSocketServer.sendInfo(yonghuming, new JSONObject(message).toString());
////        result.put("消息接收方", yonghuming);
////        result.put("msg", message);
//        return ResponseResult.okResult(200, "消息推送成功", message.toString());
//    }
//
////    @PostMapping("/push/{cid}")
////    public ResponseResult<?> sendMessage(@PathVariable("cid") String cid, String message) throws IOException {
////        WebSocketServer.sendMessage(message, cid);
////        return ResponseResult.okResult(200, "操作成功", null);
////    }
//
//}
