package model.game;

import java.util.*;
import static model.game.State.*;
import static model.game.TileName.*;
import java.util.ArrayList;


public class Grid {
    
	private HashMap<Coords, Tile> tiles;

        public Grid() {
            this.tiles = new HashMap<>();
        }
        
        public void initGrid(){

//                int t =0;
//                int x =0;
//                int y =0;
//                TileName[] name = TileName.values();
//                
//            for (int i=1; i<=36; ++i) {
//                
//                if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
//                    
//                }else{
//
//                    getTiles().put( new Coords(x,y),new Tile( new Coords(x,y),dried,name[t]));
//                    System.out.println(name[t]);
//                    t=t+1;
//                }
//                
//                x=(x+1)%6;
//                if(x==0){
//                    y=y+1;
//                }
//            }
       }

        
    
        public void initSpe(){
 
            tiles.put(new Coords(0,2), new Tile( new Coords(0,2),DRIED,BREAKERS_BRIDGE));
            tiles.put(new Coords(0,3), new Tile( new Coords(0,3),FLOODED,BRONZE_GATE));
            
            //ligne 1
            tiles.put(new Coords(1,1), new Tile( new Coords(1,1),DRIED,CAVE_OF_SHADOWS));
            tiles.put(new Coords (1,2), new Tile( new Coords(1,2),DRIED,IRON_GATE));
            tiles.put(new Coords(1,3), new Tile( new Coords(1,3),DRIED,GOLD_GATE));
            tiles.put(new Coords(1,4), new Tile(new Coords(1,4),DRIED,CLIFFS_OF_ABANDON));
 
            //ligne 2
            tiles.put(new Coords(2,0), new Tile( new Coords(2,0),DRIED,CORAL_PALACE));
            tiles.put(new Coords(2,1), new Tile( new Coords(2,1),DRIED,SILVER_GATE));
            tiles.put(new Coords(2,2), new Tile( new Coords(2,2),GONE,DUNES_OF_DECEPTION));
            tiles.put(new Coords(2,3), new Tile( new Coords(2,3),DRIED,FOOLS_LANDING));
            tiles.put(new Coords(2,4), new Tile( new Coords(2,4),DRIED,COPPER_GATE));
            tiles.put(new Coords(2,5), new Tile( new Coords(2,5),DRIED,HOWLING_GARDEN));

            //ligne 3
            tiles.put(new Coords(3,0), new Tile( new Coords(3,0),DRIED,CRIMSON_FOREST));
            tiles.put(new Coords(3,1), new Tile( new Coords(3,1),FLOODED,LOST_LAGOON));
            tiles.put(new Coords(3,2), new Tile( new Coords(3,2),GONE,MISTY_MARSH));
            tiles.put(new Coords(3,3), new Tile( new Coords(3,3),FLOODED,OBSERVATORY));
            tiles.put(new Coords(3,4), new Tile( new Coords(3,4),GONE,PHANTOM_ROCK));
            tiles.put(new Coords(3,5), new Tile( new Coords(3,5),FLOODED,CAVE_OF_EMBERS));

            //ligne 4
            tiles.put(new Coords(4,1), new Tile( new Coords(4,1),DRIED,TEMPLE_OF_THE_SUN));
            tiles.put(new Coords(4,2), new Tile( new Coords(4,2),GONE,TEMPLE_OF_THE_MOON));
            tiles.put(new Coords(4,3), new Tile( new Coords(4,3),DRIED,TIDAL_PALACE));
            tiles.put(new Coords(4,4), new Tile( new Coords(4,4),DRIED,TWILIGHT_HOLLOW));

            //ligne 5
            tiles.put(new Coords(5,2), new Tile( new Coords(5,2),DRIED,WATCHTOWER));
            tiles.put(new Coords(5,3), new Tile( new Coords(5,3),FLOODED,WHISPERING_GARDEN));
        }

    public HashMap<Coords, Tile> getTiles() {
        return tiles;
    }
        
     

    public void show() {  
        for (Map.Entry<Coords,Tile> coords : tiles.entrySet()) {
            if(coords.getValue() != null){
            coords.getValue().show();
            }
        }
    }
    
    public void showEnableTiles(ArrayList<Tile> enableTiles) {
        
        int i = 0;
        
        for (Tile t : enableTiles) {
            System.out.println("\n" + i + ") Name : " + t.getName()
                                        + "\nCoords : "
                                        + "\n\tX : " + t.getCoords().getX()
                                        + "\n\tY : " + t.getCoords().getY());
            i++;
        }
        
    }
    
    public ArrayList<Tile> getAdjTiles(Tile tile) {

        ArrayList<Tile> list = new ArrayList();
        int col = tile.getCoords().getX();
        int lig = tile.getCoords().getY();

        Coords south = new Coords (col, lig+1);
        Coords north = new Coords (col, lig-1);
        Coords east = new Coords (col+1, lig);
        Coords west = new Coords (col-1, lig);

        if (this.getTiles().containsKey(south)) {
            list.add(this.getTiles().get(south));
        }
        if (this.getTiles().containsKey(north)) {
            list.add(this.getTiles().get(north));
        }
        if (this.getTiles().containsKey(east)) {
            list.add(this.getTiles().get(east));
        }
        if (this.getTiles().containsKey(west)) {
            list.add(this.getTiles().get(west));
        }    
            
        showEnableTiles(list);
        return list;   
    }       
    
    
    
    public ArrayList<Tile> getDiagTiles(Tile tile) {

  
        ArrayList<Tile> list = new ArrayList();
        int col = tile.getCoords().getX();
        int lig = tile.getCoords().getY();

        Coords topL = new Coords (col-1, lig-1);
        Coords topR = new Coords (col+1, lig-1);
        Coords botL = new Coords (col-1, lig+1);
        Coords botR = new Coords (col+1, lig+1);

        if (this.getTiles().containsKey(topL)) {
            list.add(this.getTiles().get(topL));
        }
        if (this.getTiles().containsKey(topR)) {
            list.add(this.getTiles().get(topR));
        }
        if (this.getTiles().containsKey(botL)) {
            list.add(this.getTiles().get(botL));
        }
        if (this.getTiles().containsKey(botR)) {
            list.add(this.getTiles().get(botR));
        }    
            
        showEnableTiles(list);
        return list; 
    }
    
}