package controller;

import java.awt.Color;
import java.util.ArrayList;
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

        private final Tile diverDefaultTile;
        private final Tile engineerDefaultTile;
        private final Tile explorerDefaultTile;
        private final Tile messengerDefaultTile;
        private final Tile navigatorDefaultTile;
        private final Tile pilotDefaultTile;
        
        // Differents adventurers label
        String diver = "diver";
        String engineer = "engineer";
        String explorer = "explorer";
        String messenger = "messenger";
        String navigator = "navigator";
        String pilot = "pilot";
        //Differents actions label
        String move = "move";
        String dry = "dry";
        String pass = "pass";
        
        
	Grid grid;
        
        public GameController (Grid grid) {
            players = new HashMap<>();
            setGrid(grid);
            grid.initSpe();
            start();
            
            // Default tiles
            diverDefaultTile = grid.getTiles().get(new Coords(2,1));   
                System.out.println("test X : " + diverDefaultTile.getCoords().getX());
                System.out.println("test Y : " + diverDefaultTile.getCoords().getY());
            engineerDefaultTile = grid.getTiles().get(new Coords(3,0));
            explorerDefaultTile = grid.getTiles().get(new Coords(4,2));
            messengerDefaultTile = grid.getTiles().get(new Coords(1,2));
            navigatorDefaultTile = grid.getTiles().get(new Coords(3,1));
            pilotDefaultTile = grid.getTiles().get(new Coords(3,2));
            
        }
        
        public void start(){    
            
            showTitle();
            registerPlayers();
            gameTurn(players.get("test"));
            
        }
        
        public void showTitle() {
            
            System.out.println("***************************************************");
            System.out.println("*                                                 *");
            System.out.println("*     P R O J E T   I L E   I N T E R D I T E     *");
            System.out.println("*                                                 *");
            System.out.println("***************************************************\n");
            
        }

        public void registerPlayers() {

            System.out.println("\n*      P L A Y E R   R E G I S T R A T I O N      *\n");
            
            Scanner scan = new Scanner(System.in);
            boolean ok = false;
            boolean quit = false;
            boolean dispo;
            int i = 0;
            
            
            ArrayList<String> enableAdventurer = new ArrayList<>();
                enableAdventurer.add(diver);
                enableAdventurer.add(engineer);
                enableAdventurer.add(explorer);
                enableAdventurer.add(messenger);
                enableAdventurer.add(navigator);
                enableAdventurer.add(pilot);
            
            while ( i < 4 && quit != true) {
                
                dispo = false;

                System.out.print("\nPlayer " + (i+1) + "\npseudo :");
                String name = scan.nextLine().toLowerCase();
                while (this.getPlayers().get(name) != null) {
                    System.out.print("\tPseudo already taken !" 
                            + "\npseudo :");
                    name = scan.nextLine();
                }  
                if (!name.equals("")) {
                    System.out.print("role :");
                    String roleName = scan.nextLine().toLowerCase();
                    for (String s : enableAdventurer) {
                        if (s.equals(roleName)) {
                            dispo = true;
                        }
                    }   
                    while (dispo != true) {
                        System.out.print("\tInput error, try again :"
                                + "\nrole :");
                        roleName = scan.nextLine().toLowerCase();
                        for (String s : enableAdventurer) {
                            if (s.equals(roleName)) {
                                dispo = true;
                            }
                        }  
                    }

                    switch (roleName.toLowerCase()) {
                            case "diver" :
                                players.put(name, new Player(new Diver(diverDefaultTile), name));
                                enableAdventurer.remove(diver);
                                break;
                            case "engineer" :
                                players.put(name, new Player(new Engineer(engineerDefaultTile), name));
                                enableAdventurer.remove(engineer);
                                break;
                            case "explorer" :
                                players.put(name, new Player(new Explorer(explorerDefaultTile), name));
                                enableAdventurer.remove(explorer);
                                break;
                            case "messenger" :
                                players.put(name, new Player(new Messenger(messengerDefaultTile), name));
                                enableAdventurer.remove(messenger);
                                break;
                            case "navigator" :
                                players.put(name, new Player(new Navigator(navigatorDefaultTile), name));
                                enableAdventurer.remove(navigator);
                                break;
                            case "pilot" :
                                players.put(name, new Player(new Pilot(diverDefaultTile), name));
                                enableAdventurer.remove(pilot);
                                break;
                    }
                    
                    i++;
                            
                } else {
                    if (i > 1) {
                        quit = true;
                    } else {
                        System.out.println("\nPas encore assez de joueurs dans la partie\n");
                    }
                }   
            }
        }
        
        public void move(Tile tile, Player currentPlayer) {
            currentPlayer.getAdventurer().setCurrentTile(tile);
            tile.addPlayerOn(currentPlayer);
            currentPlayer.getAdventurer().decreaseActions();
        }
        
        public void dry(Tile tile, Player currentPlayer){
            tile.setCurrentState(State.DRIED);
            currentPlayer.getAdventurer().decreaseActions();
        }        
          
//          Adventurer a = currentPlayer.getAdventurer();
//          Tile adventurerTile = a.getCurrentTile();
//          ArrayList<Tile> tileList = a.getReachableTiles(grid.getTiles());
        
        public void gameTurn(Player currentPlayer){
            
            ArrayList<String> actions = new ArrayList<>();
                actions.add(move);
                actions.add(dry);
                actions.add(pass);
            Scanner scan = new Scanner(System.in);
            int i = currentPlayer.getAdventurer().getNumberActionMax();
            boolean quit = false;
            boolean correctNameAction = false;
            
            while (i > 0 && quit != true) {
                System.out.println("\nChoose action (move/dry/pass) : "); 
                String action = scan.nextLine().toLowerCase();
                for (String s : actions) {
                    if (s.equals(action)){
                        correctNameAction = true;
                    }
                }
                while (correctNameAction != true){
                    System.out.println("\n\tInput error ! Please select a correct action :"
                            + "\nChoose action (move/dry/pass) : "); 
                    action = scan.nextLine().toLowerCase();
                    for (String s : actions) {
                        if (s.equals(action)){
                            correctNameAction = true;
                        }
                    }
                }
                switch (action) {
                    
                    case "move" :
                        boolean containsMove = false;
                        if (currentPlayer.getAdventurer().getRoleName() == "explorer") {
                            grid.getAdjTiles(currentPlayer.getAdventurer().getCurrentTile());
                        }
                        grid.getDiagTiles(currentPlayer.getAdventurer().getCurrentTile());
                        System.out.print("Select X tile coord : ");
                                int xMove = scan.nextInt();
                            System.out.print("Select Y tile coord : ");
                                int yMove = scan.nextInt();
                            if (grid.getTiles().containsKey(new Coords (xMove,yMove))) {
                                containsMove = true;
                            }
                            while (containsMove != true) {
                                System.out.println("\n\tError input coords please try again :");
                                System.out.println("Select X tile coord : ");
                                    xMove = scan.nextInt();
                                System.out.println("Select Y tile coord : ");
                                    yMove = scan.nextInt();
                                if (grid.getTiles().containsKey(new Coords (xMove,yMove))) {
                                containsMove = true;
                                }
                            }
                            move(grid.getTiles().get(new Coords(xMove,yMove)), currentPlayer);
                            currentPlayer.getAdventurer().decreaseActions();
                        break;
                        
                    case "dry" :
                        boolean containsDry = false;
                        if (currentPlayer.getAdventurer().getRoleName() == "explorer") {
                            grid.getAdjTiles(currentPlayer.getAdventurer().getCurrentTile());
                        }
                        grid.getDiagTiles(currentPlayer.getAdventurer().getCurrentTile());
                        System.out.print("Select X tile coord : ");
                                int xDry = scan.nextInt();
                            System.out.print("Select Y tile coord : ");
                                int yDry = scan.nextInt();
                            if (grid.getTiles().containsKey(new Coords (xDry,yDry))) {
                                containsMove = true;
                            }
                            while (containsDry != true) {
                                System.out.println("\n\tError input coords please try again :");
                                System.out.println("Select X tile coord : ");
                                    xDry = scan.nextInt();
                                System.out.println("Select Y tile coord : ");
                                    yDry = scan.nextInt();
                                if (grid.getTiles().containsKey(new Coords (xDry,yDry))) {
                                containsMove = true;
                                }
                            }
                            dry(grid.getTiles().get(new Coords(xDry,yDry)), currentPlayer);
                            currentPlayer.getAdventurer().decreaseActions();
                        break;
                        
                    case "pass" :
                        quit = true;
                        break;
                } 
            }  
        }

        @Override
        public void update(Observable arg0, Object arg1) {    
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