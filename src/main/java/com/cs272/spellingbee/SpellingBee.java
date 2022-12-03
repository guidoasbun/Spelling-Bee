package com.cs272.spellingbee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpellingBee extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpellingBee.class.getResource("main-window.fxml"));
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        Scene scene = new Scene(fxmlLoader.load(), 1080, 790);
        stage.setTitle("Spelling Bee");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
