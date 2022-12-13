package com.cs272.spellingbee;

import com.cs272.spellingbee.Objects.CorrectWordsList.SinglyLinkedList;
import com.cs272.spellingbee.Objects.leftSideModular.ButtonPadAndSelectedLetters;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

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
    @FXML
    private GridPane center;

    // we can use this string to test the word;
    private String userSelectedWord;

    // Initialize function -
    // Initial state of app before it starts
    @FXML
    public void initialize(){
        // Sets the display to show current date
        center.setAlignment(Pos.CENTER);
        currentDateDisplay.setText(getCurrentDate());


        // Initialize the girdpane for buttons
        /* Create a new ButtonPadAndSelectedLetters
         *  - GridPane gridPane;
            - HBox hBox;
            - PolygonButton[] polygonButton;
            - DynamicStack<Label> labelStack;
            - Button delete;
            - Button enter;
            + getGridPane(): GridPane
            + deletedLetter: String
            + getWord: String
            + getEnter: Button
         */
        String letterForSelection = "hikaemr";
        ButtonPadAndSelectedLetters selection = new ButtonPadAndSelectedLetters(letterForSelection);
        center.getChildren().add(selection.getGridPane());
        selection.getEnter().setOnAction(even->{
            userSelectedWord = selection.getWord();
            System.out.println(userSelectedWord);
            //TODO: Check if the word is corrent if it's corrent 
            //      then we can add the corrented word into
            //      the correctWordList
        });

        // TODO: Remove Test Data
        // Mock Data to test likedList<String> to display
        correctWordList.addLast("Word 1");
        correctWordList.addLast("Word 2");
        correctWordList.addLast("Word 3");
        correctWordList.getCorrectWordListView(correctWordsListView);


        // Initializes the correct word count message
        correctWordCount.setText("You have found " + correctWordList.getSize() + " words");


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


        // Clears out the correct word list
        correctWordList.removeAll();
        correctWordsListView.getItems().clear();
        correctWordList.getCorrectWordListView(correctWordsListView);
        // Resets the words count
        correctWordCount.setText("You have found " + correctWordList.getSize() + " words");
    }

    // Private Helper Functions
    private String getCurrentDate() {
        // Returns current date in String format
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return formattedTime.format(currentDate);
    }
}
