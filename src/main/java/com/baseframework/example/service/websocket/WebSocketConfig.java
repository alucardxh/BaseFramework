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
	
	/**
	 * webService处理器
	 */
	@Autowired
	private WebSocketHandler webSocketHandler;
	
	/**
	 * webService拦截器
	 */
	@Autowired
	private WebSocketHandshakeInterceptor webSocketHandshakeInterceptor;
	
	/**
	 * HttpSession转webServiceSession拦截器
	 */
	@Autowired
	private H2WSSessionInterceptor h2WSSessionInterceptor;
	
	public void registerWebSocketHandlers(WebSocketHandlerRegistry arg0) {
		arg0.addHandler(webSocketHandler, "/socket2/**").addInterceptors(webSocketHandshakeInterceptor,h2WSSessionInterceptor).withSockJS();
	}
}
