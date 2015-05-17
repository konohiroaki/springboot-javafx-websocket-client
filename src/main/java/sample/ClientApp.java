package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.component.MainLayout;

@Lazy
@SpringBootApplication
public class ClientApp extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private MainLayout mainLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(mainLayout));
        stage.show();
    }

    @Override
    public void init() throws Exception {
        SpringApplication app = new SpringApplication(ClientApp.class);
        app.setWebEnvironment(false);
        applicationContext = app.run();
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationContext.close();
    }
}
