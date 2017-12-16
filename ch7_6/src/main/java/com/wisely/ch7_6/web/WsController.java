package com.wisely.ch7_6.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.wisely.ch7_6.domain.WiselyMessage;
import com.wisely.ch7_6.domain.WiselyResponse;

@Controller
public class WsController {

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")//当服务器有消息时，会对订阅了/topic/getResponse路径的浏览器发送消息
	public WiselyResponse say(WiselyMessage message) throws Exception {
		Thread.sleep(3000);
		return new WiselyResponse("Welcome, " + message.getName() + "!");
	}

	@Autowired
	private SimpMessagingTemplate messagingTemplate;//1

	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg) { //2
		if (principal.getName().equals("wyf")) {//3
			messagingTemplate.convertAndSendToUser("wisely",
					"/queue/notifications", principal.getName() + "-send:"
							+ msg);
		} else {
			messagingTemplate.convertAndSendToUser("wyf",
					"/queue/notifications", principal.getName() + "-send:"
							+ msg);
		}
	}
}