package model.player;

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

	}

	public void decreaseActions() {

	}

	/**
	 * 
	 * @param coords
	 */
	public Collection<Tuile> getEnableTiles(Coords coords) {
		// TODO - implement Player.getEnableTiles
		throw new UnsupportedOperationException();
	}

	public void getReachableTiles() {
		// TODO - implement Player.getReachableTiles
		throw new UnsupportedOperationException();
	}

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