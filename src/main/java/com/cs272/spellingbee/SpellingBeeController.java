package com.cs272.spellingbee;
import com.cs272.spellingbee.Objects.CorrectWordsList.CorrectWordList;
import com.cs272.spellingbee.Objects.GameVariables.GameVariables;

import com.cs272.spellingbee.Objects.CorrectWordsList.SinglyLinkedList;
import com.cs272.spellingbee.Objects.GameVariables.StringChainHashSet;
import com.cs272.spellingbee.Objects.leftSideModular.ButtonPadAndSelectedLetters;
import com.cs272.spellingbee.Objects.leftSideModular.PolygonButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
public class SpellingBeeController {

    // TODO: Delete test variables
    // Test Variables
    private final String letters = "ofwhci";
    private final String centerLetter = "s";
    private final StringChainHashSet wordList = new StringChainHashSet();

    // Creates a new CorrectWordListClass
    // - SinglyLinkedList<String> correctWordList
    // + addWord(String word) - adds a word to the list
    // + getCorrectWordListView(ListView<String> correctWordsListView) - gets the list view of the correct words
    // + getSize() - gets the size of the list
    // + removeAll() - removes all the words from the list
    private final CorrectWordList correctWordList = new CorrectWordList();

    // This is commented out so we do not make too many calls to API
    // TODO: uncomment
    // Creates a new GameVariables object
    // - String letters
    // - String centerWord
    // - StringChainHashSet wordList
    // + getLetters() : String
    // + getCenterWord() : String
    // + checkWord(String word) : boolean
//    private final GameVariables gameVariables = new GameVariables();

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

    public SpellingBeeController() throws ParseException, IOException {
    }

    // Initialize function
    // Initial state of app before it starts
    @FXML
    public void initialize() throws ParseException, IOException {
        // Sets the display to show current date
        currentDateDisplay.setText(getCurrentDate());

        // TODO: Delete test variables
        wordList.add("chichis");
        wordList.add("chicos");
        wordList.add("chics");


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
        correctWordList.addWord("Word 1");
        correctWordList.addWord("Word 2");
        correctWordList.addWord("Word 3");
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
