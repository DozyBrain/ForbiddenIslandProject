package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.State;
import model.game.Tile;
import model.player.Pawn;

public class Diver extends Adventurer {
    
    public Diver(Tile currentTile) {
        super(currentTile);
        setRoleName("DIVER");
        setPawn(new Pawn("BLACK"));
    }
    
        
    @Override
    public ArrayList<Tile> getReachableTiles(HashMap<Coords, Tile> tiles) {
            
        // A modifier
//                Coords coords = getCurrentTile().getCoords();
//                Coords south = new Coords(coords.getX(), coords.getY()+1);
//                Coords north = new Coords(coords.getX(), coords.getY()-1);
//                Coords east = new Coords(coords.getX()+1, coords.getY());
//                Coords west = new Coords(coords.getX()-1, coords.getY());
//
                ArrayList<Tile> enableTiles = new ArrayList<>();
//
//                if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.gone) {
//                    enableTiles.add(tiles.get(south));
//                } 
//                else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.gone) {
//                    enableTiles.add(tiles.get(north));
//                } 
//                else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.gone) {
//                    enableTiles.add(tiles.get(east));
//                } 
//                else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.gone) {
//                    enableTiles.add(tiles.get(west));
//                }

                return enableTiles;
    }
    
}