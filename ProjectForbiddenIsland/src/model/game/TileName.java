package model.game;

public enum TileName {
    CAVE_OF_EMBERS("Cave of Embers"),
    OBSERVATORY("Observatory"),
    SILVER_GATE("Silver Gate"),
    IRON_GATE("Iron Gate"),
    PHANTOM_ROCK("Phantom Rock"),
    TEMPLE_OF_THE_SUN("Temple of the Sun"),
    WATCHTOWER("Watchtower"),
    CORAL_PALACE("Coral Palace"),
    WHISPERING_GARDEN("Whispering Garden"),
    CRIMSON_FOREST("Crimson Forest"),
    FOOLS_LANDING("Fools' Landing"),
    DUNES_OF_DECEPTION("Dunes of Deception"),
    GOLD_GATE("Gold Gate"),
    COPPER_GATE("Copper Gate"),
    LOST_LAGOON("Lost Lagoon"),
    CAVE_OF_SHADOWS("Cave of Shadows"),
    TIDAL_PALACE("Tidal Palace"),
    MISTY_MARSH("Misty Marsh"),
    TWILIGHT_HOLLOW("Twilight Hollow"),
    TEMPLE_OF_THE_MTIDAL_PALACEOON("Temple of the Moon"),
    BRONZE_GATE("Bronze Gate"),
    BREAKERS_BRIDGE("Breakers Bridge"),
    CLIFFS_OF_ABANDON("Cliffs of Abandon"),
    HOWLING_GARDEN("Howling Garden");
    
    private String name;

    private TileName(String name) {
        this.name = name;
    }
    
    public static TileName getTileName(int t){
        if(t==1){
            return CAVE_OF_EMBERS;
        }else if(t==2){
            return OBSERVATORY;
        }else if(t==3){
            return SILVER_GATE;
        }else if(t==4){
            return IRON_GATE;
        }else if(t==5){
            return PHANTOM_ROCK;
        }else if(t==6){
            return TEMPLE_OF_THE_SUN;
        }else if(t==7){
            return WATCHTOWER;
        }else if(t==8){
            return CORAL_PALACE;
        }else if(t==9){
            return WHISPERING_GARDEN;
        }else if(t==10){
            return CRIMSON_FOREST;
        }else if(t==11){
            return FOOLS_LANDING;
        }else if(t==12){
            return DUNES_OF_DECEPTION;
        }else if(t==13){
            return GOLD_GATE;
        }else if(t==14){
            return COPPER_GATE;
        }else if(t==15){
            return LOST_LAGOON;
        }else if(t==16){
            return CAVE_OF_SHADOWS;
        }else if(t==17){
            return TIDAL_PALACE;
        }else if(t==18){
            return MISTY_MARSH;
        }else if(t==19){
            return TWILIGHT_HOLLOW;
        }else if(t==20){
            return TEMPLE_OF_THE_MTIDAL_PALACEOON;
        }else if(t==21){
            return BRONZE_GATE;
        }else if(t==22){
            return BREAKERS_BRIDGE;
        }else if(t==23){
            return CLIFFS_OF_ABANDON;
        }else {
            return HOWLING_GARDEN;
        }
    }
    
    
}
