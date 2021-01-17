/*
 *  Assignment Milestone 2
 *  Description: Milestone 2 is a dungeon-crawler type game that is a text-based
 *              adventure. It takes place in a dilapidated fast food restaurant
 *              where the player has to input commands to navigate between rooms.
 *  Name: Em Powers
 *  ID: 920734539
 *  Class: CSC 211-02
 *  Semester: Fall 2020
 */

// We need to ask the user for movement so we import the util package.
import java.util.*;

public class DungeonExploration {

    public static void main(String[] args){

        /*
         * Setting up the variables that we'll use.
         * We need to set the user's starting position in a 2D array
         * so that the program can use this information to navigate.
         * If I was programming not according to lab specs (i.e. final ver)
         * I'd make a class for the player and getters/setters for their
         * position, along with a method that updates their position.
         */
        Scanner sc = new Scanner(System.in);
        String userChoice = "N/A";

        Player brad = new Player("Brad", 20, 20, 2, 5, 5,
        2);
        RoomArray rooms = new RoomArray();
        MapObject currMap = new MapObject();
        Enemy randomEnemy = new Enemy();
        EnemyArray enemyArray = new EnemyArray();
        CombatLoop combat = new CombatLoop();

        /*
         * Establishing if the user has reached the E square.
         */

        boolean hasNavigated = false;

        /*
         * The map for our game is represented as a 2D array that
         * can be navigated by adding and subtracting from the
         * current position.
         */
        String map[][] =
                {
                        { "E", "h", "w", "w", "w", "w" },
                        { "w", "3", "4", "w", "w", "6" },
                        { "2", "h", "h", "w", "w", "6" },
                        { "h", "1", "1", "w", "5", "h" },
                        { "w", "w", "h", "h", "h", "h" },
                        { "w", "w", "e", "w", "w", "w" },

                };

        /*
         * Some flavour text to establish the world. nextMove is a variable
         * that establishes if where we want to move is valid before going there.
         */

        System.out.println("_______________________________________" + '\n' + '\n' +
                            "Mr. Juicy's: an RPG" + '\n' +
                        "_______________________________________" + '\n' + '\n');

        System.out.println("In front of you stands your formidable old nemesis." +
                '\n' + "Mr. Juicy's, the neighborhood greasy spoon. Halogen lights " +
                "flicker sadly within, a familiar sight." + '\n'
                + "As a delivery boy, you're low on the pecking order." + '\n'
                + "When you got the summons to investigate some paranormal " +
                "haunting, you knew you had no choice. Nothing but the " + '\n'
                + "establishment standing between you and your next paycheck." + '\n' + '\n'
                + "1. Navigate by typing up, down, left, right. " + '\n'
                + "2. Print map using p. " + '\n' +
                "3. Type help for help." + '\n' +
                "4. Enter name of item to use item." + '\n');

        int nextMove = -1;

        /*
         * Setting up our main movement loop.
         */

        while(hasNavigated == false){

            /*
             * Depending on what the user choice is, we can establish a
             * call to the corresponding method to print out where the
             * user is in the map now.
             */

            userChoice = sc.nextLine();

            /*
             * Entering help will print out the menu.
             */

            if(userChoice.equals("help")){
                printMenu(rooms, brad.getVerticalPosition(), brad.getHorizontalPosition());
            }

            if(userChoice.equals("p")){
                printMap(rooms, brad.getVerticalPosition(), brad.getHorizontalPosition());
            }

            /*
             * If we are not in a hallway square, we need to check the
             * validity of our next move. We do this through if-checks and
             * updating the user's position in the array. If it's
             * not valid, we inform that to the user.
             */

                switch(userChoice){
                    case("up"):
                        if (currMap.canMove(brad.getVerticalPosition() - 1, brad.getHorizontalPosition())){
                            brad.moveDirection("up");
                        }else{
                            System.out.println("Invalid move. Try again.");
                        }
                        break;
                    case("down"):
                        if (currMap.canMove(brad.getVerticalPosition() + 1, brad.getHorizontalPosition())){
                            brad.moveDirection("down");
                        }else{
                            System.out.println("Invalid move. Try again.");
                        }
                        break;
                    case("left"):
                        if (currMap.canMove(brad.getVerticalPosition(), brad.getHorizontalPosition() - 1)){
                            brad.moveDirection("left");
                        }else{
                            System.out.println("Invalid move. Try again.");
                        }
                        break;
                    case("right"):
                        if (currMap.canMove(brad.getVerticalPosition(), brad.getHorizontalPosition() + 1)){
                            brad.moveDirection("right");
                        }else{
                            System.out.println("Invalid move. Try again.");
                        }
                        break;
                    default:
                        System.out.println("Invalid move. Try again.");
                }

                if(currMap.canMove(brad.getVerticalPosition(), brad.getHorizontalPosition())) {

                    if(rooms.getRoom(brad.getVerticalPosition(), brad.getHorizontalPosition()).getCombat() == true){
                        randomEnemy = enemyArray.getEnemy(brad.getVerticalPosition(), brad.getHorizontalPosition());
                        for(int i = 0; i < rooms.getRoom(brad.getVerticalPosition(), brad.getHorizontalPosition()).getEnemies(); i++) {
                           int combatResult = combat.engageCombat(brad, randomEnemy);

                           if(combatResult == -1){
                               hasNavigated = true;
                               System.out.println("Game Over.");
                           }
                        }
                        rooms.getRoom(brad.getVerticalPosition(), brad.getHorizontalPosition()).setCombat(false);
                    }

                    if(rooms.getRoom(brad.getVerticalPosition(), brad.getHorizontalPosition()).getItem() == true){
                        brad.setItem(brad.getVerticalPosition(), brad.getHorizontalPosition());
                        System.out.println('\n');
                        System.out.println("You've got an item! " + brad.getItem(brad.getVerticalPosition(), brad.getHorizontalPosition()));
                        brad.printFlavorText(brad.getVerticalPosition(), brad.getHorizontalPosition());
                        System.out.println('\n');
                        rooms.getRoom(brad.getVerticalPosition(), brad.getHorizontalPosition()).setItem(false);
                    }

                    rooms.printRoom(brad.getVerticalPosition(), brad.getHorizontalPosition());

                }else if(!currMap.canMove(brad.getVerticalPosition(), brad.getHorizontalPosition())){
                    System.out.println( '\n' + "Invalid move. Try again." + '\n');
                }

            /*
             * Seeing if we've reached the exit yet.
             */

            if(currMap.returnLetter(brad.getVerticalPosition(), brad.getHorizontalPosition()).equals("E")){
                hasNavigated = true;
            }

        }

    }

    /*
     * printMenu
     * @param map, vertical, horizontal
     *
     * printMenu takes in the current user position
     * and prints out the menu, giving the user
     * a description of what their valid options
     * are when it comes to the current game.
     *
     *
     */

    public static void printMenu(RoomArray map, int vertical, int horizontal){
        String currMap[][] =
                {
                        { "E", "h", "w", "w", "w", "w" },
                        { "w", "3", "4", "w", "w", "6" },
                        { "2", "h", "h", "w", "w", "6" },
                        { "h", "1", "1", "w", "5", "h" },
                        { "w", "w", "h", "h", "h", "h" },
                        { "w", "w", "e", "w", "w", "w" },

                };
        // We need to use ASCII to display coordinates instead of potentially
        // invalid renders for the user
        System.out.println("Welcome to Mr. Juicy's. Your objective is to clear up"
        + '\n' + "the alleged supernatural forces lurking inside your place of "
        + '\n' + "employment at the threat of being cut loose." +
        '\n' + "Navigate by typing up, down, left, right." +
        '\n' + "Type p to pull up the current map." +
        '\n' + "\u25A0" + " means a wall, " + "\u25A1" + " means a hallway.");
        map.printRoom(vertical, horizontal);
    }

    /*
     * printMap
     * @param map, vertical, horizontal
     *
     * printMap takes in the current user position
     * and prints out the map, updating the
     * position to show where the user is at the moment.
     *
     */

    public static void printMap(RoomArray currMap, int vertical, int horizontal){
        String tempMap[][] =
                {
                        { "E", "h", "w", "w", "w", "w" },
                        { "w", "3", "4", "w", "w", "6" },
                        { "2", "h", "h", "w", "w", "6" },
                        { "h", "1", "1", "w", "5", "h" },
                        { "w", "w", "h", "h", "h", "h" },
                        { "w", "w", "e", "w", "w", "w" },

                };

        tempMap[vertical][horizontal] = "P";

        for(int i = 0; i < tempMap.length; i++){
            for(int j = 0; j < tempMap.length; j++){
                if (tempMap[i][j].equals("w")) {
                    System.out.print("\u25A0");
                }
                if (tempMap[i][j].equals("h")) {
                    System.out.print("\u25A1");
                }
                if (!tempMap[i][j].equals("h") && !tempMap[i][j].equals("w")) {
                    System.out.print(tempMap[i][j]);
                }
                System.out.print("  ");
            }
            System.out.println();
            System.out.println();
        }

        currMap.printRoom(vertical, horizontal);
    }

}
