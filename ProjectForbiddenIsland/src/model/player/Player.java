package model.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import model.game.*;
import model.adventurers.*;

public class Player {

	private Game game;
	private Adventurer role;
	private String pseudo;


	public Adventurer getAdventurer() {
            return role;
	}

	public String getPseudo() {
            return pseudo;
	}

}