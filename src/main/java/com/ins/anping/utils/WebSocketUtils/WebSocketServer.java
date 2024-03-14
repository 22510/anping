package com.ins.anping.utils.WebSocketUtils;

import com.alibaba.fastjson2.JSON;
import com.ins.anping.base.service.impl.XiaoxituisonglogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//@ServerEndpoint(value = "/websocket", configurator = GetHttpSessionConfigurator.class) // 通过HttpSession拿到用户标识
@ServerEndpoint("/websocket/{user}") // 通过路径变量拿到登录用户标识
//@ServerEndpoint("/websocket") // 通过ThreadLocal创建UserHolder, 登录时建立连接, 从UserHolder里拿. 好像不可行...
@Component
@Slf4j
public class WebSocketServer {

    @Autowired
    private XiaoxituisonglogServiceImpl xiaoxituisonglogService;

    /**
     * ConcurrentHashMap, 线程安全的Map
     * 加static, 保证该集合属于全局, 而不是属于某个对象 ( 所有Endpoint实例都使用同一个集合 )
     * ---
     * 键, 用户标识: 可以考虑通过HttpSession中拿, 也可以考虑请求地址中添加路径变量
     * # 这里使用List<Session>, 若只是Session, 我们的key是用户名, 当用户多处登录时, 会导致新地点建立新连接的Session会覆盖之前的Session, 导致消息只能推送给一个人的最新登录地点.
     */
    private static final Map<String, List<Session>> onLineUsers = new ConcurrentHashMap<>();
    private Session session;
    private String user;

//    private HttpSession httpSession;

    /**
     * 建立WebSocket连接后被调用.
     * 功能:
     * 1. 将Session保存
     * 2. 广播(可选): 将建立连接的所有用户发送给所有用户
     */
//    @OnOpen
//    public void onOpen(Session session, EndpointConfig config) {
//        // onOpen 1. 将用户和Session绑定, 并保存在静态变量中
//        // onOpen 1.1 可以使用HttpSession的方式获取
//        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        String user = (String) this.httpSession.getAttribute("user");
//        // 对于这种, 需要在 LoginController, 登录时, 将用户的信息存入HttpSession的参数中.
//        this.session = session;
//        this.user = user;
//
////        List<Session> userSessions = onLineUsers.getOrDefault(user, new ArrayList<>());
////        userSessions.add(session);
////        onLineUsers.put(user, userSessions);
//        onLineUsers.computeIfAbsent(user, k -> new ArrayList<>()).add(session); // 等价上面三行代码
//        log.info("[WebSocket] 用户<{}>登录系统", user);
//        // 2. 消息广播
////        messageBroadcast(MessageUtils.getMessage("true", null, user, "在线用户列表", getUsers().toString()));
//    }

    @OnOpen
    public void onOpen(Session session, @PathParam("user") String user) {
        this.session = session;
        this.user = user;
        onLineUsers.computeIfAbsent(user, k -> new ArrayList<>()).add(session); // 等价上面三行代码
        log.info("[WebSocket] 用户<{}>登录系统", user);
    }

    /**
     * 浏览器发送消息到服务端, 该方法会被调用
     * 将消息推送给指定用户
     */
    @OnMessage
    public void onMessage(String message) {
        MessageDto msg = JSON.parseObject(message, MessageDto.class);
        if (msg.getToUser().isEmpty()){
            // 如果不设置消息发送人, 则为全体发送.
            messageBroadcast(msg);
        } else if (msg.getToUser().size() == 1) {
            // 只有一个用户, 单发
            messageAlone(msg);
        }else{
            // 多人发送
            messageMulti(msg);
        }
    }

    /**
     * 断开WebSocket连接时被调用
     */
    @OnClose
    public void onClose(Session session) {
        Optional.ofNullable(onLineUsers.get(this.user)).ifPresent(sessions -> {
            sessions.remove(this.session);
            if (sessions.isEmpty()) {
                onLineUsers.remove(this.user);
            }
        });
        log.info("[WebSocket] 用户<{}>离开", user);
    }

    /**
     * 消息广播, 发送给所有在线人员
     *
     * @param message 消息
     */
    private void messageBroadcast(MessageDto message) {
//        onLineUsers.values().stream().flatMap(List::stream).forEach(session -> {
//            try {
//                session.getBasicRemote().sendText(MessageUtils.getMessage(message.getIsSystemMessage(), this.user, null, message.getTitle(), message.getMessage()));
//            } catch (IOException e) {
//                log.error("[WebSocket] 广播消息时发生异常", e);
//            }
//        });
        for (List<Session> sessions : onLineUsers.values()) {
            for (Session session1 : sessions) {
                try {
                    session1.getBasicRemote().sendText(MessageUtils.getMessage(message.getIsSystemMessage(), this.user, null, message.getTitle(), message.getMessage()));
                } catch (IOException e) {
                    log.error("[WebSocket] 广播消息时发生异常", e);
                }
            }
        }
    }

    private void messageAlone(MessageDto msg){
        Optional.ofNullable(onLineUsers.get(msg.getToUser().get(0)))
                .ifPresent(sessions -> sessions.forEach(s -> {
                    try {
                        s.getBasicRemote().sendText(JSON.toJSONString(msg));
                        log.info("[WebSocket] 用户<{}>发送消息给用户<{}>", this.user, msg.getToUser().get(0));
                    } catch (IOException e) {
                        log.error("[WebSocket] 发送消息时发生异常", e);
                    }
                }));
    }

    private void messageMulti(MessageDto msg){
        for (String user : msg.getToUser()){
            Optional.ofNullable(onLineUsers.get(user))
                    .ifPresent(sessions -> sessions.forEach(s -> {
                        try {
                            s.getBasicRemote().sendText(JSON.toJSONString(msg));
                            log.info("[WebSocket] 用户<{}>发送消息给用户<{}>", this.user, msg.getToUser());
                        } catch (IOException e) {
                            log.error("[WebSocket] 发送消息时发生异常", e);
                        }
                    }));
        }
    }

    /**
     * 拿出登录系统所有用户名称
     * 注意这里要用Set? 可能有一个用户多地登录?
     */
    private Set<String> getUsers() {
        return onLineUsers.keySet();
    }

}
