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
            IHM ihm = new IHM();

            
            for (Map.Entry<String,Player> e : gameController.getPlayers().entrySet()){
                Player currentPlayer = e.getValue();
                ViewAdventurer viewAdventurer = new ViewAdventurer(currentPlayer.getPseudo(), currentPlayer.getAdventurer()., Color.yellow);
            }
    }
    
}
