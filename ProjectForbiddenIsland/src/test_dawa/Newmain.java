/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_dawa;

import java.util.ArrayList;
import model.adventurers.Adventurer;
import model.adventurers.Diver;
import model.adventurers.Explorer;
import model.adventurers.Navigator;
import model.game.*;
import model.game.TileName.*;
import static model.game.TileName.COPPER_GATE;
import static model.game.TileName.IRON_GATE;
import static model.game.TileName.SILVER_GATE;

/**
 *
 * @author Nans
 */
public class Newmain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grid grille = new Grid();
        grille.initSpe();
        Diver diver =null;
        Explorer explorer = null;
        Navigator navigator = null;
        ArrayList<Tile> name = new ArrayList(grille.getTiles());
         for(int i = 0; i<name.size();i++){
            if(name.get(i).getName() == IRON_GATE){
                System.out.println("dievr init");
                diver = new Diver(name.get(i));
            }else if(name.get(i).getName() == COPPER_GATE){
                System.out.println("explorer init");
                explorer = new Explorer(name.get(i));
            }else if(name.get(i).getName() == SILVER_GATE){
                System.out.println("navigator init");
                navigator = new Navigator(name.get(i));
            }
        
         }
        
        
        
        
        ArrayList<Tile> tileDive = new ArrayList(diver.enableMove(grille));
        ArrayList<Tile> tileExplorer = new ArrayList(explorer.enableMove(grille));
        ArrayList<Tile> tileNavigator = new ArrayList(navigator.enableMove(grille));
        
        System.out.println("");
        System.out.println("AFFICHE GRILLE");
        System.out.println("");
        
//        for(int i = 0; i< tileDive.size(); i++){
//            tileDive.get(i).show();
//        }

        for(int i = 0; i< tileNavigator.size(); i++){
            tileNavigator.get(i).show();
        }
           
        
    }
    
}
