package model.adventurers;

import model.game.Tile;

public class Pilot extends Adventurer {

    private final String roleName = "PILOT";
    
    public Pilot(Tile currentTile) {
        super(currentTile);
    }
    
    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
}