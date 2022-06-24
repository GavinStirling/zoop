import java.util.ArrayList;

/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */

public class Main {
    public static void main(String[] args) {

        Zoo animals = new Zoo(new ArrayList());

        Animal magpie = new Magpie("Maggy", "m-1");
        Magpie otherMagpie = new Magpie("Maggy II", "m-2");

        System.out.println(magpie.toString());
        System.out.println(otherMagpie.getIsFlying());
        magpie.receiveTreat();
        magpie.receiveTreat();
        System.out.println(magpie.toString());

        Lion lion = new Lion("Lucas", "l-1");
//        System.out.println(lion.toString());
//        lion.giveTreat();
//        lion.petAnimal();
//        System.out.println(lion.toString());

        // Getting information to create a user
        Commands currentCommands = new Commands("Create user", new String[]{});
//        currentCommands.printGreeting();
//        currentCommands.printMessage("Enter Username:");
        String username = "currentCommands.getStringInput();";

        // Using the retrieved information to create a user
        User user = new User(username);
//        currentCommands.printMessage(user.getInfo());

        // Setting up the application to run using basic commands
        String nextCommands = "home";
        boolean isActive = false;

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
