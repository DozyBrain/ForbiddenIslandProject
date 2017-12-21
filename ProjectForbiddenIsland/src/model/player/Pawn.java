package model.player;

import java.awt.Color;

public class Pawn {

    private Color color;
    private String colorName;
        
    public Pawn(String colorName){
        setColorName(colorName);
        setColor(Color.PINK);
    }

    public void setColor(Color color) {
        this.color = color;
    }   
        
    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the colorName
     */
    public String getColorName() {
        return colorName;
    }

    /**
     * @param colorName the colorName to set
     */
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
        
    
    
    
        
        
}