package model.adventurers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.Grid;
import model.game.State;

import model.game.Tile;
import model.player.Pawn;

public class Explorer extends Adventurer {

        // diagonal positions
    
    public Explorer(Tile currentTile) {
        super(currentTile);
        setRoleName("EXPLORER");
        setColor(Color.GREEN);
        
//        topLeft = new Coords(coords.getX()-1, coords.getY()-1);
//        topRight = new Coords(coords.getX()+1, coords.getY()-1);
//        botLeft = new Coords(coords.getX()-1, coords.getY()+1);
//        botRight = new Coords(coords.getX()+1, coords.getY()+1);
//    }
    

//    @Override
//    public ArrayList<Tile> getReachableTiles(HashMap<Coords, Tile> tiles) {
//
//        ArrayList<Tile> enableTiles = new ArrayList<>();
//
//        if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(south));
//        } 
//        else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(north));
//        } 
//        else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(east));
//        } 
//        else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(west));
//        }
//        else if (tiles.containsKey(topLeft) || tiles.get(topLeft).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(topLeft));
//        } 
//        else if (tiles.containsKey(topRight) || tiles.get(topRight).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(topRight));
//        } 
//        else if (tiles.containsKey(botLeft) || tiles.get(botLeft).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(botLeft));
//        } 
//        else if (tiles.containsKey(botRight) || tiles.get(botRight).getCurrentState() != State.gone) {
//            enableTiles.add(tiles.get(botRight));
//        }


//        return enableTiles;
//    }
    
//    @Override
//    public void getDryableTiles(HashMap<Coords, Tile> tiles) { 
//        ArrayList<Tile> drieableTiles = new ArrayList<>();
//
//        if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(south));
//        } 
//        else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(north));
//        } 
//        else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(east));
//        } 
//        else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(west));
//        }
//        else if (tiles.containsKey(topLeft) || tiles.get(topLeft).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(topLeft));
//        } 
//        else if (tiles.containsKey(topRight) || tiles.get(topRight).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(topRight));
//        } 
//        else if (tiles.containsKey(botLeft) || tiles.get(botLeft).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(botLeft));
//        } 
//        else if (tiles.containsKey(botRight) || tiles.get(botRight).getCurrentState() != State.gone) {
//            drieableTiles.add(tiles.get(botRight));
//        }
//    }
    
    @Override 
     public ArrayList<Tile> enableMove(Grid grille) {
        ArrayList<Tile> tuilesAdj = super.enableMove(grille);
        ArrayList<Tile> tuilesDiag = new ArrayList<>();
        tuilesDiag = grille.getDiagTile(getCurrentTile());
        
        for (Tile t : tuilesDiag) {
            if (t.getCurrentState()!= gone)
                tuilesAdj.add(t);

        }
        return tuilesAdj;
    }
    
    
}