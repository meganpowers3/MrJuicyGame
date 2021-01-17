
/*
 *  MapObject
 *  Written by: Em Powers
 *
 * Description:
 * MapObject is a class that represents a room
 * It contains public and private data fields, constructors,
 * and getters/setters.
 *
 */

public class MapObject {

    public String mapAddress = "";
    public boolean mapType = false;
    public boolean playerIn = false;
    public boolean combat = false;
    public boolean item = false;
    public int numEnemies = -1;
    public String mapDescriptor = "";

    /*
     *  MapObject
     *
     * Empty default constructor for mapobject
     *
     */

    public MapObject(){

    }

    /*
     *  MapObject
     * @params mapAddress, mapType, playerIn, combat, numEnemies, mapDescriptor
     *
     * Constructor with passed params for mapObject.
     *
     */

    public MapObject(String mapAddress, boolean mapType, boolean playerIn, boolean combat, int numEnemies,
                     String mapDescriptor, boolean item){
        this.mapAddress = mapAddress;
        this.mapType = mapType;
        this.playerIn = playerIn;
        this.combat = combat;
        this.numEnemies = numEnemies;
        this.mapDescriptor = mapDescriptor;
        this.item = item;
    }

    /*
     *
     * map copy for the current functions
     *
     */

    public String map[][] =
            {
                    { "E", "h", "w", "w", "w", "w" },
                    { "w", "3", "4", "w", "w", "6" },
                    { "2", "h", "h", "w", "w", "6" },
                    { "h", "1", "1", "w", "5", "h" },
                    { "w", "w", "h", "h", "h", "h" },
                    { "w", "w", "e", "w", "w", "w" },

            };

    /**
     *	 canMove
     *   @params verticalMove, horizontalMove
     *   @return boolean
     *
     *	 canMove is a function that checks if a
     *	 motion in the map is valid for the player.
     *
     */

    boolean canMove(int verticalMove, int horizontalMove){
        if(map[verticalMove][horizontalMove].equals("w")){
            return false;
        }
        if(horizontalMove < 6 && horizontalMove >= 0 ) {
            return true;
        }
        if(verticalMove < 6 && verticalMove >= 0) {
            return true;
        }
        return false;
    }

    /**
     *	 setMapType
     *   @params map
     *
     *	 Setter for the square on a map.
     *
     */

    public void setMapType(boolean map){
        this.mapType = map;
    }

    /**
     *	 getMapType
     *   @return mapType
     *
     *	 Getter for the square on a map.
     *
     */

    public boolean getMapType(){
        return this.mapType;
    }

    /**
     *	 setPlayerIn
     *   @params in
     *
     *	 Setter for whether the player is in a room
     *
     */

    public void setPlayerIn(boolean in){
        this.playerIn = in;
    }

    /**
     *	 getPlayerIn
     *   @return playerIn
     *
     *	 Getter for whether the player is in a room
     *
     */

    public boolean getPlayerIn(){
        return this.playerIn;
    }

    /**
     *	 setCombat
     *   @params combat
     *
     *	 Setter for if there's combat in a room.
     *
     */

    public void setCombat(boolean combat){
        this.combat= combat;
    }

    /**
     *	 getCombat
     *   @return combat
     *
     *	 Getter for if there's combat in a room.
     *
     */

    public boolean getCombat(){
        return this.combat;
    }

    /**
     *	 setEnemies
     *   @params enemies
     *
     *	 Setter for if there's enemies in a room.
     *
     */

    public void setEnemies(int enemies){
        this.numEnemies = enemies;
    }

    /**
     *	 getEnemies
     *   @params enemies
     *
     *	 Getter for if there's enemies in a room.
     *
     */

    public int getEnemies(){
        return this.numEnemies;
    }

    /**
     *	 setItem
     *   @params enemies
     *
     *	 Setter for if there's an item in a room.
     *
     */

    public void setItem(boolean item){
        this.item = item;
    }

    /**
     *	 get|Item
     *   @params enemies
     *
     *	 Getter for if there's an item in a room.
     *
     */

    public boolean getItem(){
        return this.item;
    }

    /**
     *	 setMapDescriptor
     *   @params descriptor
     *
     *	 Setter for a map description.
     *
     */

    public void setMapDescriptor(String descriptor){
        this.mapDescriptor = descriptor;
    }

    /**
     *	 getMapDescriptor
     *   @return descriptor
     *
     *	 Getter for curr map description.
     *
     */

    public String getMapDescriptor(){
        return this.mapDescriptor;
    }

    /**
     *	 printDescription
     *
     *	 Prints the description of the curr map.
     *
     */

    public void printDescription(){
        System.out.println(mapDescriptor);
    }

    /**
     *	 returnLetter
     *   @params horizontal, vertical
     *   @return String
     *
     *	 Returns the current letter value of an arrayEntry.
     *
     */

    public String returnLetter(int horizontal, int vertical){
        if(vertical >= 0 && vertical < 6 && horizontal >= 0 && horizontal < 6) {
            return map[horizontal][vertical];
        }
        return "";
    }

}
