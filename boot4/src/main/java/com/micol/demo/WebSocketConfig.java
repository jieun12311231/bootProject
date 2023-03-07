package com.micol.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration  //설정파일에는 넣어줘야함
@EnableWebSocketMessageBroker  //중간에서 메시지를 전달하는 브로커
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");  //구독 신청(메시지를 받겠다는 신청)
    config.setApplicationDestinationPrefixes("/app");  //메시지를 보낸다는 명령어
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chatServer").withSockJS();
  }

}
