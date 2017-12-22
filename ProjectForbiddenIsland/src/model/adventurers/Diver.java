package model.adventurers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.Grid;
import model.game.State;
import static model.game.State.*;
import model.game.Tile;
import model.player.Pawn;

public class Diver extends Adventurer {
    
    public Diver(Tile currentTile) {
        super(currentTile);
        setRoleName("DIVER");
        setColor(Color.BLACK);
    }
    
    @Override
     public ArrayList<Tile> enableMove(Grid grille) {
        
        Tile tileL;
        ArrayList<Tile> tuilesPossibles = super.enableMove(grille);
        
        ArrayList<Tile> tuilesTrav = new ArrayList();
        tuilesTrav.add(getCurrentTile());
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            tileL = tuilesTrav.get(i);
            

            for (Tile tile : grille.getAdjTiles(tileL)) {
                
                if (tile.getCurrentState()!= State.GONE && !tuilesPossibles.contains(tile))
                    tuilesPossibles.add(tile);
                
                if (tile.getCurrentState() != State.DRIED && !tuilesTrav.contains(tile))
                    tuilesTrav.add(tile);
            }
        }
        
        tuilesPossibles.remove(getCurrentTile());
        return tuilesPossibles;
    }
}

    
