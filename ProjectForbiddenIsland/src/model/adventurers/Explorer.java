package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.State;
import model.game.Tile;

public class Explorer extends Adventurer {

        // diagonal positions
        private Coords topLeft = new Coords(coords.getX()-1, coords.getY()-1);
        private Coords topRight = new Coords(coords.getX()+1, coords.getY()-1);
        private Coords botLeft = new Coords(coords.getX()-1, coords.getY()+1);
        private Coords botRight = new Coords(coords.getX()+1, coords.getY()+1);
    
    public Explorer(Tile currentTile) {
        super(currentTile);
        setRoleName("EXPLORER");
    }
    
    @Override
    public ArrayList<Tile> getReachableTiles(HashMap<Coords, Tile> tiles) {

        ArrayList<Tile> enableTiles = new ArrayList<>();

        if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(south));
        } 
        else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(north));
        } 
        else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(east));
        } 
        else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(west));
        }
        else if (tiles.containsKey(topLeft) || tiles.get(topLeft).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(topLeft));
        } 
        else if (tiles.containsKey(topRight) || tiles.get(topRight).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(topRight));
        } 
        else if (tiles.containsKey(botLeft) || tiles.get(botLeft).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(botLeft));
        } 
        else if (tiles.containsKey(botRight) || tiles.get(botRight).getCurrentState() != State.GONE) {
            enableTiles.add(tiles.get(botRight));
        }

        return enableTiles;
    }
    
    @Override
    public void getDryableTiles(HashMap<Coords, Tile> tiles) { 
        ArrayList<Tile> drieableTiles = new ArrayList<>();

        if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(south));
        } 
        else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(north));
        } 
        else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(east));
        } 
        else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(west));
        }
        else if (tiles.containsKey(topLeft) || tiles.get(topLeft).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(topLeft));
        } 
        else if (tiles.containsKey(topRight) || tiles.get(topRight).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(topRight));
        } 
        else if (tiles.containsKey(botLeft) || tiles.get(botLeft).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(botLeft));
        } 
        else if (tiles.containsKey(botRight) || tiles.get(botRight).getCurrentState() != State.GONE) {
            drieableTiles.add(tiles.get(botRight));
        }
    }
    
    
    
}