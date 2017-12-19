package model.game;

import java.util.*;
import static model.game.State.*;
import static model.game.TileName.*;



public class Grid {

	HashMap<Coords,Tile> tiles;

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

                    tiles.put( new Coords(x,y),new Tile( new Coords(x,y),dried,name[t]));
                    System.out.println(name[t]);

                    tiles.put( new Coords(x,y),new Tile( new Coords(x,y),dried,TileName.getTileName(t)));

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
            tiles.put( new Coords(0,2),new Tile( new Coords(0,2),dried,BREAKERS_BRIDGE));
            tiles.put( new Coords(0,3),new Tile( new Coords(0,3),flooded,BRONZE_GATE));
            
            //ligne 1
            tiles.put( new Coords(1,1),new Tile( new Coords(1,1),dried,CAVE_OF_SHADOWS));
            tiles.put( new Coords(1,2),new Tile( new Coords(1,2),flooded,CAVE_OF_EMBERS));
            tiles.put( new Coords(1,3),new Tile( new Coords(1,3),dried,CLIFFS_OF_ABANDON));
            tiles.put( new Coords(1,4),new Tile( new Coords(1,4),dried,COPPER_GATE));
 
            //ligne 2
            tiles.put( new Coords(2,0),new Tile( new Coords(2,0),dried,CORAL_PALACE));
            tiles.put( new Coords(2,1),new Tile( new Coords(2,1),dried,CRIMSON_FOREST));
            tiles.put( new Coords(2,2),new Tile( new Coords(2,2),gone,DUNES_OF_DECEPTION));
            tiles.put( new Coords(2,3),new Tile( new Coords(2,3),dried,FOOLS_LANDING));
            tiles.put( new Coords(2,4),new Tile( new Coords(2,4),dried,GOLD_GATE));
            tiles.put( new Coords(2,5),new Tile( new Coords(2,5),dried,HOWLING_GARDEN));

            //ligne 3
            tiles.put( new Coords(3,0),new Tile( new Coords(3,0),dried,IRON_GATE));
            tiles.put( new Coords(3,1),new Tile( new Coords(3,1),flooded,LOST_LAGOON));
            tiles.put( new Coords(3,2),new Tile( new Coords(3,2),dried,MISTY_MARSH));
            tiles.put( new Coords(3,3),new Tile( new Coords(3,3),flooded,OBSERVATORY));
            tiles.put( new Coords(3,4),new Tile( new Coords(3,4),gone,PHANTOM_ROCK));
            tiles.put( new Coords(3,5),new Tile( new Coords(3,5),dried,SILVER_GATE));

            //ligne 4
            tiles.put( new Coords(4,1),new Tile( new Coords(4,1),dried,TEMPLE_OF_THE_SUN));
            tiles.put( new Coords(4,2),new Tile( new Coords(4,2),gone,TEMPLE_OF_THE_MOON));
            tiles.put( new Coords(4,3),new Tile( new Coords(4,3),dried,TIDAL_PALACE));
            tiles.put( new Coords(4,4),new Tile( new Coords(4,4),dried,TWILIGHT_HOLLOW));

            //ligne 5
            tiles.put( new Coords(5,2),new Tile( new Coords(5,3),dried,WATCHTOWER));
            tiles.put( new Coords(5,3),new Tile( new Coords(5,3),flooded,WHISPERING_GARDEN));
            
            
        }
        
     

    public void show() {
        System.out.println("YOLOOOOOOOO");
        int i =1;         
        for(int y =0; y<6;y++){
            for(int x= 0; x<6; x++){
                Coords coord = new Coords(x,y);
                
                        
                if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
                    
                }else{
                    tiles.get(coord).show();
                }
                i++;
            }
        }
        
        
//        for (Map.Entry<Coords,Tile> coords : tiles.entrySet()) {
//            if(coords.getValue() != null){
//            coords.getValue().show();
//            }
//        }
    }

}
