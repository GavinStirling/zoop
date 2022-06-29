/**
 * CHALLENGE
 *  MAKE A ManageCommands CLASS
 *
 *  THE OPTIONS SHOULD BE:
 *  - "All Animal Info"
 *  - "View Animals by happiness"
 *  - "Search"
 *  - "Back"
 *
 * IMPLEMENT THE run() METHOD
 *
 * IT SHOULD PRINT THE GREETING
 * IT SHOULD PRINT THE OPTIONS
 * GET THE USERS INPUT
 * - IF IT IS 1 -> PRINT A MESSAGE SAYING "ALL ANIMAL INFO"
 * - IF IT IS 2 -> PRINT A MESSAGE SAYING "ANIMAL BY HAPPINESS"
 * - IF IT IS 3 -> PRINT A MESSAGE SAYING "SEARCH"
 * - IF IT IS 4 -> SET THE NEXT COMMANDS TO -> "home"
 *
 */

public class ManageCommands extends Commands {

    public ManageCommands() {
        super("Manage", new String[]{"All Animal Info", "View Animals by Happiness", "Search", "Back"}, "manage");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        switch (userInput) {
            case 1:
                printMessage("All Animal Info: \n");

                break;
            case 2:
                printMessage("Animal by Happiness: \n");
                System.out.println(Zoo.getZoo());
                Zoo.getSortedAnimals();
                System.out.println(Zoo.getZoo());
                break;
            case 3:
                printMessage("Search");
                break;
            case 4:
                setNextCommands("home");
                break;
        }

    }



}
