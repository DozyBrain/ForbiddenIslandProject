/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import controller.GameController;
import java.awt.Color;
import java.util.Map;
import model.adventurers.Engineer;
import model.adventurers.Explorer;
import model.adventurers.Messenger;
import model.adventurers.Navigator;
import model.game.Coords;
import model.game.Grid;
import model.game.State;
import model.game.Tile;
import model.game.TileName;
import model.player.Pawn;
import model.player.Player;
import view.ViewAdventurer;

/**
 *
 * @author dussaulp
 */
public class PIERRE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            
            Grid grid = new Grid();
            grid.initSpe();
            
            GameController gameController = new GameController(grid);
            
            Tile tile = new Tile(new Coords(0, 0), State.DRIED, TileName.IRON_GATE);
            gameController.addPlayer(new Player(new Engineer(tile), "joueur1", new Pawn("RED")));
            gameController.addPlayer(new Player(new Explorer(tile), "joueur2", new Pawn("GREEN")));
            gameController.addPlayer(new Player(new Messenger(tile), "joueur3", new Pawn("WHITE")));
            gameController.addPlayer(new Player(new Navigator(tile), "joueur4", new Pawn("YELLOW")));
            
            for (Map.Entry<String,Player> e : gameController.getPlayers().entrySet()){
                Player currentPlayer = e.getValue();
                ViewAdventurer viewAdventurer = new ViewAdventurer(currentPlayer.getPseudo(), currentPlayer.getAdventurer().getRoleName(), currentPlayer.getAdventurer().getPawn().getColor());
            }
    }
    
}
