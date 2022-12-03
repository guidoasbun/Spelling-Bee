package com.cs272.spellingbee;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SpellingBeeController {
    // Instance FXML variables
    @FXML
    private Label currentDateDisplay;

    @FXML
    private ListView<String> correctWordListView;

    // Initialize function -
    // Initial state of app before it starts
    @FXML
    public void initialize(){
        currentDateDisplay.setText(getCurrentDate());
    }

    // Action handler Methods
    @FXML
    public void handleCloseProgramButton() {
       // Add any additional task to do before closing app
        Platform.exit();
    }

    @FXML
    public void handleResetButton() {
        System.out.println("Reset Button Pressed");
    }

    // Private Helper Functions
    private String getCurrentDate() {
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return formattedTime.format(currentDate);
    }


}
