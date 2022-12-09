package com.cs272.spellingbee.Objects.leftSideModular;

import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;

public class PolygonButton extends Button{
    // INSTANT VARIABLE
    private Polygon polygon;
    
    // CONSTRUCTURE
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
        super.setMinHeight(50);
        super.setMinWidth(50);
    }
    public PolygonButton(char selctionLetter)
    {
        this();
        setLetter(selctionLetter);
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
