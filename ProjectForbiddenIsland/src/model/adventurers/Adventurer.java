package model.adventurers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import model.game.*;
 

import model.player.Pawn;
 


public abstract class Adventurer {

    private Tile currentTile;
    private int numberActionEnable;
    private final int numberActionMax = 3;
    private String roleName = "";
    private Pawn pawn = new Pawn("");
    
        protected Adventurer(Tile currentTile) {
            this.setCurrentTile(currentTile);
            this.setNumberActionEnable(numberActionMax);    
        }

	public void decreaseActions() {
            setNumberActionEnable(getNumberActionEnable() - 1);
	}

	public Coords getCoords() {
		return getCurrentTile().getCoords();
	}

    /**
     * @return the currentTile
     */
    public Tile getCurrentTile() {
        return currentTile;
    }

    /**
     * @return the numberActionEnable
     */
    public int getNumberActionEnable() {
        return numberActionEnable;
    }

    /**
     * @param numberActionEnable the numberActionEnable to set
     */
    public void setNumberActionEnable(int numberActionEnable) {
        this.numberActionEnable = numberActionEnable;
    }

    /**
     * @return the numberActionMax
     */
    public int getNumberActionMax() {
        return numberActionMax;
    }

    /**
     * @param currentTile the currentTile to set
     */
    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }
    
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String name) {
        this.roleName = name;
    }
    
    public Pawn getPawn(){
        return this.pawn;
    }
    
    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }
    
    public void setColor(Color color) {
        this.getPawn().setColor(color);
    }

    public ArrayList<Tile> enableMove(Grid grid) {
        
        ArrayList<Tile> possibleTiles = new ArrayList<>();
        ArrayList<Tile> adjTiles = new ArrayList<>();
        adjTiles = grid.getAdjTiles(this.getCurrentTile());  
        
        for (Tile t : adjTiles) {
            if (t.getCurrentState() != State.GONE && !possibleTiles.contains(t)) {
                possibleTiles.add(t);
            }
        }
        return possibleTiles;
    }
    
    public ArrayList<Tile> enableDry(Grid grid) {
        
        ArrayList<Tile> possibleTiles = new ArrayList<>();
        ArrayList<Tile> adjTiles = new ArrayList<>();
        adjTiles = grid.getAdjTiles(this.getCurrentTile());   
        for (Tile t : adjTiles) {
            if (t.getCurrentState() == State.FLOODED && !possibleTiles.contains(t)) {
                possibleTiles.add(t);
            }
        }
        return possibleTiles;
    }
    
    
    
}