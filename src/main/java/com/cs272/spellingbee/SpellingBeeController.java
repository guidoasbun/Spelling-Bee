package com.cs272.spellingbee;

import com.cs272.spellingbee.Objects.CorrectWordsList.SinglyLinkedList;
import com.cs272.spellingbee.Objects.GameVariables.GameVariables;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SpellingBeeController {

    // Instance Variables
    // Creates a new SinglyLinkedList object
    // + addLast() method adds a new node to the end of the list
    // + getCorrectWordsList() : ListView<String> method returns the list
    // + getSize() : int
    // + removeAll() method removes all nodes from the list
    private final SinglyLinkedList<String> correctWordList = new SinglyLinkedList<>();

    // Creates a new GameVariables object
    // - String letters
    // - String centerWord
    // - StringChainHashSet wordList
    // + getLetters() : String
    // + getCenterWord() : String
    // + checkWord(String word) : boolean
    GameVariables gameVariables = new GameVariables();

    // Instance FXML variables
    @FXML
    private Label currentDateDisplay;
    @FXML
    private ListView<String> correctWordsListView;
    @FXML
    private Label correctWordCount;

    public SpellingBeeController() throws ParseException, IOException {
    }

    // Initialize function
    // Initial state of app before it starts
    @FXML
    public void initialize() throws ParseException, IOException {
        // Sets the display to show current date
        currentDateDisplay.setText(getCurrentDate());


        // TODO: REMOVE Test Data
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
        Platform.exit();
    }

    @FXML
    public void handleResetButton() {
        // TODO: Clear out the input display



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
