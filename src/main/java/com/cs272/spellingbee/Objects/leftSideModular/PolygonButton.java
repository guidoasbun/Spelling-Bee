//Programmer: Kuan Lei
package com.cs272.spellingbee.Objects.leftSideModular;

import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

public class PolygonButton extends Button{
    // INSTANT VARIABLE
    private final double MIN_HEIGHT = 80.0;
    private final double MIN_WIDTH = 90.0;
    private final Font font = new Font("Courier New", 36);
    private Polygon polygon;
    
    // CONSTRUCTOR
    public PolygonButton()
    {
        polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{0.0 ,
            51.96152422706631,30.0,
            0.0, 90.0,0.0,120.0,51.96152422706631, 
            90.0,103.92304845413263,
            30.0,103.92304845413263});
            
        super.setText(" ");
        super.setShape(polygon);
        super.setMinSize(MIN_WIDTH, MIN_HEIGHT);
        super.setFont(font);
    }

    public PolygonButton(char selectionLetter)
    {
        this();
        setLetter(Character.toUpperCase(selectionLetter));
    }

    // INSTANT METHOD
    public String getLetter()
    {
        return getText();
    }

    public void setLetter(char letterForSelection)
    {
        this.setText(Character.toString(letterForSelection));
    }
}
