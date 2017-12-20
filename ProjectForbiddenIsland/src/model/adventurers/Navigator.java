package model.adventurers;

import model.game.Tile;

public class Navigator extends Adventurer {

    private final String roleName = "NAVIGATOR";

    public Navigator(Tile currentTile) {
        super(currentTile);
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
    
    
}