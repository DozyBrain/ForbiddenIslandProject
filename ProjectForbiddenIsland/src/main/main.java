/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.GameController;
import java.awt.Color;
import java.io.IOException;
import java.util.Map;
import model.adventurers.*;
import model.game.Coords;
import model.game.Grid;
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
            
        Grid grid = new Grid();
        grid.initSpe();
        
        GameController game = new GameController(grid);
        game.start();

    }
    
}
