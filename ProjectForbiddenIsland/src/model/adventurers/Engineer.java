package model.adventurers;

import model.game.Tile;
import model.player.Pawn;

public class Engineer extends Adventurer {
    
    private boolean hasDry = false;

    public Engineer(Tile currentTile) {
        super(currentTile);
        setRoleName("ENGINEER");
        setPawn(new Pawn("RED"));
    } 

    public void setHasDry(boolean hasDry) {
        this.hasDry = hasDry;
    }

    public boolean getHasDry() {
            return this.hasDry;
    }
    
}