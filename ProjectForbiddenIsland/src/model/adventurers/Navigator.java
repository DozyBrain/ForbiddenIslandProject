package model.adventurers;

import model.game.Tile;
import model.player.Pawn;

public class Navigator extends Adventurer {

    public Navigator(Tile currentTile) {
        super(currentTile);
        setRoleName("NAVIGATOR");
        setPawn(new Pawn("YELLOW"));
    } 
    
}