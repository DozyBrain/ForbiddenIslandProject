package model.game;

import model.player.Player;
import java.util.*;

public class Tile {

	private Coords coords;
	private ArrayList<Player> playersOn;
	private State currentState;
	private TileName name;

        public Tile(Coords coords, State currentState, TileName name) {
            this.coords = coords;
            this.currentState = currentState;
            this.name = name;
            playersOn = new ArrayList<>();
        }
        
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Tile getTiles(int x, int y) {
		// TODO - implement Tile.getTiles
		throw new UnsupportedOperationException();
	}

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

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    
    public void addPlayerOn(Player player) {
        this.getPlayersOn().add(player);
    }

    public void show() {
        System.out.println("Nom: ");
        System.out.println(this.getName());
        System.out.println("Etat: ");
        System.out.println(this.getCurrentState());
        System.out.println("Coord: ");
        this.getCoords().show();
        System.out.println("");
        System.out.println("");
    }

    /**
     * @return the playersOn
     */
    public ArrayList<Player> getPlayersOn() {
        return playersOn;
    }

    /**
     * @param playersOn the playersOn to set
     */
    public void setPlayersOn(ArrayList<Player> playersOn) {
        this.playersOn = playersOn;
    }

}
