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
        
        Tile tuileL;
        ArrayList<Tile> tuilesPossibles = super.enableMove(grille);
        
        ArrayList<Tile> tuilesTrav = new ArrayList();
        tuilesTrav.add(getCurrentTile());
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            tuileL = tuilesTrav.get(i);
            

            for (Tile tuile : grille.getAdjTile(tuileL)) {
                
                if (tuile.getCurrentState()!= State.GONE && !tuilesPossibles.contains(tuile))
                    tuilesPossibles.add(tuile);
                    tuile.show();
                
                if (tuile.getCurrentState() != State.DRIED && !tuilesTrav.contains(tuile))
                    tuilesTrav.add(tuile);
            }
        }
        
        tuilesPossibles.remove(getCurrentTile());
        return tuilesPossibles;
    }
}

    
