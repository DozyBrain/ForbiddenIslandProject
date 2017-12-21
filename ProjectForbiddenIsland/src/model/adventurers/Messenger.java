package model.adventurers;

import java.awt.Color;
import model.game.Tile;
import model.player.Pawn;

public class Messenger extends Adventurer {

    public Messenger(Tile currentTile) {
        super(currentTile);
        setRoleName("MESSENGER");
        setColor(Color.WHITE);
    }

}