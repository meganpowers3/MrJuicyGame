/*
 * CombatLoop
 * Description: Combat Loop is a demonstration of the combat loop in the term project. This is a
 *              turn-based system that swaps between the player and enemy, allowing the user to swap.
 * Name: Em Powers
 * ID: 920734539
 * Class: CSC 211-02
 * Semester: Fall 2020
 */

import java.util.*;

public class CombatLoop {
    /**
     * We need to represent the stats of our player and enemy characters.
     * We have a current and maximum HP, that keeps track of the health bars of
     * both of the characters. The enemy used here is just a sample character but
     * would be one of several determined by methods later on.
     */

    public int engageCombat (Player player1, Enemy enemy1){

        Scanner sc = new Scanner(System.in);

        /**
         * Here, we need to determine how to swap between turns. Our while-loop will
         * continue as long as the gameOver variable is not flagged as stopping the
         * loop.
         */
        int turn = 1, currTurn = 1, gameOver = 1;

        while (gameOver >= 1) {
            String currPlayer = player1.getName();

            /**
             *	Here, we calculate whose turn it is based on the remainder that the
             *  modulus operator will return. Using an iterator ensures that
             *  both players will take equal turns as the pattern is
             *  odd-even-odd-even-etc...
             */

            currTurn = turn % 2;

            /*
             * In the actual game, we will have varying flavour text we can fetch from
             * an array. In this situation, we can use this as a demo with our enemy.
             * The game quits and sets the while-flag to 1 to stop our loop.
             */
            if (player1.getHP() <= 0) {
                System.out.println("You've been juiced. Your replacement will appear summarily.");
                gameOver = -1;
            }
            if (enemy1.getHP() <= 0) {
                System.out.println("The thing that was once " + enemy1.getName() + " collapses upon the floor.");
                System.out.println("Its featureless corpse sinks through the greasy floor. " +
                        "It makes you glad you don't eat the food they sell in here.");
                System.out.println("The room is empty, and so is your tip jar.");
                System.out.println("You go forth.");
                gameOver = 0;
            }

            /**
             * Swapping will entail whose turn it is - i.e. whether there is a
             * remainder (odd) or not (even).
             */

            if (currTurn == 0) {
                currPlayer = enemy1.getName();
            } else {
                currPlayer = player1.getName();
            }

            if (gameOver >= 1) {

                /**
                 *	We just print out health bars for both of our players.
                 * This will vary for the enemy based on stats in the final
                 * version of our combat loop.
                 */

                printHealthBar(player1.getHP(), player1.getMaxHP(), player1.getName());
                printHealthBar(enemy1.getHP(), enemy1.getMaxHP(), enemy1.getName());

                System.out.printf("It is %s's turn.\n", currPlayer.toUpperCase());

                /**
                 *	Again, we use our flag variable to indicate the player's turn.
                 *  We're prompting the user to choose a move based off of their
                 *  preferences.
                 */

                if (turn % 2 != 0) {
                    System.out.println("Choose an action.");
                    player1.printAbilities();
                    int n = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Use item? Print name of item or no if not");
                    for(int i = 0; i < player1.getItemArray().length; i++){
                        System.out.println(i + ". " + player1.getItemIndex(i));
                    }
                    String choice = sc.nextLine();

                    enemy1.takeDamage(enemy1.itemEffect(choice));

                    player1.useItem(choice);

                    /**
                     *	 Here, we see that turn-wise, one or the other takes damage.
                     *	 This will be based off of abilities/modifiers in the
                     *	 actual game, but for now, some temp modifiers will suffice.
                     */
                    enemy1.setHP(enemy1.takeDamage(player1.useAbility(player1.getName(), n)));
                } else if (turn % 2 == 0) {
                    System.out.println(enemy1.getMinDmg() + " " + enemy1.getMaxDmg());
                    int dmg = enemy1.calculateDmg(enemy1.getMinDmg(), enemy1.getMaxDmg());
                    System.out.printf("%s uses %s. %s sustains %d damage!\n", enemy1.getName().toUpperCase(), enemy1.getAttack(), player1.getName().toUpperCase(), dmg);
                    player1.setHP(player1.takeDamage(dmg));
                }
            }
            turn++;
        }
        return gameOver;
    }

    /**
     *	 void printHealthbar
     *   @params currHp, maxHp, name
     *
     *	 printHealthBar prints out the player/enemy's health bar based off
     *	 the name passed in as parameter, and calculates the remaining Hp based
     *	 off of the total and current Hp, printing out + to signify
     *	 damage left. Lost HP is printed by subtracting current Hp from the calculated amount.
     *
     */

    public static void printHealthBar(int currHp, int maxHp, String name) {
        System.out.println('\n' + name.toUpperCase());
        System.out.print("[ ");
        int remainingHp = maxHp - currHp;
        for (int i = 0; i < currHp; i++) {
            System.out.print("+");
        }
        for(int i = 0; i < remainingHp; i++){
            System.out.print("-");
        }
        System.out.print(" ]");
    }
}