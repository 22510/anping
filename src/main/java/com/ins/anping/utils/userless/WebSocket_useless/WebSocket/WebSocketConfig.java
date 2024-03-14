//package com.ins.anping.config.WebSocket;
//
///**
// * @author QingheLi
// */
////@Configuration
////@EnableWebSocket
//////@EnableWebSocketMessageBroker
//////public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
////public class WebSocketConfig{
////
//////    @Autowired
//////    private JwtToken jwtToken;
////
////    /**
////     * 	注入ServerEndpointExporter，
////     * 	这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
////     */
////    @Bean
////    public ServerEndpointExporter serverEndpointExporter() {
////        return new ServerEndpointExporter();
////    }
////
//////    @Autowired
//////    private WebSocketHandshakeInterceptor webSocketHandshakeInterceptor;
////
//////    @Override
//////    public void registerStompEndpoints(StompEndpointRegistry registry) {
//////        // 注册WebSocket端点，并添加握手拦截器用于Token校验
//////        registry.addEndpoint("/websocket/**")
//////                .(webSocketHandshakeInterceptor, "/api/busi/socket/push/")
//////                .setAllowedOrigins("*").withSockJS()
//////                .setInterceptors(new WebSocketHandshakeInterceptor(jwtToken));
//////    }
//////    @Override
//////    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//////        registry
//////                // 设置处理器处理/custom/**
//////                .addHandler()
//////                // 允许跨越
//////                .setAllowedOrigins("*")
//////                // 设置监听器
//////                .addInterceptors(webSocketHandshakeInterceptor);
//////    }
////}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//
//@Configuration
//public class WebSocketConfig {
//
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
//}
