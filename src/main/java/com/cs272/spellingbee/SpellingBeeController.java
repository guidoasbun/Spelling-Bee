package com.cs272.spellingbee;

import com.cs272.spellingbee.Objects.CorrectWordsList.SinglyLinkedList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class SpellingBeeController {

    // Instance Variables
    private final SinglyLinkedList<String> correctWordList = new SinglyLinkedList<>();

    // Instance FXML variables
    @FXML
    private Label currentDateDisplay;

    @FXML
    private ListView<String> correctWordsListView;

    @FXML
    private Label correctWordCount;

    // Initialize function -
    // Initial state of app before it starts
    @FXML
    public void initialize(){
        // Sets the display to show current date
        currentDateDisplay.setText(getCurrentDate());



        // TODO: Remove
        // Mock Data to test likedList<String> to display
        correctWordList.addLast("Word1");
        correctWordList.addLast("Word2");
        correctWordList.addLast("Word3");
        correctWordList.getCorrectWordListView(correctWordsListView);
    }

    // Action handler Methods
    @FXML
    public void handleCloseProgramButton() {
       // Add any additional task to do before closing app
        Platform.exit();
    }

    @FXML
    public void handleResetButton() {
        // TODO:
        // Clear out the input display
        System.out.println("Reset Button Pressed");

        // Clears out the correct word list
        correctWordList.removeAll();
        correctWordsListView.getItems().clear();
        correctWordList.getCorrectWordListView(correctWordsListView);
    }

    // Private Helper Functions
    private String getCurrentDate() {
        // Returns current date in String format
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return formattedTime.format(currentDate);
    }
}
