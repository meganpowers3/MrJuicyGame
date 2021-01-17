
/*
 *  EnemyArray
 *  Written by: Em Powers
 *
 * Description:
 * EnemyArray is a class that represents an array of enemies in the dungeon
 * It contains public and private data fields, constructors,
 * and getters/setters.
 *
 */

import java.util.Random;

public class EnemyArray {

    public Enemy[] enemyArray;

    /*
     *  EnemyArray
     *
     * A default EnemyArray constructor without parameters. Represents
     * the default state of an EnemyArray object.
     *
     */

    public EnemyArray(){
        enemyArray = new Enemy[9];

        enemyArray[0] = new Enemy("Multi-eyed Miasma", 5, 5, "Haze", "Foggy Gaze", "Idle", "Idle", 0, 2);
        enemyArray[1] = new Enemy("Haunted Arcade Machine", 8, 8, "Coin Toss", "Ticket Spool", "Crash", "Idle", 1, 2);
        enemyArray[2] = new Enemy("Sentient Poster", 6, 6, "Horn Honk", "Party Popper", "Idle", "Idle", 1, 3);
        enemyArray[3] = new Enemy("Birthday Balloon", 4, 4, "Pop", "Wiggle", "Idle", "Idle", 1, 10);
        enemyArray[4] = new Enemy("Frozen Wraith", 10, 10, "Greasy Claw", "Frosty Gale", "Crystal-ize", "Idle", 2, 4);
        enemyArray[5] = new Enemy("Rusted Animatronic", 12, 12, "Rusted Screech", "Party Dance", "Favors Toss", "Idle", 2, 4);
        enemyArray[6] = new Enemy("Sentient Trashbag", 4, 4, "Wriggle", "Flop Around", "Idle", "Idle", 0, 3);
        enemyArray[7] = new Enemy("Chunks the Cat", 15, 15, "Pizza Chuck", "Grease Splatter", "Chunks Shake Special", "Entrap", 2, 5);
        enemyArray[8] = new Enemy("Miasma Beast", 16, 16, "Unearthly Shriek", "Beak Bash", "Gravitize", "Eldritch Gaze", 2, 6);
    }

    /*
     *  getEnemy
     *  @param vertical, horizontal
     *
     * Returns a random enemy from the array for the room the player is in.
     *
     */

    public Enemy getEnemy(int vertical, int horizontal) {
        Enemy randomEnemy;
        if (vertical == 3 && horizontal == 1) {
            randomEnemy = enemyArray[7];
        } else if (vertical == 0 && horizontal == 1) {
            randomEnemy = enemyArray[8];
        }else if(vertical == 3 && horizontal == 4){
            randomEnemy = enemyArray[1];
        }else {
            int rndm = new Random().nextInt(enemyArray.length - 2);
            randomEnemy = enemyArray[rndm];
        }
        return randomEnemy;
    }

}
