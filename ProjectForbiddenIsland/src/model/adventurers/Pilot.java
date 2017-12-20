package model.adventurers;

import model.game.Tile;
import model.player.Pawn;

public class Pilot extends Adventurer {
    
    public Pilot(Tile currentTile) {
        super(currentTile);
        setRoleName("PILOT");
        setPawn(new Pawn("BLUE"));
    }

}