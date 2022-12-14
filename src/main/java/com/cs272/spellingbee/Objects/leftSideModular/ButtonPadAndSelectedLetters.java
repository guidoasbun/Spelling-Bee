package com.cs272.spellingbee.Objects.leftSideModular;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.fxml.FXML;
import javafx.geometry.HPos;

public class ButtonPadAndSelectedLetters {
    // INSTANT VARIABLE
    private final int AMOUNT_OF_UPPER_LETTER = 3;
    private final int AMOUNT_OF_MIDDLE_LETTER = 1;
    private final double GAP = 20.0;
    private final int AMOUNT_OF_BUTTON = 7;
    private final double BUTTON_MIN_HEIGHT = 50.0;
    private final double BUTTON_MIN_WIDTH = 60.0;

    private GridPane gridPane;
    private HBox hBoxForLetters;
    private PolygonButton[] polygonButton;
    private Label labelForWarning;
    private DynamicStack<Label> labelStack;
    private Button delete;
    private Button enter;
    private String centerLetter;

    @FXML
    private Label warning;

    // CONSTRUCTURE
    public ButtonPadAndSelectedLetters(String lettersForSelection, String centerLetter)
    {
        String allLetters = lettersForSelection.substring(0,3);
        allLetters += centerLetter + lettersForSelection.substring(3);
        gridPane = new GridPane();
        polygonButton = new PolygonButton[AMOUNT_OF_BUTTON];
        labelForWarning = new Label("");
        hBoxForLetters = new HBox();
        labelStack = new DynamicStack<Label>();
        delete = new Button("Delete");
        enter = new Button("Enter");
        this.centerLetter = centerLetter;

        delete.setMinSize(BUTTON_MIN_WIDTH, BUTTON_MIN_HEIGHT);
        enter.setMinSize(BUTTON_MIN_WIDTH, BUTTON_MIN_HEIGHT);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(GAP);
        gridPane.setVgap(GAP);
        gridPane.add(labelForWarning, 0,0, 3,1);
        gridPane.add(hBoxForLetters, 1,1, 3, 2);
        gridPane.add(delete, 0, 5);
        gridPane.add(enter, 2,5);

        gridPane.setHalignment(labelForWarning, HPos.CENTER);
        gridPane.setHalignment(enter, HPos.CENTER);
        gridPane.setHalignment(delete, HPos.CENTER);

        setupLetterButtonAndSlecetedLabel(allLetters);
        hadlerDeleted(delete);
    }

    // INSTANT METHOD
    public GridPane getGridPane()
    {
        return gridPane;
    }

    public String getWord()
    {
        String reversedWord = "";
        String inOrderWord = "";

        while(!labelStack.empty())
        {
            reversedWord += deletedLetter();
        }
        for(int index = reversedWord.length() - 1; index >= 0; index--)
        {
            inOrderWord += reversedWord.charAt(index);
        }
        return inOrderWord.toLowerCase();
    }

    // Helper Function to get the enter button so I can modify it outside this class
    public Button getEnter()
    {
        return enter;
    }

    public boolean checkWordLengthAndCenterLetter(String selectedWord)
    {
        if(selectedWord.length() < 4)
        {
            labelForWarning.setText("Word too short");
            return false;
        }
        else if(!selectedWord.contains(centerLetter))
        {
            labelForWarning.setText("Word must have center letter");
            return false;
        }
        return true;
    }

    // PRIVATE HELPER FUNCTION
    /* 
     * setupLetterButtonAndSlecetedLabel
     * helper function to set up the button with the letter and their location
    */
    private void setupLetterButtonAndSlecetedLabel(String lettersForSelection)
    {
        int currentAmountUpper = 0;
        int currentAmountMiddle = 1;
        int currentAmountLower = 0;
        for(int index = 0; index < lettersForSelection.length(); index++)
        {
            polygonButton[index] = new PolygonButton(lettersForSelection.charAt(index));
            handlerLetterButton(polygonButton[index]);

            if(currentAmountUpper < AMOUNT_OF_UPPER_LETTER)
            {
                polygonButton[index].setStyle("-fx-background-color: #e6e6e6");
                gridPane.add(polygonButton[index], currentAmountUpper, 2);
                currentAmountUpper++;
            }
            else if(currentAmountMiddle == AMOUNT_OF_MIDDLE_LETTER)
            {
                polygonButton[index].setStyle("-fx-background-color: #f7da21");
                gridPane.add(polygonButton[index], currentAmountMiddle, 3);
                currentAmountMiddle++;
            }
            else
            {
                polygonButton[index].setStyle("-fx-background-color: #e6e6e6");
                gridPane.add(polygonButton[index], currentAmountLower, 4);
                currentAmountLower++;
            }
        }
    }

    /*
     * private helper function for the handler action for all the
     * letter button
     */
    private void handlerLetterButton(PolygonButton polygonButton)
    {
        // TODO: limite to 10
        polygonButton.setOnAction(even->{
            if(labelForWarning.getText().length() > 0)
                labelForWarning.setText("");  
            int length = hBoxForLetters.getChildren().size();
            if(length < 9)
            {
                Label selectedLetterLabel = new Label(polygonButton.getText());
                selectedLetterLabel.setFont(new Font("Courier New", 15));
                labelStack.push(selectedLetterLabel);
                hBoxForLetters.getChildren().add(labelStack.peek());
            }
            else
            {
                labelForWarning.setText("Reaching to the maximum length of a word");
            }

        });
    }



    /*
     * private helper fucntion for handler the delete
     */
    private void hadlerDeleted(Button delete)
    {
        delete.setOnAction(even->{
            if(!labelStack.empty())
                deletedLetter();
                labelForWarning.setText("");
        });
    }

    private String deletedLetter()
    {
        int length = hBoxForLetters.getChildren().size();
        hBoxForLetters.getChildren().remove(length-1);
        return labelStack.pop().getText();
    }
}
