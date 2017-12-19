package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.*;


public abstract class Adventurer {

    private Tile currentTile;

    private int numberActionEnable;
    private int numberActionMax = 3;
    
    // Cardinal Positions
    Coords coords = getCurrentTile().getCoords();
    Coords south = new Coords(coords.getX(), coords.getY()-1);
    Coords north = new Coords(coords.getX(), coords.getY()+1);
    Coords east = new Coords(coords.getX()+1, coords.getY());
    Coords west = new Coords(coords.getX()-1, coords.getY());
    
        protected Adventurer(Tile currentTile) {
            setCurrentTile(currentTile);
            setNumberActionEnable(numberActionMax);
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

}