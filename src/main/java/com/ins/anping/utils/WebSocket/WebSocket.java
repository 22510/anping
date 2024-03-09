//package com.ins.anping.utils.WebSocket;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author QingheLi
// */
//@Component
//@Slf4j
//@Data
//@ServerEndpoint("/api/busi/websocket/{userId}")  // 接口路径 ws://localhost:8087/webSocket/userId;
///**
// * 创建一个echo端点, 处理客户端的连接, 断开, 消息事件
// */
//public class WebSocket {
//
//    //与某个客户端的连接会话，需要通过它来给客户端发送数据
//    private Session session;
//    /**
//     * 用户ID
//     */
//    private String id;
//    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
//    private static AtomicInteger onlineCount = new AtomicInteger(0);
//    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//    //虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
//    //  注：底下WebSocket是当前类名
//    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
//    // 用来存在线连接用户信息
//    private static ConcurrentHashMap<String,Session> sessionPool = new ConcurrentHashMap<String,Session>();
//
//    /**
//     * 链接成功调用的方法
//     */
//    @OnOpen
//    public void onOpen(Session session, @PathParam(value="id")String id) {
//        this.session = session;
//        this.id = id;
//        webSockets.add(this);
//        sessionPool.put(id, session);
//        log.info("【websocket消息】有新的连接{"+id+"}，总数为:"+webSockets.size());
//        // 这不是就能用来统计系统在线人数咯
//    }
//
//    /**
//     * 链接关闭调用的方法
//     */
//    @OnClose
//    public void onClose() {
//        try {
//            webSockets.remove(this);
//            sessionPool.remove(this.id);
//            log.info("【websocket消息】连接断开，总数为:"+webSockets.size());
//        } catch (Exception e) {
//        }
//    }
//    /**
//     * 收到客户端消息后调用的方法
//     *
//     * @param message
//     */
//    @OnMessage
//    // 接收消息
//    public void onMessage(String message) {
//        log.info("【websocket消息】收到客户端消息:"+message);
//        if ("BYE".equals(message)){
//            this.onClose();
//        }
//
//    }
//
//    /** 发送错误时的处理
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) throws Throwable {
//
//        log.error("用户错误,原因:"+error.getMessage());
//        throw error;
//    }
//
//
//    // 此为广播消息
//    public void sendAllMessage(String message) {
//        log.info("【websocket消息】广播消息:"+message);
//        for(WebSocket webSocket : webSockets) {
//            try {
//                if(webSocket.session.isOpen()) {
//                    webSocket.session.getAsyncRemote().sendText(message);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // 此为单点消息
//    public void sendOneMessage(String userId, String message) {
//        Session session = sessionPool.get(userId);
//        if (session != null&&session.isOpen()) {
//            try {
//                log.info("【websocket消息】 单点消息:"+message);
//                session.getAsyncRemote().sendText(message);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // 此为单点消息(多人)
//    public void sendMoreMessage(String[] userIds, String message) {
//        for(String userId:userIds) {
//            Session session = sessionPool.get(userId);
//            if (session != null&&session.isOpen()) {
//                try {
//                    log.info("【websocket消息】 单点消息:"+message);
//                    session.getAsyncRemote().sendText(message);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//}