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
import static model.game.TileName.*;
import model.player.Player;
import util.message.InGameAction;
import util.message.InGameMessage;


public class GameController implements Observer {
    
    private ArrayList<Player> players;

        private final Tile diverDefaultTile;
        private final Tile engineerDefaultTile;
        private final Tile explorerDefaultTile;
        private final Tile messengerDefaultTile;
        private final Tile navigatorDefaultTile;
        private final Tile pilotDefaultTile;
        
        private Diver divers =null;
        private Engineer engineers = null;
        private Explorer explorers = null;
        private Messenger messengers = null;
        private Navigator navigators = null;
        private Pilot pilots = null;
        
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
            players = new ArrayList<>();
            setGrid(grid);
            grid.initSpe();
            
            


            ArrayList<Tile> name = new ArrayList(grid.getTiles());
             for(int i = 0; i<name.size();i++){
                if(name.get(i).getName() == IRON_GATE){
                    divers = new Diver(name.get(i));
                }else if(name.get(i).getName() == COPPER_GATE){
                    explorers = new Explorer(name.get(i));
                }else if(name.get(i).getName() == SILVER_GATE){
                    navigators = new Navigator(name.get(i));
                }else if(name.get(i).getName() == BRONZE_GATE){
                    engineers = new Engineer(name.get(i));
                }else if(name.get(i).getName() == GOLD_GATE){
                    messengers = new Messenger(name.get(i));
                }else if(name.get(i).getName() == FOOLS_LANDING){
                    pilots = new Pilot(name.get(i));
                }
            }
            
            start();
            
            // Default tiles
            diverDefaultTile = divers.getCurrentTile();
                System.out.println("test X : " + diverDefaultTile.getCoords().getX());
                System.out.println("test Y : " + diverDefaultTile.getCoords().getY());
            engineerDefaultTile = engineers.getCurrentTile();
            explorerDefaultTile = explorers.getCurrentTile();
            messengerDefaultTile = messengers.getCurrentTile();
            navigatorDefaultTile = navigators.getCurrentTile();
            pilotDefaultTile = pilots.getCurrentTile();
            
        }
        
        public void start(){    
            
            showTitle();
            registerPlayers();
            gameTurn(players.get(0));
            gameTurn(players.get(1));
            gameTurn(players.get(2));
            gameTurn(players.get(3));
            
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
//                while (this.getPlayers().get(name) != null) {
//                    System.out.print("\tPseudo already taken !" 
//                            + "\npseudo :");
//                    name = scan.nextLine();
//                }  
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
                                players.add(new Player(divers, name));
                                enableAdventurer.remove(diver);
                                break;
                            case "engineer" :
                                players.add(new Player( engineers, name));
                                enableAdventurer.remove(engineer);
                                break;
                            case "explorer" :
                                players.add(new Player( explorers, name));
                                enableAdventurer.remove(explorer);
                                break;
                            case "messenger" :
                                players.add(new Player(messengers, name));
                                enableAdventurer.remove(messenger);
                                break;
                            case "navigator" :
                                players.add( new Player(navigators, name));
                                enableAdventurer.remove(navigator);
                                break;
                            case "pilot" :
                                players.add(new Player(pilots, name));
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
            
            System.out.println(currentPlayer.getAdventurer().getRoleName());
            
            ArrayList<String> actions = new ArrayList<>();
                actions.add(move);
                actions.add(dry);
                actions.add(pass);
            Scanner scan = new Scanner(System.in);
            int i = currentPlayer.getAdventurer().getNumberActionEnable();
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
                        ArrayList<Tile> ListTiles = new ArrayList(currentPlayer.getAdventurer().enableMove(grid));
                        grid.showEnableTiles(ListTiles);
                        
                        
                        System.out.print("Select X tile coord : ");
                                int xMove = scan.nextInt();
                            System.out.print("Select Y tile coord : ");
                                int yMove = scan.nextInt();
                            if (grid.getTile(new Coords(xMove,yMove))) {
                                containsMove = true;
                            }
                            while (containsMove != true) {
                                System.out.println("\n\tError input coords please try again :");
                                System.out.println("Select X tile coord : ");
                                    xMove = scan.nextInt();
                                System.out.println("Select Y tile coord : ");
                                    yMove = scan.nextInt();
                                if (grid.getTile(new Coords(xMove,yMove))) {
                                containsMove = true;
                                }
                            }
                            move(grid.getWantedTile(new Coords(xMove,yMove)), currentPlayer);
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
                            if (grid.getTile(new Coords(xDry,yDry))) {
                                containsMove = true;
                            }
                            while (containsDry != true) {
                                System.out.println("\n\tError input coords please try again :");
                                System.out.println("Select X tile coord : ");
                                    xDry = scan.nextInt();
                                System.out.println("Select Y tile coord : ");
                                    yDry = scan.nextInt();
                                if (grid.getTile(new Coords(xDry,yDry))) {
                                containsMove = true;
                                }
                            }
                            dry(grid.getWantedTile(new Coords(xDry,yDry)), currentPlayer);
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
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public void addPlayer(Player player) {
        this.getPlayers().add(player);
    }
    
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    
}