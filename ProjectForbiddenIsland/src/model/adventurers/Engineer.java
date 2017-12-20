package model.adventurers;

import model.game.Tile;

public class Engineer extends Adventurer {
    
    private boolean hasDry = false;

    public Engineer(Tile currentTile) {
        super(currentTile);
        setRoleName("ENGINEER");
    } 

    public void setHasDry(boolean hasDry) {
        this.hasDry = hasDry;
    }

    public boolean getHasDry() {
            return this.hasDry;
    }
    
}