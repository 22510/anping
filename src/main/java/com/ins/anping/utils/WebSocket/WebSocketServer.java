package com.ins.anping.utils.WebSocket;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author QingheLi
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端。
 */
@Data
@Component
@Slf4j
@Service
@ServerEndpoint("/api/busi/websocket/{sid}")
// 接口路径 ws://localhost:8080/webSocket/sid;
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static final AtomicInteger ONLINE_COUNT = new AtomicInteger(0);
    /**
     *  获取当前在线客户端对应的WebSocket对
     */
    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。
    //虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
    //  注：底下WebSocket是当前类名
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //接收sid 用户数据库ID
    private String sid;

    // 用来存在线连接用户信息
    private static ConcurrentHashMap<String,Session> sessionPool = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        this.sid = sid;
        if (!webSocketSet.add(this)){
            throw new RuntimeException("消息推送服务启动失败.");
        }
        // 加入set中
        // addOnlineCount();
        // 在线数加1
        // sendMessage("conn_success");
        sessionPool.put(sid, session);
//        if () {
//            throw new RuntimeException("消息推送服务启动失败.");
//        }
        log.info("[WebSocket] 用户<" + sid + ">登录系统");
        // , 当前在线人数为:" + webSocketSet.size()
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        // 从set中删除
//        subOnlineCount();              // 在线数减1
        sessionPool.remove(this.sid);
        // 断开连接情况下，更新主板占用情况为释放
        log.info("[WebSocket] 用户sid=" + sid + "离开系统");
    }

//    private void releaseResource() {
//        // 这里写释放资源和要处理的业务
//        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
//    }

    /**
     * 收到客户端消息后调用的方法
     * @Param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        log.info("[WebSocket] 收到来自用户<" + sid + ">的信息:" + message);
//        // 群发消息
//        HashSet<String> sids = new HashSet<>();
//        for (WebSocketServer item : webSocketSet) {
//            sids.add(item.sid);
//        }
        if ("BYE".equals(message)){
            this.onClose();
        }
//      sendMessage("客户端 " + this.sid + "发布消息：" + message, sid);
    }

    /**
     * 发生错误回调
     */
    @OnError
    public void onError(Session session, Throwable error) throws Throwable {
        log.error("[WebSocket]" + session.getBasicRemote() + "客户端发生错误");
        throw error;
    }

    /**
     * 群发自定义消息
     * 若指定ID列表, 就发送那些ID的用户
     */
    public static void sendMessage(String message, HashSet<String> toSids) throws IOException {
        for (WebSocketServer item : webSocketSet) {
            //这里可以设定只推送给传入的sid，为null则全部推送
            if (toSids.isEmpty()) {
                item.session.getAsyncRemote().sendText(message);
            }else if (toSids.contains(item.sid)) {
                item.session.getAsyncRemote().sendText(message);
            }
        }
        log.info("[WebSocket]推送消息到客户端 " + toSids + "，推送内容:" + message);
    }

    /**
     * 实现服务器主动推送消息到 指定客户端
     *
     * @return
     */
    public static Future<Void> sendMessage(String message, String sid) throws IOException {
        Session session = sessionPool.get(sid);
        if (session != null && session.isOpen()) {
            return session.getAsyncRemote().sendText(message);
        }
        log.info("[WebSocket] 推送消息到<" + sid + ">，推送内容:" + message);
        return null;
    }

//    /**
//     * 获取当前在线人数
//     *
//     * @return
//     */
//    public static int getOnlineCount() {
//        return onlineCount.get();
//    }

//    /**
//     * 当前在线人数 +1
//     *
//     * @return
//     */
//    public static void addOnlineCount() {
//        onlineCount.getAndIncrement();
//    }
//
//    /**
//     * 当前在线人数 -1
//     *
//     * @return
//     */
//    public static void subOnlineCount() {
//        onlineCount.getAndDecrement();
//    }

}
