package model.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import model.game.*;
import model.adventurers.*;

public class Player {

	Game game;
	Adventurer role;
	Tile currentTile;
	private String pseudo;
	private boolean hasDry = false;
	private int numberActionEnable;
	private int numberActionMax = 3;

	public boolean isHasDry() {
		return this.hasDry;
	}

	public void setHasDry(boolean hasDry) {
		this.hasDry = hasDry;
	}

	public Adventurer getAdventurer() {
            return role;
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
                Coords south = new Coords();
                Coords north = new Coords();
                Coords east = new Coords();
                Coords west = new Coords();
                ArrayList<Tile> enableTiles = new ArrayList<>();
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (tiles.containsKey(coords)) {
                            enableTiles.add(tiles.get(coords));
                        }
                    }
                }
                
                 
	}

//	public void getEnableTiles() {
//		// TODO - implement Player.getReachableTiles
//		throw new UnsupportedOperationException();
//	}

	public Tile getTuileDispo() {
		// TODO - implement Player.getTuileDispo
		throw new UnsupportedOperationException();
	}

	public String getName() {
		// TODO - implement Player.getName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tile
	 */
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