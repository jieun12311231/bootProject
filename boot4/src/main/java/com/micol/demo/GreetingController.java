package com.micol.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

  @MessageMapping("/hello")  //메시지요청이 들어오면 아래가 실행이됨
  @SendTo("/topic/greetings")  // greeting으로 요청 된 사람들에게 메시지를 보냄
  public Greeting greeting(HelloMessage message) throws Exception {
    Thread.sleep(1000); // simulated delay  //지연시간 -> 1초대기
    return new Greeting("🌳떡잎마을 " + HtmlUtils.htmlEscape(message.getName()) + "🌳"); //메시지를 리턴함
 //전송된 데이터 중에서 태그가 있으면 자동으로 제거를 해주 ㅁ
  }

}