package model.adventurers;

import model.game.Tile;

public class Engineer extends Adventurer {
    
    private boolean hasDry = false;
    private final String roleName = "ENGINEER";

    public Engineer(Tile currentTile) {
        super(currentTile);
    } 

    public void setHasDry(boolean hasDry) {
        this.hasDry = hasDry;
    }

    public boolean getHasDry() {
            return this.hasDry;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
    
}