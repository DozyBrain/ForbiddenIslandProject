package controller;

import java.awt.Color;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import model.adventurers.*;
import view.*;
import model.game.*;
import model.player.Player;
import util.message.InGameAction;
import util.message.InGameMessage;


public class GameController implements Observer {
    
    private HashMap<String,Player> players;

//        private Tile diverDefaultTile;
//        private Tile engineerDefaultTile;
//        private Tile explorerDefaultTile;
//        private Tile messengerDefaultTile;
//        private Tile navigatorDefaultTile;
//        private Tile pilotDefaultTile;
        
	Grid grid;
        
        public GameController (Grid grid) {
            players = new HashMap<>();
            setGrid(grid);
            start();
            
//            diverDefaultTile = grid.getTiles().get(new Coords(2,1));
//            engineerDefaultTile = grid.getTiles().get(new Coords(3,0));
//            explorerDefaultTile = grid.getTiles().get(new Coords(4,2));
//            messengerDefaultTile = grid.getTiles().get(new Coords(1,2));
//            navigatorDefaultTile = grid.getTiles().get(new Coords(3,1));
//            pilotDefaultTile = grid.getTiles().get(new Coords(3,2));
            
        }
        
        public void start(){    
            
            showTitle();
            registerPlayers();
            grid.initGrid();    
            
        }
        
        public void showTitle() {
            
            System.out.println("***************************************************");
            System.out.println("*                                                 *");
            System.out.println("*     P R O J E T   I L E   I N T E R D I T E     *");
            System.out.println("*                                                 *");
            System.out.println("***************************************************");
            System.out.println("");
            
        }

        public void registerPlayers() {

            System.out.println("");
            System.out.println("*      P L A Y E R   R E G I S T R A T I O N      *");
            System.out.println("");
            
            Scanner scan = new Scanner(System.in);
            boolean ok = false;
            boolean quit = false;
            int i = 0;
            
            while ( i < 4 && quit != true) {
                // Registration Player 1
                System.out.print("Player " + (i+1) + "\n\tpseudo :");
                String p1name = scan.nextLine();
                if (p1name != "") {
                    System.out.print("\trole :");
                    String roleName = scan.nextLine();
                    roleName = roleName.toLowerCase();
                    if (roleName == "diver" 
                            || roleName == "engineer" 
                            || roleName == "explorer" 
                            || roleName == "messenger" 
                            || roleName == "navigator" 
                            || roleName == "pilot") 
                    {
                        ok = true;
                    }


                    while (ok == false) {
                        System.out.print("\trole input error :");
                        roleName = scan.nextLine();
                        roleName = roleName.toLowerCase();
                        if (roleName == "diver" 
                            || roleName == "engineer" 
                            || roleName == "explorer" 
                            || roleName == "messenger" 
                            || roleName == "navigator" 
                            || roleName == "pilot") 
                        { ok = true; }
                    }

                    switch (roleName.toLowerCase()) {
                            case "diver" :
                                players.put(p1name, new Player(new Diver(diverDefaultTile), p1name));
                            case "engineer" :
                                players.put(p1name, new Player(new Engineer(engineerDefaultTile), p1name));
                            case "explorer" :
                                players.put(p1name, new Player(new Explorer(explorerDefaultTile), p1name));
                            case "messenger" :
                                players.put(p1name, new Player(new Messenger(messengerDefaultTile), p1name));
                            case "navigator" :
                                players.put(p1name, new Player(new Navigator(navigatorDefaultTile), p1name));
                            case "pilot" :
                                players.put(p1name, new Player(new Pilot(diverDefaultTile), p1name));
                    }
                    
                    i++;
                            
                } else {
                    if (i > 1) {
                        quit = true;
                    } else {
                        System.out.println("Pas encore assez de joueurs dans la partie");
                    }
                }   
            }
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