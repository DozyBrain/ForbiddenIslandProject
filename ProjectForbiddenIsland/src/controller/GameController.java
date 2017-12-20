package controller;

import java.util.HashMap;
import view.*;
import model.game.*;
import model.player.Player;


public class GameController {
    
    	HashMap<String,Player> players;
	ViewAdventurer ViewAdventurer;
	View View;
	Grid grid;

        public void move(Tile tile, Player currentPlayer) {
            currentPlayer.getAdventurer().setCurrentTile(tile);
            tile.addPlayerOn(currentPlayer);
        }
        
        public void dry(Tile tile){
            tile.setCurrentState(State.dried);
        }        
          
//          Adventurer a = currentPlayer.getAdventurer();
//          Tile adventurerTile = a.getCurrentTile();
//          ArrayList<Tile> tileList = a.getReachableTiles(grid.getTiles());
        
        public void gameTurn(Player currentPlayer){
//            case () {
//            
//            } 
            
        }
        
        
        
}