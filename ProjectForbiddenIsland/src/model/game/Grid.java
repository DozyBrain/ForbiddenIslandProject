package model.game;

import java.util.*;
import static model.game.State.*;
import static model.game.TileName.*;
import java.util.ArrayList;


public class Grid {

    /**
     * @return the tiles
     */
    public HashMap<Coords,Tile> getTiles() {
        return tiles;
    }

	private HashMap<Coords,Tile> tiles;

        public Grid() {
            this.tiles = new HashMap();
        }
        
        public void initGrid(){
                int t =0;
                int x =0;
                int y =0;
                TileName[] name = TileName.values();
                
            for (int i=1; i<=36; ++i) {
                
                if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
                    
                }else{

                    getTiles().put( new Coords(x,y),new Tile( new Coords(x,y),DRIED,name[t]));
                    System.out.println(name[t]);
                    t=t+1;
                }
                
                x=(x+1)%6;
                if(x==0){
                    y=y+1;
                }
            }
        }
        
    
        public void initSpe(){
            tiles.put( new Coords(0,0),null);
            tiles.put( new Coords(1,0),null);
            tiles.put( new Coords(0,1),null);
            tiles.put( new Coords(0,4),null);
            tiles.put( new Coords(0,5),null);
            tiles.put( new Coords(1,5),null);
            tiles.put( new Coords(4,0),null);
            tiles.put( new Coords(4,5),null);
            tiles.put( new Coords(5,0),null);
            tiles.put( new Coords(5,1),null);
            tiles.put( new Coords(5,4),null);
            tiles.put( new Coords(5,5),null);
            
            //ligne 0
            tiles.put( new Coords(0,2),new Tile( new Coords(0,2),DRIED,BREAKERS_BRIDGE));
            tiles.put( new Coords(0,3),new Tile( new Coords(0,3),FLOODED,BRONZE_GATE));
            
            //ligne 1
            tiles.put( new Coords(1,1),new Tile( new Coords(1,1),DRIED,CAVE_OF_SHADOWS));
            tiles.put( new Coords(1,2),new Tile( new Coords(1,2),FLOODED,IRON_GATE));
            tiles.put( new Coords(1,3),new Tile( new Coords(1,3),DRIED,GOLD_GATE));
            tiles.put( new Coords(1,4),new Tile( new Coords(1,4),DRIED,CLIFFS_OF_ABANDON));
 
            //ligne 2
            tiles.put( new Coords(2,0),new Tile( new Coords(2,0),DRIED,CORAL_PALACE));
            tiles.put( new Coords(2,1),new Tile( new Coords(2,1),DRIED,SILVER_GATE));
            tiles.put( new Coords(2,2),new Tile( new Coords(2,2),GONE,DUNES_OF_DECEPTION));
            tiles.put( new Coords(2,3),new Tile( new Coords(2,3),DRIED,FOOLS_LANDING));
            tiles.put( new Coords(2,4),new Tile( new Coords(2,4),DRIED,COPPER_GATE));
            tiles.put( new Coords(2,5),new Tile( new Coords(2,5),DRIED,HOWLING_GARDEN));

            //ligne 3
            tiles.put( new Coords(3,0),new Tile( new Coords(3,0),DRIED,CRIMSON_FOREST));
            tiles.put( new Coords(3,1),new Tile( new Coords(3,1),FLOODED,LOST_LAGOON));
            tiles.put( new Coords(3,2),new Tile( new Coords(3,2),DRIED,MISTY_MARSH));
            tiles.put( new Coords(3,3),new Tile( new Coords(3,3),FLOODED,OBSERVATORY));
            tiles.put( new Coords(3,4),new Tile( new Coords(3,4),GONE,PHANTOM_ROCK));
            tiles.put( new Coords(3,5),new Tile( new Coords(3,5),DRIED,CAVE_OF_EMBERS));

            //ligne 4
            tiles.put( new Coords(4,1),new Tile( new Coords(4,1),DRIED,TEMPLE_OF_THE_SUN));
            tiles.put( new Coords(4,2),new Tile( new Coords(4,2),GONE,TEMPLE_OF_THE_MOON));
            tiles.put( new Coords(4,3),new Tile( new Coords(4,3),DRIED,TIDAL_PALACE));
            tiles.put( new Coords(4,4),new Tile( new Coords(4,4),DRIED,TWILIGHT_HOLLOW));

            //ligne 5
            tiles.put( new Coords(5,2),new Tile( new Coords(5,2),DRIED,WATCHTOWER));
            tiles.put( new Coords(5,3),new Tile( new Coords(5,3),FLOODED,WHISPERING_GARDEN));
            
            
        }
        
     

    public void show() {
     
        ArrayList<Tile> name =new ArrayList(tiles.values());
        for(int i =0; i< name.size();i++){
            if(name.get(i)!= null){
                name.get(i).show();
            }         
        }
        
        
//        for (Map.Entry<Coords,Tile> coords : tiles.entrySet()) {
//            if(coords.getValue() != null){
//            coords.getValue().show();
//            }
//        }
    }

}
