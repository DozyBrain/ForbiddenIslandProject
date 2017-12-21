package model.adventurers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.Grid;
import model.game.State;
import static model.game.State.GONE;

import model.game.Tile;
import model.player.Pawn;

public class Explorer extends Adventurer {
    
    public Explorer(Tile currentTile) {
        super(currentTile);
        setRoleName("EXPLORER");
        setColor(Color.GREEN);
    }    
    
    @Override 
    public ArrayList<Tile> enableMove(Grid grille) {
        ArrayList<Tile> possibleTiles = super.enableMove(grille);
        ArrayList<Tile> diagTiles = new ArrayList<>();
        diagTiles = grille.getDiagTiles(getCurrentTile());
        
        for (Tile t : diagTiles) {
            if (t.getCurrentState()!= GONE)
                possibleTiles.add(t);
        }
        return possibleTiles;
    }
    
    @Override 
    public ArrayList<Tile> enableDry(Grid grille) {
        ArrayList<Tile> possibleTiles = super.enableMove(grille);
        ArrayList<Tile> diagTiles = new ArrayList<>();
        diagTiles = grille.getDiagTiles(getCurrentTile());
        
        for (Tile t : diagTiles) {
            if (t.getCurrentState() == State.FLOODED)
                possibleTiles.add(t);
        }
        return possibleTiles;
    }
    
    
}