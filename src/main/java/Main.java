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

        UserCommands userCommands = new UserCommands();
        userCommands.run();

        User user = userCommands.getUser();

        Commands currentCommands = userCommands;


        // Setting up the application to run using basic commands
        boolean isActive = true;

        while (isActive) {
            switch(currentCommands.getNextCommands()) {
                case "home" :
                    currentCommands = new HomeCommands();
                    currentCommands.run();
                    break;

                case "visit" :
                    currentCommands = new VisitCommands(user);
                    currentCommands.run();
                    break;

                case "manage" :
                    currentCommands = new ManageCommands(user);
                    currentCommands.run();
                    break;

                case "stats" :
                    currentCommands = new StatsCommands();
                    currentCommands.run();
                    break;

                default:
                    isActive = false;
            }
        }

    }
}
