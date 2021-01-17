
/*
 *  RoomArray
 *  Written by: Em Powers
 *
 * Description:
 * RoomArray is a class that represents an array of rooms in the dungeon
 * It contains public and private data fields, constructors,
 * and getters/setters.
 *
 */

public class RoomArray {

    // Initialize our 2d array to represent the room map.

    public MapObject[][] roomArray;

    /*
     *  RoomArray
     *
     * A default RoomArray constructor without parameters. Represents
     * the default state of a RoomArray object.
     *
     */

    public RoomArray(){

        // Initialize the 2d map array and create MapObjects to place

        roomArray = new MapObject[6][6];

        roomArray[0][0] = new MapObject("E", true, false, false, 0, "", false);
        roomArray[0][0].setMapDescriptor("After, you make it out through the back exit. "
                +'\n' + "Warming sunlight greets the arrival of one Brad S."
                +'\n' + "You Survived." +
                '\n' + "Thank you for playing!");

        roomArray[0][1] = new MapObject("h",false, false, true, 1, "", false);
        roomArray[0][1].setMapDescriptor("You've almost made it out. Go left, or right if you want to return.");

        roomArray[1][1] = new MapObject("3",true, false, false, 0, "", true);
        roomArray[1][1].setMapDescriptor("Allegedly a break room, but the only things "
                + "broken here are the coffee and soft-serve machines." +
                '\n' + "The poster on the wall gives you a list of rules: " +
                '\n' + "1. Greet each customer with a smile and a wave." +
                '\n' + "2. We are entitled to your time. You must be on standby at any time." +
                '\n' + "3. Injury or death is not at our liability." +
                '\n' + "4. Breaks limited to 15 min every 8 hours." +
                '\n' + "You can go: " + '\n' +
                "Up through the back entrance" + '\n' +
                "Back down.");

        roomArray[1][3] = new MapObject("4",true, false, true, 1, "", true);
        roomArray[1][3].setMapDescriptor("13 seats surround a long table. More balloons and "
                + '\n' + "posters line this area, depicting old parties in Mr. Juicy's"
                + '\n' + "This area is lit only by flourescent bulbs from above."
                + '\n' + "You can only go back down.");

                roomArray[1][5] = new MapObject("6",true, false, true, 2, "", false);
        roomArray[1][5].setMapDescriptor("A blast of chilled air greets you as you enter the walk-in freezer. "
                + '\n' + "Despite the fresh food served everyday! promises, everything Mr. Juicy serves"
                + '\n' + "either comes from in here or is a rush order from Guillory's Bakery."
                + '\n' + "The food isn't great, in short." + '\n' +
                "You can only go down from here.");

        roomArray[2][0] = new MapObject("2",true, false, true, 1, "", false);
        roomArray[2][0].setMapDescriptor("A supply closet filled with all manner of "
                + '\n' + "OSHA hazards. Brooms lie dilapidated on the ground, "
                + '\n' + "and the actual cleaning products do not appear to "
                + '\n' + "have been utilized for some time. On the shelves are"
                + '\n' + "employee-related materials, such as old pay stubs and"
                + '\n' + "health inspection forms."
                +  '\n' + "It seems you killed the prior health inspector."
                + '\n' + "You can only go back into the hall again.");

        roomArray[2][1] = new MapObject("h",false, false, false, 0, "", true);
        roomArray[2][1].setMapDescriptor("You proceed down the hallway. It feels as if " +
                "the eyes of the establishment " + '\n' + "are upon you. " +
                "You may either turn left to enter the supply closet," +
                '\n' + " go up into the breakroom or back down.");

        roomArray[2][2] = new MapObject("h",false, false, true, 1, "", false);
        roomArray[2][2].setMapDescriptor("You trek up the hallway to the party room."
                + '\n' + "You can either go up or back down, to the entertainment area.");

        roomArray[2][5] = new MapObject("6",true, false, false, 0, "", false);
        roomArray[2][5].setMapDescriptor("Surrounding you is the glint of industrial cookery "
                + "machines combined with surfaces that haven't seen grill cleaner since "
                + '\n' + "the 80s. The lights are on despite nobody being in the room, but... "
                + '\n' + "You hear the sound of frying and grilling. Probably best not to"
                + '\n' + "consider that. From here, you can either go up to the pantry or back down. ");

        roomArray[3][0] = new MapObject("h",false, false, false, 0, "", true);
        roomArray[3][0].setMapDescriptor("A dim hallway matches you dim life prospects. "
                + '\n' + "You can either go up to the supply closet or back right once more.");

                roomArray[3][1] = new MapObject("1",true, false, true, 1, "", true);
        roomArray[3][1].setMapDescriptor("You move closer to the stage and come face-to-face "
                + " with the mascot suit depicting Chunks, the Party Cat."
                + '\n' + "You had to spend many birthdays donning the costume "
                + "in front of screaming partygoers. " + '\n'
                + "You can either go back the way you were, or left towards the "
                + '\n' + "dressing room. The stage has an evil energy about here.");

        roomArray[3][2] = new MapObject("1",true, false, false, 0, "", false);
        roomArray[3][2].setMapDescriptor("The party area lies within these doors. Around you, balloons float "
                + '\n' + " somehow menacingly. Old grotty carpeting scrunches under"
                + '\n' + "patterned with 80s squiggles and squares. A few arcade"
                + '\n' + "machines stand at the ready to take your money. A tinny song plays "
                + '\n' + " overhead and sets an interesting energy."
                + '\n' + "Up ahead is the dining area itself. "
                + '\n' + "A dilapidated stage hovers to the left, cloaked in shadows.");

        roomArray[3][4] = new MapObject("5",true, false, false, 0, "", false);
        roomArray[3][4].setMapDescriptor("The arcade buzzes and hums inside here. A ticketing machine "
                + "is off to one side, ready to take your money. " +
                '\n' + "Several rows of games are here, including WacMan, Sea Invaders, "
                + "table tennis, and other classics. You can only go back down from here.");

        roomArray[3][5] = new MapObject("h",false, false, false, 0, "", false);
        roomArray[3][5].setMapDescriptor("The smell of grease grows almost overpowering. It makes you"
                + '\n' + "want to keel over. A heavy steel door stands between you and the "
                + '\n' + "driving force behind hundreds of spiked cholesterol levels."
                + '\n' + "You can either go up or down.");

        roomArray[4][2] = new MapObject("h",false, false, false, 0, "", false);
        roomArray[4][2].setMapDescriptor("The doorway creaks as you enter. An overpowering "
                + '\n' + "reek of weeks-old frying oil and greasy burgers hits you." + '\n' +
                "You can go up through a pair of double doors, "
                + '\n' + "with a Dining Room sign and a logo of a "
                + "dead-eyed cat mascot. " + '\n' + "That's Chunks, your mortal enemy."
                + '\n' + "You can also go right, further into the bowels of Mr. Juicy.");

        roomArray[4][3] = new MapObject("h",false, false, true, 1, "", true);
        roomArray[4][3].setMapDescriptor("You venture down the hallway. There's a red spill "
                + '\n' + " with a tipped-over warning sign to the side. " +
                '\n' + "Your face is plastered over by another employee of the month "
                + '\n' + "accolade. You can only go further right or back left.");

        roomArray[4][4] = new MapObject("h",false, false, false, 0, "", false);
        roomArray[4][4].setMapDescriptor("The eyes of those depicted in old polaroids stare "
                + " at you quietly." + '\n' + "You can either go up for the arcade or right.");

        roomArray[4][5] = new MapObject("h",false, false, false, 0, "", true);
        roomArray[4][5].setMapDescriptor("You've reached the end of this hallway. You can go "
                + '\n' + "up towards the kitchen or back left the way you came.");

        roomArray[5][2] = new MapObject("e",false, false, false, 0, "", false);
        roomArray[5][2].setMapDescriptor("You cannot hope to leave again. Try again.");

        roomArray[0][2] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[0][3] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[0][4] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[0][5] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[1][0] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[1][3] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[1][4] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[2][3] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[2][4] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[3][3] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[4][0] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[4][1] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[5][0] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[5][1] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[5][3] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[5][4] = new MapObject("w",false, false, false, 0, "", false);
        roomArray[5][5] = new MapObject("w",false, false, false, 0, "", false);
    }

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
     *  getRoom
     *  @param vertical, horizontal
     *  @return MapObject
     *
     * Returns a MapObject at the position passed by
     * the current vertical and horizontal player pos.
     *
     */

    public MapObject getRoom(int vertical, int horizontal) {
        if (vertical < roomArray.length && horizontal < roomArray.length) {
            return roomArray[vertical][horizontal];
        }
        return null;
    }

    /*
     *  printRoom
     *  @param vertical, horizontal
     *
     * Print out the present room passed in by vertical, horizontal playerPosition.
     *
     */

    public void printRoom(int vertical, int horizontal){
        if(vertical >= 0 && vertical < 6 && horizontal >= 0 && horizontal < 6) {
            if(roomArray[vertical][horizontal] != null) {
                System.out.println(roomArray[vertical][horizontal].getMapDescriptor());
            }
        }
    }

}
