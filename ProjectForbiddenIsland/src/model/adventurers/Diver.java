package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.Grid;
import model.game.State;
import static model.game.State.*;
import model.game.Tile;

public class Diver extends Adventurer {

    public Diver(Tile currentTile) {
        super(currentTile);
        
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
                
                if (tuile.getCurrentState()!= gone && !tuilesPossibles.contains(tuile))
                    tuilesPossibles.add(tuile);
                    tuile.show();
                
                if (tuile.getCurrentState() != dried && !tuilesTrav.contains(tuile))
                    tuilesTrav.add(tuile);
            }
        }
        
        tuilesPossibles.remove(getCurrentTile());
        return tuilesPossibles;
    }
}
    
