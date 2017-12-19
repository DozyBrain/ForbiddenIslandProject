package controller;

import java.util.ArrayList;
import java.util.Collection;
import model.adventurers.Adventurer;
import view.*;
import model.game.*;
import model.player.Player;


public class GameController {
    
    	Collection<Player> player;
	ViewAdventurer ViewAdventurer;
	View View;
	Grid grid;

        public void move(Tile tile, Player currentPlayer) {
            currentPlayer.getAdventurer().setCurrentTile(tile);
        }
        
        public void movePawn(Tile tile) {    
	}
        
//          Adventurer a = currentPlayer.getAdventurer();
//          Tile adventurerTile = a.getCurrentTile();
//          ArrayList<Tile> tileList = a.getReachableTiles(grid.getTiles());
        
        public void 
        
}