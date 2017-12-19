package model.game;

import java.util.*;
import static model.game.State.dried;



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
            for (int i=1; i<=36; ++i) {
                
                if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
                    
                }else{
                    getTiles().put( new Coords(x,y),new Tile( new Coords(x,y),dried,TileName.getTileName(t)));
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
            return getTiles().get(coords);
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
        
        for (Map.Entry<Coords,Tile> coords : getTiles().entrySet()) {
            if(coords.getValue() != null){
            coords.getValue().show();
            }
        }
    }

}
