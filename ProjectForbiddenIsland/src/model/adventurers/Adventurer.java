package model.adventurers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import model.game.*;
import model.player.Pawn;


public abstract class Adventurer {

    private Tile currentTile;
    private int numberActionEnable;
    private int numberActionMax = 3;
    private String roleName = "";
    private Pawn pawn = new Pawn("");
    
    // Cardinal Positions
    protected Coords coords;
    protected Coords south;
    protected Coords north;
    protected Coords east;
    protected Coords west;
    
        protected Adventurer(Tile currentTile) {
            setCurrentTile(currentTile);
            setNumberActionEnable(numberActionMax);
            
            // P O S I T I O N   V A L U E S   S E T //
            coords = getCurrentTile().getCoords();
            south = new Coords(coords.getX(), coords.getY()-1);
            north = new Coords(coords.getX(), coords.getY()+1);
            east = new Coords(coords.getX()+1, coords.getY());
            west = new Coords(coords.getX()-1, coords.getY());
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

            return enableTiles;
	}

	public int getNbAction() {
            return this.getNumberActionEnable();
	}

	public void getDryableTiles(HashMap<Coords, Tile> tiles) {
            
            ArrayList<Tile> drieableTiles = new ArrayList<>();
            
            if (tiles.containsKey(coords) || tiles.get(coords).getCurrentState() != State.FLOODED) {
                drieableTiles.add(tiles.get(coords));
            } 
            else if (tiles.containsKey(south) || tiles.get(south).getCurrentState() != State.FLOODED) {
                drieableTiles.add(tiles.get(south));
            } 
            else if (tiles.containsKey(north) || tiles.get(north).getCurrentState() != State.FLOODED) {
                drieableTiles.add(tiles.get(north));
            } 
            else if (tiles.containsKey(east) || tiles.get(east).getCurrentState() != State.FLOODED) {
                drieableTiles.add(tiles.get(east));
            } 
            else if (tiles.containsKey(west) || tiles.get(west).getCurrentState() != State.FLOODED) {
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
    
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String name) {
        this.roleName = name;
    }
    
    public Pawn getPawn(){
        return this.pawn;
    }
    
    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }
    
    public void setColor(Color color) {
        this.getPawn().setColor(color);
    }

}