package com.cs272.spellingbee;

import com.cs272.spellingbee.Objects.PolygonButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SpellingBeeController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button randomButton;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize(){
        Button sometthin = new PolygonButton();
    }

    @FXML
    public void onPress(){
         System.out.println("I was pressed!");
    }



}
