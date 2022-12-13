package com.cs272.spellingbee.Objects.leftSideModular;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.geometry.HPos;



public class ButtonPadAndSelectedLetters {
    // INSTANT VARIABLE
    private final int AMOUNT_OF_UPPER_LETTER = 3;
    private final int AMOUNT_OF_LOWER_LETTER = 3;
    private final int AMOUNT_OF_MIDDLE_LETTER = 1;
    private final double GAP = 20.0;
    private final int AMOUNT_OF_BUTTON = 7;
    private final double BUTTON_MIN_HEIGHT = 50.0;
    private final double BUTTON_MIN_WIDTH = 60.0;

    private GridPane gridPane;
    private HBox hBox;
    private PolygonButton[] polygonButton;
    private DynamicStack<Label> labelStack;
    private Button delete;
    private Button enter;

    // CONSTRUCTURE
    public ButtonPadAndSelectedLetters(String lettersForSelection)
    {
        gridPane = new GridPane();
        polygonButton = new PolygonButton[AMOUNT_OF_BUTTON];
        hBox = new HBox();
        labelStack = new DynamicStack<Label>();
        delete = new Button("Delete");
        enter = new Button("Enter");

        delete.setMinSize(BUTTON_MIN_WIDTH, BUTTON_MIN_HEIGHT);
        enter.setMinSize(BUTTON_MIN_WIDTH, BUTTON_MIN_HEIGHT);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(GAP);
        gridPane.setVgap(GAP);
        gridPane.add(hBox, 0,0);
        gridPane.add(delete, 0, 4);
        gridPane.add(enter, 2, 4);
        gridPane.setValignment(hBox, VPos.CENTER);
        gridPane.setHalignment(hBox, HPos.CENTER);
        gridPane.setHalignment(enter, HPos.CENTER);
        gridPane.setHalignment(delete, HPos.CENTER);

        setupLetterButtonAndSlecetedLabel(lettersForSelection);
        hadlerDeleted(delete);
    }

    // INSTANT METHOD
    public GridPane getGridPane()
    {
        return gridPane;
    }

    public String deletedLetter()
    {
        int length = hBox.getChildren().size();
        hBox.getChildren().remove(length - 1, length);
        return labelStack.pop().getText();
    }

    public String getWord()
    {
        String word = "";
        while(!labelStack.empty())
        {
            word += deletedLetter();
        }
        return word;
    }

    // Helper Function to get the enter button so I can modify it outside this class
    public Button getEnter()
    {
        return enter;
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
                gridPane.add(polygonButton[index], currentAmountUpper, 1);
                currentAmountUpper++;
            }
            else if(currentAmountMiddle == AMOUNT_OF_MIDDLE_LETTER)
            {
                polygonButton[index].setStyle("-fx-background-color: #f7da21");
                gridPane.add(polygonButton[index], currentAmountMiddle, 2);
                currentAmountMiddle++;
            }
            else
            {
                polygonButton[index].setStyle("-fx-background-color: #e6e6e6");
                gridPane.add(polygonButton[index], currentAmountLower, 3);
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
        polygonButton.setOnAction(even->{
            Label selectedLetterLabel = new Label(polygonButton.getText());
            selectedLetterLabel.setFont(new Font("Courier New", 20));
            labelStack.push(selectedLetterLabel);
            hBox.getChildren().add(labelStack.peek());
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
        });
    }
}
