package model.player;

import java.awt.Color;

public class Pawn {

    private Color color;
    private String colorName;
        
    public Pawn(String colorName){
        setColorName(colorName);
        switch (colorName) {
            case ("RED"): 
                setColor(Color.RED);
            case ("GREEN"): 
                setColor(Color.GREEN);
            case ("YELLOW"): 
                setColor(Color.YELLOW);
            case ("BLUE"): 
                setColor(Color.BLUE);
            case ("BLACK"): 
                setColor(Color.BLACK);
            case ("WHITE"): 
                 setColor(Color.WHITE);  
        }         
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