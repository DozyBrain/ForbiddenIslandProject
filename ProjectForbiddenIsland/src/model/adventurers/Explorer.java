package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.State;
import model.game.Tile;

public class Explorer extends Adventurer {

        // diagonal positions
        Coords topLeft = new Coords(coords.getX()-1, coords.getY()-1);
        Coords topRight = new Coords(coords.getX()+1, coords.getY()-1);
        Coords botLeft = new Coords(coords.getX()-1, coords.getY()+1);
        Coords botRight = new Coords(coords.getX()+1, coords.getY()+1);
    
    public Explorer(Tile currentTile) {
        super(currentTile);
    }
    
    @Override
    public void getDryableTiles(HashMap<Coords, Tile> tiles) {
            
            ArrayList<Tile> drieableTiles = new ArrayList<>();
            
            if (tiles.containsKey(coords) || tiles.get(coords).getCurrentState() != State.flooded) {
                drieableTiles.add(tiles.get(coords));
            } 
            else if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.flooded) {
                drieableTiles.add(tiles.get(south));
            } 
            else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.flooded) {
                drieableTiles.add(tiles.get(north));
            } 
            else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.flooded) {
                drieableTiles.add(tiles.get(east));
            } 
            else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.flooded) {
                drieableTiles.add(tiles.get(west));
            }
            
	} 
    
    
    
}