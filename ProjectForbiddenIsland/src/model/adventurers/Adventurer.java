package model.adventurers;

import java.util.ArrayList;
import java.util.HashMap;
import model.game.Coords;
import model.game.Tile;


public abstract class Adventurer {

    private Tile currentTile;
    private boolean hasDry = false;
    private int numberActionEnable;
    private int numberActionMax = 3;

    	public boolean isHasDry() {
		return this.hasDry;
	}

	public void setHasDry(boolean hasDry) {
		this.hasDry = hasDry;
	}


	public void decreaseActions() {
            numberActionEnable--;
	}

	/**
	 * 
	 * @param coords
	 */
	public ArrayList<Tile> getReachableTiles(HashMap<Coords, Tile> tiles) {
            
		Coords coords = currentTile.getCoords();
                Coords south = new Coords(coords.getX(), coords.getY()+1);
                Coords north = new Coords(coords.getX(), coords.getY()-1);
                Coords east = new Coords(coords.getX()+1, coords.getY()+1);
                Coords west = new Coords(coords.getX()-1, coords.getY()+1);

                ArrayList<Tile> enableTiles = new ArrayList<>();

                if (tiles.containsKey(south)) {
                    enableTiles.add(tiles.get(south));
                } 
                else if (tiles.containsKey(north)) {
                    enableTiles.add(tiles.get(north));
                } 
                else if (tiles.containsKey(east)) {
                    enableTiles.add(tiles.get(east));
                } 
                else if (tiles.containsKey(west)) {
                    enableTiles.add(tiles.get(west));
                }

                return enableTiles;
	}

	public Tile getTuileDispo() {
		// TODO - implement Player.getTuileDispo
		throw new UnsupportedOperationException();
	}

        	public void move(Tile tile) {
		// TODO - implement Player.move
		throw new UnsupportedOperationException();
	}

	public int getNbAction() {
		// TODO - implement Player.getNbAction
		throw new UnsupportedOperationException();
	}

	public void getDrieableTiles() {
		// TODO - implement Player.getDrieableTiles
		throw new UnsupportedOperationException();
	}

	public boolean getHasDry() {
		return this.hasDry;
	}

	public void getCoords() {
		// TODO - implement Player.getCoords
		throw new UnsupportedOperationException();
	}





}