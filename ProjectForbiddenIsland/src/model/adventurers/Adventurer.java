package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.*;
import static model.game.State.dried;
import static model.game.State.flooded;


public abstract class Adventurer {

    private Tile currentTile;

    private int numberActionEnable;
    private int numberActionMax = 3;
    
    // Cardinal Positions
    Coords tile;
    Coords south;
    Coords north;
    Coords east;
    Coords west ;
    
        protected Adventurer(Tile currentTile) {
            this.setCurrentTile(currentTile);
            this.setNumberActionEnable(numberActionMax);
            // Cardinal Positions
//            tile = getCurrentTile().getCoords();
//            south = new Coords(tile.getX(), tile.getY()-1);
//            north = new Coords(tile.getX(), tile.getY()+1);
//            east = new Coords(tile.getX()+1, tile.getY());
//            west = new Coords(tile.getX()-1, tile.getY());
        }

	public void decreaseActions() {
            setNumberActionEnable(getNumberActionEnable() - 1);
	}

	/**
	 * 
	 * @param coords
	 */
	public ArrayList<Tile> getReachableTiles(HashMap<Coords, Tile> tiles) {

            ArrayList<Tile> enableTiles = new ArrayList<>();

            if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.gone) {
                enableTiles.add(tiles.get(south));
            } 
            else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.gone) {
                enableTiles.add(tiles.get(north));
            } 
            else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.gone) {
                enableTiles.add(tiles.get(east));
            } 
            else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.gone) {
                enableTiles.add(tiles.get(west));
            }

            return enableTiles;
	}

	public int getNbAction() {
            return this.getNumberActionEnable();
	}

	public void getDryableTiles(HashMap<Coords, Tile> tiles) {
            
            ArrayList<Tile> drieableTiles = new ArrayList<>();
            
            if (tiles.containsKey(tile) || tiles.get(tile).getCurrentState() != State.flooded) {
                drieableTiles.add(tiles.get(tile));
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

	public Coords getCoords() {
		return getCurrentTile().getCoords();
	}

    /**
     * @return the currentTile
     */
    public Tile getCurrentTile() {
        return currentTile;
    }

    /**
     * @return the numberActionEnable
     */
    public int getNumberActionEnable() {
        return numberActionEnable;
    }

    /**
     * @param numberActionEnable the numberActionEnable to set
     */
    public void setNumberActionEnable(int numberActionEnable) {
        this.numberActionEnable = numberActionEnable;
    }

    /**
     * @return the numberActionMax
     */
    public int getNumberActionMax() {
        return numberActionMax;
    }

    /**
     * @param currentTile the currentTile to set
     */
    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public ArrayList<Tile> enableMove(Grid grille) {
        
        ArrayList<Tile> tuilesPossibles = new ArrayList<>();
        ArrayList<Tile> tuilesAdj = new ArrayList<>();
        tuilesAdj = grille.getAdjTile(this.getCurrentTile());
        
        for (Tile t : tuilesAdj) {
            if (t.getCurrentState() == dried ||t.getCurrentState() == flooded ) {
                tuilesPossibles.add(t);
            }
        }
        return tuilesPossibles;
    }
    
    
    
}