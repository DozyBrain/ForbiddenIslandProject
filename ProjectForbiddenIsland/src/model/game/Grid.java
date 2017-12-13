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
                int t =1;
                int x =0;
                int y =0;
            for (int i=1; i<=36; ++i) {
                
                if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
                    
                }else{
                    tiles.put( new Coords(x,y),new Tile( new Coords(x,y),dried,TileName.getTileName(t)));
                    System.out.println(TileName.getTileName(t));
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
            tiles.put( new Coords(0,2),new Tile( new Coords(0,2),dried,BREAKERS_BRIDGE));
            tiles.put( new Coords(0,3),new Tile( new Coords(0,3),flooded,BRONZE_GATE));
            tiles.put( new Coords(1,1),new Tile( new Coords(1,1),dried,CAVE_OF_SHADOWS));
            tiles.put( new Coords(1,2),new Tile( new Coords(1,2),flooded,CAVE_OF_EMBERS));
            tiles.put( new Coords(1,3),new Tile( new Coords(1,3),dried,CLIFFS_OF_ABANDON));
            
            
        }
	/**
	 * 
	 * @param coords
	 */
	public Tile getTile(Coords coords) {
            return tiles.get(coords);
	}

	/**
	 * 
	 * @param tile
	 */
	public void drie(Tile tile) {
            tile.setCurrentState(dried);
	}

	/**
	 * 
	 * @param tile
	 */
	public void movePawn(Tile tile) {
		// TODO - implement Grid.movePawn
		throw new UnsupportedOperationException();
	}

    public void show() {
        
        for (Map.Entry<Coords,Tile> coords : tiles.entrySet()) {
            if(coords.getValue() != null){
            coords.getValue().show();
            }
        }
    }

}
