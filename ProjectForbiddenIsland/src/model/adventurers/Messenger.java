package model.adventurers;

import model.game.Tile;

public class Messenger extends Adventurer {

    private final String roleName = "MESSENGER";

    public Messenger(Tile currentTile) {
        super(currentTile);
    }
    
    
    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
}