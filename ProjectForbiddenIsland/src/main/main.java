/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Vue.IHM;
import controller.GameController;
import java.awt.Color;
import java.io.IOException;
import java.util.Map;
import model.adventurers.*;
import model.game.Coords;
import model.game.State;
import model.game.Tile;
import model.game.TileName;
import model.player.Player;
import view.*;

/**
 *
 * @author Einherjar
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
            GameController gameController = new GameController();
            Tile tile = new Tile(new Coords(0, 0), State.DRIED, TileName.IRON_GATE);
            gameController.addPlayer(new Player(new Engineer(tile), "joueur1"));
            gameController.addPlayer(new Player(new Explorer(tile), "joueur2"));
            gameController.addPlayer(new Player(new Messenger(tile), "joueur3"));
            gameController.addPlayer(new Player(new Navigator(tile), "joueur4"));
            
//            IHM ihm = new IHM();
            
            for (Map.Entry<String,Player> e : gameController.getPlayers().entrySet()){
                Player currentPlayer = e.getValue();
                ViewAdventurer viewAdventurer = new ViewAdventurer(currentPlayer.getPseudo(), currentPlayer.getAdventurer().getRoleName(), Color.yellow);
            }
    }
    
}
