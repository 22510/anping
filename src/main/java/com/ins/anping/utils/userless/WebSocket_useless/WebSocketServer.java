//package com.ins.anping.utils.WebSocket;
//
//import com.ins.anping.utils.UserHolder;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.concurrent.CopyOnWriteArraySet;
//
///**
// * 访问: ws://localhost:8080/ws/{userId}
// * @author QingheLi
// */
//@Component
//@Data
//@Slf4j
//@ServerEndpoint("/api/busi/websocket/{yonghuming}")
//public class WebSocketServer {
//
//    private static int onlineCount = 0;
//    private static final CopyOnWriteArraySet<WebSocketServer> WEB_SOCKET_SERVERS = new CopyOnWriteArraySet<>();
//    private Session session;
//    private String yonghuming = "";
//
//    @OnOpen
//    public void onOpen(Session session, @PathParam("yonghuming") String yonghuming) {
//        // 对于同一用户多地登录, 要关闭前一个地点的连接, 否则消息会发往前一个地点.
////        for (WebSocketServer item : WEB_SOCKET_SERVERS) {
////            if (item.yonghuming.equals(yonghuming)) {
////                WEB_SOCKET_SERVERS.remove(this);
////                //从set中删除
////                subOnlineCount();
////                //在线数减1
////            }
////        }
//        this.session = session;
//        WEB_SOCKET_SERVERS.add(this);
//        //加入set中
//        addOnlineCount();
//        //在线数加1
//        this.yonghuming = yonghuming;
//
//        System.out.println("【websocket】" + yonghuming + "用户" + "已连接！当前在线人数为" + getOnlineCount());
//    }
//
//    @OnClose
//    public void onClose() {
//        WEB_SOCKET_SERVERS.remove(this);
//        //从set中删除
//        subOnlineCount();
//        //在线数减1
//        System.out.println("【websocket】" + yonghuming +  "用户" +  "已关闭！当前在线人数为" + getOnlineCount());
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        if(message.startsWith("target-")){
//            int index = message.indexOf(":");
//            String userId = message.substring(7,index);
//            sendInfo(message.substring(index + 1), userId);
//            return;
//        }
//        this.session = session;
//    }
//
//    @OnError
//    public void onError(Session session, Throwable error) {
//        this.session = session;
//        error.printStackTrace();
//    }
//
//    private void sendMessage(String message) {
//        try {
//            this.session.getBasicRemote().sendText(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void sendMessage(String message, String yonghuming) {
//        log.warn("CID:"+yonghuming);
//        try {
//            this.session.getBasicRemote().sendText(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 群发消息
//    /**
//     * 群发自定义消息
//     */
//    public static void sendInfo(String yonghuming, String message) {
//        for (WebSocketServer item : WEB_SOCKET_SERVERS) {
//            //这里可以设定只推送给这个userId的，为null则全部推送
//            if (yonghuming == null) {
//                item.sendMessage(message);
//            } else if (item.yonghuming.equals(yonghuming)) {
//                log.info("【websocket】From<" + UserHolder.getUser().getUsername() + "> To <" + yonghuming + ">用户" + "，推送内容:" + message);
//                item.sendMessage(message);
//            }
//        }
//    }
//
//
//    public static synchronized int getOnlineCount() {
//        return onlineCount;
//    }
//
//    public static synchronized void addOnlineCount() {
//        WebSocketServer.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount() {
//        WebSocketServer.onlineCount--;
//    }
//
//    public static CopyOnWriteArraySet<WebSocketServer> getWebSocketServers() {
//        return WEB_SOCKET_SERVERS;
//    }
//}