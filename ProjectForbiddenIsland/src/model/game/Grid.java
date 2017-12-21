package model.game;

import java.util.*;
import static model.game.State.*;
import static model.game.TileName.*;
import java.util.ArrayList;


public class Grid {

    /**
     * @return the tiles
     */
//    public HashMap<Coords,Tile> getTiles() {
//        return tiles;
//    }

	private ArrayList<Tile> tiles;

        public Grid() {
            this.tiles = new ArrayList();
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
//            tiles.put( new Coords(0,0),null);
//            tiles.put( new Coords(1,0),null);
//            tiles.put( new Coords(0,1),null);
//            tiles.put( new Coords(0,4),null);
//            tiles.put( new Coords(0,5),null);
//            tiles.put( new Coords(1,5),null);
//            tiles.put( new Coords(4,0),null);
//            tiles.put( new Coords(4,5),null);
//            tiles.put( new Coords(5,0),null);
//            tiles.put( new Coords(5,1),null);
//            tiles.put( new Coords(5,4),null);
//            tiles.put( new Coords(5,5),null);
//            
            //ligne 0
            tiles.add(new Tile( new Coords(0,2),dried,BREAKERS_BRIDGE));
            tiles.add(new Tile( new Coords(0,3),flooded,BRONZE_GATE));
            
            //ligne 1
            tiles.add(new Tile( new Coords(1,1),dried,CAVE_OF_SHADOWS));
            tiles.add( new Tile( new Coords(1,2),dried,IRON_GATE));
            tiles.add(new Tile( new Coords(1,3),dried,GOLD_GATE));
            tiles.add(new Tile( new Coords(1,4),dried,CLIFFS_OF_ABANDON));
 
            //ligne 2
            tiles.add( new Tile( new Coords(2,0),dried,CORAL_PALACE));
            tiles.add(new Tile( new Coords(2,1),dried,SILVER_GATE));
            tiles.add(new Tile( new Coords(2,2),gone,DUNES_OF_DECEPTION));
            tiles.add(new Tile( new Coords(2,3),dried,FOOLS_LANDING));
            tiles.add(new Tile( new Coords(2,4),dried,COPPER_GATE));
            tiles.add(new Tile( new Coords(2,5),dried,HOWLING_GARDEN));

            //ligne 3
            tiles.add(new Tile( new Coords(3,0),dried,CRIMSON_FOREST));
            tiles.add(new Tile( new Coords(3,1),flooded,LOST_LAGOON));
            tiles.add( new Tile( new Coords(3,2),gone,MISTY_MARSH));
            tiles.add( new Tile( new Coords(3,3),flooded,OBSERVATORY));
            tiles.add( new Tile( new Coords(3,4),gone,PHANTOM_ROCK));
            tiles.add( new Tile( new Coords(3,5),flooded,CAVE_OF_EMBERS));

            //ligne 4
            tiles.add(new Tile( new Coords(4,1),dried,TEMPLE_OF_THE_SUN));
            tiles.add( new Tile( new Coords(4,2),gone,TEMPLE_OF_THE_MOON));
            tiles.add( new Tile( new Coords(4,3),dried,TIDAL_PALACE));
            tiles.add( new Tile( new Coords(4,4),dried,TWILIGHT_HOLLOW));

            //ligne 5
            tiles.add( new Tile( new Coords(5,2),dried,WATCHTOWER));
            tiles.add( new Tile( new Coords(5,3),flooded,WHISPERING_GARDEN));
            
            
        }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
        
     

    public void show() {
     
        
        for(int i =0; i< tiles.size();i++){
            if(tiles.get(i)!= null){
                tiles.get(i).show();
            }         
        }
        
        
//        for (Map.Entry<Coords,Tile> coords : tiles.entrySet()) {
//            if(coords.getValue() != null){
//            coords.getValue().show();
//            }
//        }
    }
    
    public ArrayList<Tile> getAdjTile(Tile currentTile) {

            ArrayList<Tile> Liste = new ArrayList();
            int col = currentTile.getCoords().getX();
            int lig = currentTile.getCoords().getY();
            for(int i=1; i<tiles.size();i++) {  
            
            if(col==0){
            // Verifie que la tuile positionCourante ne se situe pas sur les bord de la grille
            // Cad lig !=0 && lig!=5 && col!=0 && col!=5 
            // Sinon gére les exception
                if (lig==2||lig==3){                       
                    if ( ((tiles.get(i).getCoords().getX()== col+ 1) && tiles.get(i).getCoords().getY()==lig )  
                            ||((tiles.get(i).getCoords().getY()== lig -1) && (tiles.get(i).getCoords().getX()== col)) 
                            ||((tiles.get(i).getCoords().getY()== lig+1 ) && (tiles.get(i).getCoords().getX()== col))  ){
                        // Verifie si la tuile "tuiles.get(i)" est adjacente a la tuile positionCourante
                            Liste.add(tiles.get(i));
                    }
                } 
            }else if(col==5) {     
                if (lig==2||lig==3){                       
                    if ( ((tiles.get(i).getCoords().getX()== col-1) && tiles.get(i).getCoords().getY()==lig )  
                            ||((tiles.get(i).getCoords().getY()== lig -1) && (tiles.get(i).getCoords().getX()== col)) 
                            ||((tiles.get(i).getCoords().getX()== col) && tiles.get(i).getCoords().getY()==lig +1)  ){

                            Liste.add(tiles.get(i));
                        
                    }                        
                }  
            }else if(lig==0) { 
                if (col==2||col==3){
                    if ( ((tiles.get(i).getCoords().getX()== col-1) && tiles.get(i).getCoords().getY()==lig )  ||
                            ((tiles.get(i).getCoords().getY()== lig +1) && (tiles.get(i).getCoords().getX()== col))||
                            ((tiles.get(i).getCoords().getY()== lig ) && (tiles.get(i).getCoords().getX()== col+1))  ){

                            Liste.add(tiles.get(i));
                       
                    }                   
                }
            }else if(lig==5) {   
                if (col==2||col==3){                        
                    if ( ((tiles.get(i).getCoords().getX()== col-1) && tiles.get(i).getCoords().getY()==lig )  
                            ||((tiles.get(i).getCoords().getY()== lig -1) && (tiles.get(i).getCoords().getX()== col)) 
                            ||((tiles.get(i).getCoords().getY()== lig ) && (tiles.get(i).getCoords().getX()== col+1)) ){

                            Liste.add(tiles.get(i));
                      
                    }                   
                }                    
            }else{  // lig !=0 && lig!=5 && col!=0 && col!=5 
                    if (((tiles.get(i).getCoords().getX()== col +1 )&&  tiles.get(i).getCoords().getY()== lig )
                            || ((tiles.get(i).getCoords().getX()== col -1)&&tiles.get(i).getCoords().getY()== lig) 
                            || ((tiles.get(i).getCoords().getY()== lig +1)&&tiles.get(i).getCoords().getX()== col) 
                            ||((tiles.get(i).getCoords().getY()== lig -1)&&tiles.get(i).getCoords().getX()== col ) ){

                            Liste.add(tiles.get(i));
                   
                    }
                }      
            }       


//            for(Tile t: Liste){
//                t.show();
//            }
            
            System.out.println();
            System.out.println();
            System.out.println();
            return Liste;
    }
    
    
    public ArrayList<Tile> getDiagTile(Tile currentTile) {

        ArrayList<Tile> Liste = new ArrayList();
        int col = currentTile.getCoords().getX();
        int lig = currentTile.getCoords().getY();
        for(int i=0; i<tiles.size();i++) {//boucle sur la taille de la grille
            if(col==0){
            // Verifie que la tuile positionCourante ne se situe pas sur les bord de la grille
            // Cad lig !=0 && lig!=5 && col!=0 && col!=5 
            // Sinon gére les exception
                if (lig==2||lig==3){
                    if ( ((tiles.get(i).getCoords().getX()== col+ 1) && tiles.get(i).getCoords().getY()==lig+1 )  
                            ||((tiles.get(i).getCoords().getY()== lig -1) && (tiles.get(i).getCoords().getX()== col+1))  ){
                        // Verifie si la tuile "tuiles.get(i)" est diagonale a la tuile positionCourante


                            Liste.add(tiles.get(i));
                                               
                    }
                }
            }else if(col==5) {     
                if (lig==2 || lig==3){
                    if ( ((tiles.get(i).getCoords().getX()== col- 1) && tiles.get(i).getCoords().getY()==lig-1 )  
                            ||((tiles.get(i).getCoords().getY()== lig +1) && (tiles.get(i).getCoords().getX()== col-1))  ){
                        
                            Liste.add(tiles.get(i));
                                               
                    }
                }
            }else if(lig==0) { 
                if (col==2 || col==3){
                    if ( ((tiles.get(i).getCoords().getX()== col+1 ) && tiles.get(i).getCoords().getY()==lig+1 )  
                            ||((tiles.get(i).getCoords().getY()== lig+1 ) && (tiles.get(i).getCoords().getX()== col))  ){

                            Liste.add(tiles.get(i));
                        
                    }                  
                }
            }else if(lig==5) {  
                if (col==2 || col==3){
                    if ( ((tiles.get(i).getCoords().getX()== col+ 1) && tiles.get(i).getCoords().getY()==lig-1 )  
                            ||((tiles.get(i).getCoords().getY()== lig -1) && (tiles.get(i).getCoords().getX()== col-1))
                            ||((tiles.get(i).getCoords().getX()== col+ 1) && tiles.get(i).getCoords().getY()==lig-1 )   ){

                            Liste.add(tiles.get(i));
                                                
                    }
                }
            }else{ // lig !=0 && lig!=5 && col!=0 && col!=5 
                if (((tiles.get(i).getCoords().getX()== col +1 )&&  tiles.get(i).getCoords().getY()== lig+1 )
                        || ((tiles.get(i).getCoords().getX()== col +1)&&tiles.get(i).getCoords().getY()== lig-1) 
                        || ((tiles.get(i).getCoords().getY()== lig +1)&&tiles.get(i).getCoords().getX()== col-1) 
                        ||((tiles.get(i).getCoords().getY()== lig -1)&&tiles.get(i).getCoords().getX()== col-1 ) ){

                        Liste.add(tiles.get(i));
                     
                }
            }      
        }                
        for(Tile t: Liste){
            t.show();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        return Liste;
    }

    
}