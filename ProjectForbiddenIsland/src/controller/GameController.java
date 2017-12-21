package controller;

import java.awt.Color;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import view.*;
import model.game.*;
import model.player.Player;
import util.message.InGameAction;
import util.message.InGameMessage;


public class GameController implements Observer {
    
    	private HashMap<String,Player> players;

//	ViewAdventurer ViewAdventurer;
//	View View;
	Grid grid;
        
        public GameController (Grid grid) {
            players = new HashMap<>();
            setGrid(grid);
            start();
        }
        
        public void start(){              
        }

        public void move(Tile tile, Player currentPlayer) {
            currentPlayer.getAdventurer().setCurrentTile(tile);
            tile.addPlayerOn(currentPlayer);
        }
        
        public void dry(Tile tile){
            tile.setCurrentState(State.DRIED);
        }        
          
//          Adventurer a = currentPlayer.getAdventurer();
//          Tile adventurerTile = a.getCurrentTile();
//          ArrayList<Tile> tileList = a.getReachableTiles(grid.getTiles());
        
        public void gameTurn(Player currentPlayer){
//            case () {
//            
//            }  
        }

        @Override
        public void update(Observable arg0, Object arg1) {
//            if (arg1 instanceof InGameMessage) {
//                InGameMessage m = (InGameMessage) arg1;
//
//                switch ((InGameAction) m.getType()) {
//                case SELECT_TILE:
//                    doAction(m.getContent());
//                    break;
//                case MOVE:
//                    setMoveAction();
//
//                    break;
//                case GET_TREASURE:
//
//                    break;
//                case GIVE_CARD:
//
//                    break;
//                case DRY:
//                    dry();
//                    break;
//                case USE_CAPACITY:
//                    setCapacityActionT();
//                    break;
//                case USE_CARD:         
//
//                    break;
//                case END_TURN:
//                    endTurn();
//                    break;
//
//                default:
//                    break;
//                }
//        
//            }    
        }

    /**
     * @return the players
     */
    public HashMap<String,Player> getPlayers() {
        return players;
    }
    
    public void addPlayer(Player player) {
        this.getPlayers().put(player.getPseudo(), player);
    }
    
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    
}