package model.player;

import model.adventurers.*;

public class Player {

	private Adventurer adventurer;
	private String pseudo;
        
        public Player(Adventurer adventurer, String pseudo) {
            setAdventurer(adventurer);
            setPseudo(pseudo);
        }


	public Adventurer getAdventurer() {
            return adventurer;
	}

	public String getPseudo() {
            return pseudo;
	}

    /**
     * @param adventurer the adventurer to set
     */
    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
        
}