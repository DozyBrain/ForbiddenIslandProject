package model.adventurers;

import model.game.Tile;
import model.player.Pawn;

public class Messenger extends Adventurer {

    public Messenger(Tile currentTile) {
        super(currentTile);
        setRoleName("MESSENGER");
        setPawn(new Pawn("WHITE"));
    }

}