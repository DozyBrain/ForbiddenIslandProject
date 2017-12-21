package model.adventurers;

import java.awt.Color;
import model.game.Tile;
import model.player.Pawn;

public class Navigator extends Adventurer {

    public Navigator(Tile currentTile) {
        super(currentTile);
        setRoleName("NAVIGATOR");
        setColor(Color.YELLOW);
    } 
    
}