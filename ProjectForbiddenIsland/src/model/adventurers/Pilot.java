package model.adventurers;

import java.awt.Color;
import model.game.Tile;
import model.player.Pawn;

public class Pilot extends Adventurer {
    
    public Pilot(Tile currentTile) {
        super(currentTile);
        setRoleName("PILOT");
        setColor(Color.BLUE);
    }

}