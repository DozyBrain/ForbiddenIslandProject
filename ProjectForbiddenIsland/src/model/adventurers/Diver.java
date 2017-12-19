package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.State;
import model.game.Tile;

public class Diver extends Adventurer {

    public Diver(Tile currentTile) {
        super(currentTile);
        
    }
    
    public ArrayList<Tile> getSideTiles(HashMap<Coords, Tile> tiles, Tile tileEnter) {

            ArrayList<Tile> enableTiles = new ArrayList<>();
            Coords south = new Coords(tileEnter.getCoords().getX(), tileEnter.getCoords().getY()+1);
            Coords north = new Coords(tileEnter.getCoords().getX(), tileEnter.getCoords().getY()-1);
            Coords east = new Coords(tileEnter.getCoords().getX()+1, tileEnter.getCoords().getY());
            Coords west = new Coords(tileEnter.getCoords().getX()-1, tileEnter.getCoords().getY());
            
            
            if (tiles.containsKey(south)) {
                enableTiles.add(tiles.get(south));
            } 
            else if (tiles.containsKey(north)) {
                enableTiles.add(tiles.get(north));
            } 
            else if (tiles.containsKey(east) ) {
                enableTiles.add(tiles.get(east));
            } 
            else if (tiles.containsKey(west))  {
                enableTiles.add(tiles.get(west));
            }

            return enableTiles;
	}
    
    
    @Override
    public ArrayList<Tile> getReachableTiles(HashMap<Coords, Tile> tiles) {
            
                Tile backUpTiles = this.getCurrentTile();
        
		Coords coords = getCurrentTile().getCoords();
                Coords south = new Coords(coords.getX(), coords.getY()+1);
                Coords north = new Coords(coords.getX(), coords.getY()-1);
                Coords east = new Coords(coords.getX()+1, coords.getY());
                Coords west = new Coords(coords.getX()-1, coords.getY());

                ArrayList<Tile> name =new ArrayList(tiles.values());
                
                ArrayList<Tile> throughTiles = new ArrayList();
                ArrayList<Tile> reachableTiles = super.getReachableTiles(tiles);
                reachableTiles.add(backUpTiles);
                
                for(int i =0; i<throughTiles.size();i++){
                    this.setCurrentTile(throughTiles.get(i));
                    
                    for(Tile tile : reachableTiles )
                   
                }
                
                
                
                
                this.setCurrentTile(backUpTiles);
                return reachableTiles;
	}
    
}