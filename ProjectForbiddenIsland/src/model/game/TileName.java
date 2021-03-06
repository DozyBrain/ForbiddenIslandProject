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
    TEMPLE_OF_THE_MOON("Temple of the Moon"),
    BRONZE_GATE("Bronze Gate"),
    BREAKERS_BRIDGE("Breakers Bridge"),
    CLIFFS_OF_ABANDON("Cliffs of Abandon"),
    HOWLING_GARDEN("Howling Garden");
    
    private String name;

    private TileName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    

    public static TileName getTileName(int t){
        TileName tile = null;
        int i=0;
        for (TileName ti : TileName.values()){
            System.out.println(i);
            if(t==i){
                tile = ti;
            }
        }
        return tile;
    }

    
    
}
