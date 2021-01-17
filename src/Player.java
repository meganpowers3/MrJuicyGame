
/*
 *  Player
 *  Written by: Em Powers
 *
 * Description:
 * Player is a class that represents a player character.
 * It contains public and private data fields, constructors,
 * and getters/setters.
 *
 */

public class Player {
    public String name = "";
    public int horizontalPosition = -1;
    public int maxHP = -1;
    public int minAttack = -1;
    public int maxAttack = -1;
    public int verticalPosition = -1;
    public int currentHP = -1;
    public String[] itemArray = new String[7];
    public int iter = 0;

    /*
     *  Player
     *
     * Default player un-parameterized constructor.
     *
     */

    public Player(){

    }

    /*
     *  Player
     *  @params name, maxHP, currentHP, minAttack, maxAttack, verticalPosition, horizontalPosition
     *
     * Player is a parameterized constructor for the player character.
     *
     */

    public Player(String name, int maxHP, int currentHP, int minAttack, int maxAttack, int verticalPosition,
                        int horizontalPosition){
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.verticalPosition = verticalPosition;
        this.horizontalPosition = horizontalPosition;
    }

    /*
     *  getItem
     *  @param i
     *
     * Getter for item.
     *
     */

    public String getItem(int vertical, int horizontal){
        if(vertical == 4 && horizontal == 5){
            return itemArray[0];
        }
        if(vertical == 4 && horizontal == 3){
            return itemArray[1];
        }
        if(vertical == 3 && horizontal == 1){
            return itemArray[2];
        }

        if(vertical == 3 && horizontal == 0){
            return itemArray[3];
        }

        if(vertical == 2 && horizontal == 1){
            return itemArray[4];
        }

        if(vertical == 1 && horizontal == 3){
            return itemArray[5];
        }

        if(vertical == 1 && horizontal == 1){
            return itemArray[6];
        }
        return "";
    }

    /*
     *  setItem
     *  @param i
     *
     * Setter for item.
     *
     */

    public void setItem(int vertical, int horizontal){
        if(vertical == 4 && horizontal == 5){
            itemArray[0] = "Bangsnap";
        }
        if(vertical == 4 && horizontal == 3){
            itemArray[1] = "Chunks Supreme Special";
        }
        if(vertical == 3 && horizontal == 1){
            itemArray[2] = "Chunks Supreme Special";
        }

        if(vertical == 3 && horizontal == 0){
            itemArray[3] = "Party Bag";
        }

        if(vertical == 2 && horizontal == 1){
            itemArray[4] = "Party Bag";
        }

        if(vertical == 1 && horizontal == 3){
            itemArray[5] = "Broom";
        }

        if(vertical == 1 && horizontal == 1){
            itemArray[6] = "Chunks Supreme Special";
        }
    }
    /*
     *  printFlavorText
     *  @param vertical, horizontal
     *
     * Print flavor text for item array
     *
     */

    public void printFlavorText(int vertical, int horizontal){
        if(vertical == 4 && horizontal == 5){
            System.out.println("A snapping popper that deals 4 damage to an enemy");
        }
        if(vertical == 4 && horizontal == 3){
            System.out.println("It may not look edible, but it restores 5 health.");
        }
        if(vertical == 3 && horizontal == 1){
            System.out.println("It may not look edible, but it restores 5 health.");
        }

        if(vertical == 3 && horizontal == 0){
            System.out.println("Surprise! You'll get 3 health.");
        }

        if(vertical == 2 && horizontal == 1){
            System.out.println("Surprise! You'll get 3 health.");
        }

        if(vertical == 1 && horizontal == 3){
            System.out.println("Whap the enemy for 10 damage.");
        }

        if(vertical == 1 && horizontal == 1){
            System.out.println("It may not look edible, but it restores 5 health.");
        }
    }

    /**
     *	 getItemArray
     *
     *	 Returns the array of items.
     *
     */

    public String[] getItemArray(){
        return this.itemArray;
    }

    public String getItemIndex(int i){
        return this.itemArray[i];
    }

    public int getIter(){
        return iter;
    }

    /*
     *  moveDirection
     *  Written by: Em Powers
     *
     * moveDirection moves the current player character.
     *
     */

    public void moveDirection(String direction){
        switch(direction.toLowerCase()){
            case "up":
                verticalPosition--;
                break;
            case "down":
                verticalPosition++;
                break;
            case "left":
                horizontalPosition--;
                break;
            case "right":
                horizontalPosition++;
                break;
            default:
                System.out.println("Invalid Move.");
        }
    }

    /**
     *	 takeDamage
     *   @params dmg
     *
     *	 Reduces the player's HP by dmg
     *
     */

    public int takeDamage(int dmg){
        return currentHP - dmg;
    }

    /**
     *	 restoreDamage
     *   @params dmg
     *
     *	 Restores the player's HP.
     *
     */

    public void restoreDamage(int dmg){
        currentHP = currentHP + dmg;
    }

    public void useItem(String item){
        if(item.equals("Chunks Supreme Special")){
            currentHP = currentHP + 5;
        }

        if(item.equals("Party Bag")){
            currentHP = currentHP + 3;
        }
    }

    /**
     *	 getHP
     *   @return currentHP
     *
     *	 Getter for the player's HP.
     *
     */

    public int getHP(){
        return this.currentHP;
    }

    /**
     *	 setHP
     *   @param hp
     *
     *	 Setter for the player's HP.
     *
     */

    public void setHP(int hp){
        this.currentHP = hp;
    }

    /**
     *	 getMaxHP
     *   @return maxHP
     *
     *	 Getter for the player's total HP.
     *
     */

    public int getMaxHP(){
        return maxHP;
    }

    /**
     *	 getVerticalPosition
     *   @return verticalPosition
     *
     *	 Getter for the player's verticalPosition.
     *
     */

    public int getVerticalPosition(){
        return verticalPosition;
    }

    /**
     *	 getHorizontalPosition
     *   @return horizontalPosition
     *
     *	 Getter for the player's horizontalPosition.
     *
     */

    public int getHorizontalPosition(){
        return horizontalPosition;
    }

    /**
     *	 int calculateDmg
     *   @params min, max
     *   @return int
     *
     *	 calculateDmg returns the amount of damage based on the range passed as
     *	 parameters, calculating a random damage value, returning.
     *
     */

    public static int calculateDmg(int min, int max) {
        int range = max-min+1;
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     *	 int useAbility
     *   @params name, n
     *   @return int
     *
     *	 useAbility is a method that prints/returns the amount of damage done by an attack.
     *	 name refers to the player who inflicted the damage and n refers to the number of the
     *	 attack used.
     *
     */

    public int useAbility(String name, int n) {
        int dmg = 0;
        int range = 10 - 1 + 1;
        int rand = (int)(Math.random() * range) + 1;

        switch (n) {
            case 1:
                dmg = calculateDmg(minAttack-1, maxAttack-1);
                break;
            case 2:
                dmg = calculateDmg(minAttack-2, maxAttack-2);
                break;
            case 3:
                dmg = calculateDmg(minAttack+2, maxAttack+2);
                break;
            case 4:
                dmg = calculateDmg(minAttack, rand);
                break;
            default:
                System.out.println("This is above Brad's pay grade.");
                return 0;
        }

        System.out.printf("%s used %s and inflicted %d damage.\n",name.toUpperCase(), getAbility(n).toUpperCase(), dmg);
        return dmg;
    }

    /**
     *	 String getAbility
     *   @param: n
     *	 @return: string
     *
     *	 getAbility takes in the number of the attack the user wishes to utilize and
     *	 returns the name of the move.
     *
     */

    public static String getAbility(int n) {
        switch(n) {
            case 1:
                return "Fry-Pan Slap";
            case 2:
                return "Gothic Blast";
            case 3:
                return "Can You Deliver an Hour Past Closing?";
            case 4:
                return "Soda Stream";
        }

        return "???";
    }

    /**
     *	 void printAbilities
     *
     *	 printAbilities prints out the user's current moveset. In the actual
     *	 game, the user can acquire new moves, but this is used as a test.
     *
     */

    public static void printAbilities() {
        System.out.println("1. Fry-Pan Slap - Agh! The burger grease! It burns! " +
                "Your opponent will never feel clean again." +
                "\t\t3. Can You Deliver an Hour Past Closing? - " +
                "No, but I can run you over with my bike.");
        System.out.println("2. Gothic Blast - 100 Decibels of pure MCR energy " +
                "ought to give your enemy a sound thrashing" +
                "\t\t4. Soda Stream - An ice cold slushie will leave your opponent " +
                "gasping for breath." + '\n');
    }

    /**
     *	 getName
     *   @return name
     *
     *	 Getter for the player's name.
     *
     */

    public String getName(){
        return this.name;
    }

}
