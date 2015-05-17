package sample.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

@Component
public class MainLayout extends GridPane {

    private SentTextAreaComponent sentTextAreaComponent;

    private ReceivedTextAreaComponent receivedTextAreaComponent;

    private InputTextFieldComponent inputTextFieldComponent;

    @Autowired
    public MainLayout(SentTextAreaComponent sentTextAreaComponent,
                      ReceivedTextAreaComponent receivedTextAreaComponent,
                      InputTextFieldComponent inputTextFieldComponent) {
        this.sentTextAreaComponent = sentTextAreaComponent;
        this.receivedTextAreaComponent = receivedTextAreaComponent;
        this.inputTextFieldComponent = inputTextFieldComponent;

        add(new Label("Sent"), 0, 0);
        add(new Label("Received"), 1, 0);
        add(this.sentTextAreaComponent, 0, 1);
        add(this.receivedTextAreaComponent, 1, 1);
        add(new Label("Send Form"), 0, 2);
        add(this.inputTextFieldComponent, 0, 3);
    }
}
