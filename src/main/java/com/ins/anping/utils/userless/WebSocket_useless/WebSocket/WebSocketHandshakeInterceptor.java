//package com.ins.anping.config.WebSocket;
//
//import com.ins.anping.utils.JwtToken;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//import java.util.Collection;
//import java.util.Map;
//
///**
// * @author QingheLi
// */
//@Slf4j
//@Component
//public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
//
//    private final JwtToken jwtToken;
//
//    public WebSocketHandshakeInterceptor(JwtToken jwtToken) {
//        this.jwtToken = jwtToken;
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//                               Exception ex) {
//    }
//
//    /*
//     * 握手前
//     * @see org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor#beforeHandshake(org.springframework.http.server.ServerHttpRequest, org.springframework.http.server.ServerHttpResponse, org.springframework.web.socket.WebSocketHandler, java.util.Map)
//     */
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//                                   Map<String, Object> attributes) throws Exception {
//        HttpHeaders headers = request.getHeaders();
//        log.warn(String.valueOf(headers));
//        String token = headers.getFirst("token");
//        System.out.println("拦截器获取的token"+token);
//        if(token == null) {
//            response.setStatusCode(HttpStatus.FORBIDDEN);
//            log.warn("已拦截token");
//            return false;
//
//        }
//        response.setStatusCode(HttpStatus.OK);
//        return true;
//    }
//
//    @Override
//    public Collection<String> getAttributeNames() {
//        // TODO Auto-generated method stub
//        return super.getAttributeNames();
//    }
//
//    @Override
//    public boolean isCopyAllAttributes() {
//        // TODO Auto-generated method stub
//        return super.isCopyAllAttributes();
//    }
//
//    @Override
//    public boolean isCopyHttpSessionId() {
//        // TODO Auto-generated method stub
//        return super.isCopyHttpSessionId();
//    }
//
//    @Override
//    public boolean isCreateSession() {
//        // TODO Auto-generated method stub
//        return super.isCreateSession();
//    }
//
//    @Override
//    public void setCopyAllAttributes(boolean copyAllAttributes) {
//        // TODO Auto-generated method stub
//        super.setCopyAllAttributes(copyAllAttributes);
//    }
//
//    @Override
//    public void setCopyHttpSessionId(boolean copyHttpSessionId) {
//        // TODO Auto-generated method stub
//        super.setCopyHttpSessionId(copyHttpSessionId);
//    }
//
//    @Override
//    public void setCreateSession(boolean createSession) {
//        // TODO Auto-generated method stub
//        super.setCreateSession(createSession);
//    }
//}
