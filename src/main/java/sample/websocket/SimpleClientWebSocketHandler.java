package sample.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import sample.component.ReceivedTextAreaComponent;

public class SimpleClientWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ReceivedTextAreaComponent receivedTextAreaComponent;

    private WebSocketSession session;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.session = session;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        receivedTextAreaComponent.appendText(message.getPayload() + System.lineSeparator());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {

    }

    public WebSocketSession getSession() {
        return session;
    }

}