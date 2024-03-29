package com.wisely.ch7_6;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker//开启使用STOMP协议传输基于代理的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS(); 
        registry.addEndpoint("/endpointChat").withSockJS();//1
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	registry.enableSimpleBroker("/topic"); 
        registry.enableSimpleBroker("/queue","/topic"); //2
    }

}
