package korweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// [2]  'TextWebSocketHandler' 클래스로부터 상속 받기
@Component // 현재 클래스를 빈 등록한다.
public class ChatServerSocket extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("클라이언트가 서버에게 접속 요청 한다.");
    } //  f end
} // f end
