package com.baseframework.example.service.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
	
	@Autowired
	private WebSocketHandler webSocketHandler;
	
	@Autowired
	private WebSocketHandshakeInterceptor webSocketHandshakeInterceptor;
	
	@Autowired
	private H2WSSessionInterceptor h2WSSessionInterceptor;
	
	public void registerWebSocketHandlers(WebSocketHandlerRegistry arg0) {
		arg0.addHandler(webSocketHandler, "/socket2/**").addInterceptors(webSocketHandshakeInterceptor,h2WSSessionInterceptor).withSockJS();
	}
}
