package sample.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
public class WebSocketConfiguration {

    private static final String WS_URI = "ws://localhost:8080/echo";

    @Bean
    public WebSocketConnectionManager connectionManager() {
        WebSocketConnectionManager manager = new WebSocketConnectionManager(client(), handler(), WS_URI);
        manager.setAutoStartup(true);
        return manager;
    }

    @Bean
    public StandardWebSocketClient client() {
        return new StandardWebSocketClient();
    }

    @Bean
    public SimpleClientWebSocketHandler handler() {
        return new SimpleClientWebSocketHandler();
    }

}
