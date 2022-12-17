// CS272: Extra Credit Spelling Bee
// Programmers: Guido Asbun
//              Kuan Lei

package com.cs272.spellingbee;

import com.cs272.spellingbee.Objects.CorrectWordsList.CorrectWordList;
import com.cs272.spellingbee.Objects.GameVariables.GameVariables;
import com.cs272.spellingbee.Objects.leftSideModular.ButtonPadAndSelectedLetters;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.json.simple.parser.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class SpellingBeeController {

    // Instance Variables
    private final GameVariables gameVariables = new GameVariables();
    private final ButtonPadAndSelectedLetters selection = new ButtonPadAndSelectedLetters(gameVariables.getLetters(), gameVariables.getCenterWord());
    private final CorrectWordList correctWordList = new CorrectWordList();
    private String userSelectedWord;

    // Instance FXML variables
    @FXML
    private Label currentDateDisplay;
    @FXML
    private ListView<String> correctWordsListView;
    @FXML
    private Label correctWordCount;
    @FXML
    private GridPane center;

    public SpellingBeeController() throws ParseException {
    }

    // Initialize function
    @FXML
    public void initialize() {
        // Sets the display to show current date
        center.setAlignment(Pos.CENTER);
        currentDateDisplay.setText(getCurrentDate());

        // Initializes word buttons
        center.getChildren().add(selection.getGridPane());

        selection.getEnter().setOnAction(even -> {
            userSelectedWord = selection.getWord();
            if (selection.checkWordLengthAndCenterLetter(userSelectedWord)) {
                if (gameVariables.checkWord(userSelectedWord)) {
                    addWordToCorrectWordList(userSelectedWord);
                } else {
                    selection.assignErrorMessage("Word is not in the correct word list.");
                }
            }
        });

        // Initializes the correct word count message
        updateCorrectWordCount();
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
        if (correctWordList.getSize() > 0) {
            resetCorrectWordList();
        }

        // Resets the words count
        updateCorrectWordCount();
    }

    // Private Helper Functions
    private String getCurrentDate() {
        // Returns current date in String format
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return formattedTime.format(currentDate);
    }

    private void addWordToCorrectWordList(String word) {
        if (!correctWordList.checkIfWordIsAlreadyInList(word)) {
            correctWordList.addWord(word);
            correctWordsListView.getItems().clear();
            correctWordList.getCorrectWordListView(correctWordsListView);
            updateCorrectWordCount();
        } else {
            selection.assignErrorMessage("You already got this one.");
        }
    }

    private void resetCorrectWordList() {
        correctWordList.removeAll();
        correctWordsListView.getItems().clear();
        correctWordList.getCorrectWordListView(correctWordsListView);
    }

    public void updateCorrectWordCount() {
        correctWordCount.setText("You have found " + correctWordList.getSize()
                + (correctWordList.getSize() == 1 ? " word out of " : " words out of ")
                + gameVariables.getTotalCorrectWords());
    }
}
