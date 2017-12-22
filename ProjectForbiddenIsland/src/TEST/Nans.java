/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import java.util.ArrayList;
import model.adventurers.Diver;
import model.game.Grid;
import model.game.Tile;
import static model.game.TileName.IRON_GATE;

/**
 *
 * @author Nans
 */
public class Nans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grid grid = new Grid();
        grid.initSpe();
        Diver diver = null;
        ArrayList<Tile> name = new ArrayList(grid.getTiles());
             for(int i = 0; i<name.size();i++){
                if(name.get(i).getName() == IRON_GATE){
                    diver= new Diver(name.get(i));
                }
             }
    
        
         for(Tile tile :diver.enableMove(grid)){
             tile.show();
         };
           
        }
    
}
