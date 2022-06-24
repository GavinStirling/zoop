import java.util.ArrayList;
import java.util.List;

/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */

public class Main {
    public static void main(String[] args) {
        // Getting information to create a user
        Commands currentCommands = new Commands("Create user", new String[]{});
        currentCommands.printGreeting();
        currentCommands.printMessage("Enter Username:");
        String username = currentCommands.getStringInput();

        // Using the retrieved information to create a user
        User user = new User(username);
        currentCommands.printMessage(user.getInfo());

        // Setting up the application to run using basic commands
        String nextCommands = "home";
        boolean isActive = true;

        while (isActive) {
            switch(nextCommands) {
                case "home" :
                    currentCommands = new Commands("Home", new String[]{"Visit and Animal", "Manage the Animals", "Quit"});
                    currentCommands.printGreeting();
                    currentCommands.printCommands();
                    int userInput = currentCommands.getIntegerInput();

                    if (userInput == 1) {
                        nextCommands = "visit";
                    } else if (userInput == 2) {
                        nextCommands = "manage";
                    } else if (userInput == 3) {
                        nextCommands = "";
                    } else {
                        nextCommands = "";
                    }
                    break;

                case "visit" :
                    currentCommands.printMessage("VISIT");
                    nextCommands = "home";
                    break;

                case "manage" :
                    currentCommands.printMessage("MANAGE");
                    nextCommands = "home";
                    break;

                default:
                    isActive = false;
            }
        }

    }
}
