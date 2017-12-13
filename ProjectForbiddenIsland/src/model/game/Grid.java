package model.game;

import java.util.*;
import static model.game.State.dried;



public class Grid {

	HashMap<Coords,Tile> tiles;

        public Grid() {
            this.tiles = new HashMap();
        }
        
        public void initGrid(){
                int t =0;
                int x =0;
                int y =0;
            for (int i=1; i<=36; ++i) {
                
                if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
                    
                }else{
                    tiles.put( new Coords(x,y),new Tile( new Coords(x,y),dried,TileName.getTileName(t)));
                    t=t+1;
                }
                
                x=(x+1)%6;
                if(x==0){
                    y=y+1;
                }
            }
        }
        
	/**
	 * 
	 * @param coords
	 */
	public Tile getTile(Coords coords) {
		// TODO - implement Grid.getTile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tile
	 */
	public void drie(Tile tile) {
		// TODO - implement Grid.drie
		throw new UnsupportedOperationException();
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
        
        //getKey() getValue() 
        
        for (Map.Entry<Coords,Tile> coords : tiles.entrySet()) {
            if(coords.getValue() != null){
            coords.getValue().show();
            }
        }
    }

}
