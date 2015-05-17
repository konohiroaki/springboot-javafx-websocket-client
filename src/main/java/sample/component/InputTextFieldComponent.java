package sample.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import sample.websocket.SimpleClientWebSocketHandler;

@Component
public class InputTextFieldComponent extends TextField {

    @Autowired
    SentTextAreaComponent sentTextAreaComponent;

    @Autowired
    SimpleClientWebSocketHandler handler;

    public InputTextFieldComponent() {
        this.onKeyPressedProperty().setValue(key -> {
            if (key.getCode() == KeyCode.ENTER) {
                try {
                    handler.getSession().sendMessage(new TextMessage(this.getText()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sentTextAreaComponent.appendText(this.getText() + System.lineSeparator());
                this.clear();
            }
        });
    }
}
