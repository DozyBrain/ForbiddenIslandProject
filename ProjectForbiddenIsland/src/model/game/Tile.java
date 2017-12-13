package model.game;

import model.player.Player;
import java.util.*;

public class Tile {

	private Coords coords;
	private Collection<Player> playersOn;
	private State currentState;
	private TileName name;

	/**
	 * 
	 * @param grid
	 */
	public void movePawn(Grid grid) {
		// TODO - implement Tile.movePawn
		throw new UnsupportedOperationException();
	}

    /**
     * @return the coords
     */
    public Coords getCoords() {
        return coords;
    }

    /**
     * @param coords the coords to set
     */
    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    /**
     * @return the name
     */
    public TileName getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(TileName name) {
        this.name = name;
    }

    /**
     * @return the playersOn
     */
    public Collection<Player> getPlayersOn() {
        return playersOn;
    }

    /**
     * @return the currentState
     */
    public State getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

}