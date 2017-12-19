package controller;

import java.util.ArrayList;
import java.util.Collection;
import model.adventurers.Adventurer;
import view.*;
import model.game.*;
import model.player.Player;


public class GameController {
    
    	ArrayList<Player> player;
	ViewAdventurer ViewAdventurer;
	View View;
	Grid grid;

        public void move(Tile tile, Player currentPlayer) {
            currentPlayer.getAdventurer().setCurrentTile(tile);
        }
        
        public void dry(Tile tile){
            tile.setCurrentState(State.dried);
        }
        
          
//          Adventurer a = currentPlayer.getAdventurer();
//          Tile adventurerTile = a.getCurrentTile();
//          ArrayList<Tile> tileList = a.getReachableTiles(grid.getTiles());
        
        public void gameTurn(Player currentPlayer){
            while (currentPlayer.getAdventurer().getNumberActionEnable()>0){
                // les différentes actions que le joueur peut faire
                
                
            }
        }
        
}