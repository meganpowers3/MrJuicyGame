
/*
 *  Enemy
 *  Written by: Em Powers
 *
 * Description:
 * Enemy is a class that represents a dungeon's enemy
 * It contains public and private data fields, constructors,
 * and getters/setters.
 *
 */

import java.util.Random;

public class Enemy {

    public String name = "";
    public int maxHP = -1;
    public int currentHP = -1;
    public int minAttack = -1;
    public int maxAttack = -1;
    public String attackOne = "", attackTwo = "", attackThree = "", attackFour = "";
    public int attackOneDmg = -1, attackTwoDmg = -1, attackThreeDmg = -1, attackFourDmg = -1;

    /*
     * A default constructor without params.
     *
     */

    public Enemy(){

    }

    /*
     * Enemy
     * @params name, maxHP, currentHP, a1, a2, a3, a4, minAttack, maxAttack
     *
     * Parameterized constructor to make an enemy.
     *
     */

    public Enemy(String name, int maxHP, int currentHP, String a1, String a2, String a3, String a4, int minAttack, int maxAttack){
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.attackOne = a1;
        this.attackTwo = a2;
        this.attackThree = a3;
        this.attackFour = a4;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
    }

    /*
     * setHP
     * @param hp
     *
     * Setter for enemy hp.
     *
     */

    public void setHP(int hp){
        this.currentHP = hp;
    }

    /*
     * getHP
     * @return hp
     *
     * Getter for curr enemy hp.
     *
     */

    public int getHP(){
        return currentHP;
    }

    /*
     * getHP
     * @return hp
     *
     * Getter for total enemy hp.
     *
     */

    public int getMaxHP(){
        return maxHP;
    }

    /**
     *	 int takeDmg
     *   @params min, max
     *   @return int
     *
     *	 takeDmg subtracts the damage done from the enemy's HP and returns
     *	 their present HP.
     *
     */

    public int takeDamage(int dmg) {
        return currentHP-dmg;
    }

    /**
     *	 itemEffect
     *   @params item
     *
     *	 Reduces the enemy's HP by listed value.
     *
     */

    public int itemEffect(String item){

        int dmg = 0;
        if(item.equals("Bangsnap")){
            dmg = 4;
        }

        if(item.equals("Broom")){
            dmg = 10;
        }

        return currentHP - dmg;
    }

    /**
     *	 String getAttack
     *	 @return: string
     *
     *	 getAttack is a method that makes an array with the names of the enemy attacks
     *	 (passes in an array as a parameter in the actual version), and returns
     *	 a random attack name.
     *
     */

    public String getAttack(){
        String[] attack = {attackOne, attackTwo, attackThree, attackFour};
        Random rando = new Random();
        int ranNum = rando.nextInt(attack.length);
        return attack[ranNum];
    }

    /**
     *	 getName
     *
     *	 Returns the enemy's name.
     *
     */

    public String getName(){
        return this.name;
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

    public int calculateDmg(int min, int max) {
        int range = max-min+1;
        return (int) ((Math.random() * (max - min)) + min);
    }

    /*
     * getMinDmg
     * @return minAttack
     *
     * Getter for min enemy dmg.
     *
     */

    public int getMinDmg(){
        return this.minAttack;
    }

    /*
     * getMinDmg
     * @return minAttack
     *
     * Getter for max enemy dmg.
     *
     */

    public int getMaxDmg(){
        return this.maxAttack;
    }




}
