import java.util.ArrayList;
import java.util.Scanner;

/**
 * ABSTRACTION
 *
 * COMMANDS CLASS RESPONSIBLE FOR:
 * - STORING THE NAME OF CURRENT COMMANDS
 * - STORING AN ARRAY OF GIVEN COMMANDS
 * - STORING A SCANNER
 * - PRINTING A MESSAGE
 * - PRINTING A GREETING FROM CURRENT SCREEN
 * - PRINTING INDEXED GIVEN COMMANDS
 * - GET INTEGER INPUT ENTERED BY USER
 * - GET STRING INPUT ENTERED BY USER
 */

// An abstract class cannot be initialised. It has to be inherited from or extended.
    // What a class should do

public abstract class Commands {
    // final -> This property will never change
    private final Scanner scanner = new Scanner(System.in);;
    private final String name;
    private final String[] commands;
    private String nextCommands;


    public Commands(String name, String[] commands, String nextCommand) {
        this.name = name;
        this.commands = commands;
        this.nextCommands = nextCommand;
    }

    // Abstract method which any sub-classes have to implement.
        // This indicates every sub-class should have every method.
    abstract public void run ();

    public String getNextCommands() {
        return nextCommands;
    }

    public void setNextCommands(String nextCommand) {
        this.nextCommands = nextCommand;
    }

    public void printMessage(String message) {
        System.out.println("-----");
        System.out.println(message);
        System.out.println("-----");
    }

    public void printGreeting() {
        System.out.println("Welcome to the " + name + " commands.");
    }

    // Original method before challenge
//    public void printCommands() {
//        for (int i = 0; i < commands.length; i++) {
//            System.out.println((i+1) + ": " + commands[i]);
//        }
//    }

    // OVERLOAD printCommands
    // ONE METHOD SHOULD TAKE AN STRING[] AS A PARAMETER
    // - IT SHOULD LOOP THROUGH & KEEP THE ORIGINAL PRINT FUNCTIONALITY

    public void printCommands(String[] stringArr) {
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println((i+1) + ": " + stringArr[i]);
        }
    }

    // ONE METHOD SHOULD HAVE NO PARAMETERS
    // - IT SHOULD PASS IN THE commands FIELD

    public void printCommands() {
        printCommands(commands);
    }

    // EXTENSION
    // ADD ANOTHER printCommands THAT TAKES ArrayList<String>
    // - IT SHOULD LOOP THROUGH & KEEP THE ORIGINAL PRINT FUNCTIONALITY

    public void printCommands(ArrayList<String> stringList) {
        int index = 1;
        for (String string : stringList) {
            System.out.println((index) + ": " + string);
            index += 1;
        }
    }

    // Need to check that the input is within the range of the available commands array
    // If it is then the input integer will be returned
    // If it is not then we can print an error message and try again

    public int getIntegerInput(int rangeLimit) {
        boolean correctInput = false;
        int input = 0;
        while (!correctInput) {
            printMessage("Enter a number between 1 and " + rangeLimit);
        int userInput = scanner.nextInt();
            if (userInput > 0 && userInput <= rangeLimit) {
                correctInput = true;
                input = userInput;
            } else {
                printMessage("Invalid input. Please input a number between 1 and " + rangeLimit);
            }
        }
        scanner.nextLine();
        return input;
    }

    public int getIntegerInput() {
        return getIntegerInput(commands.length);
    }

    /*
     * WRITE A METHOD CALLED getStringInput
     * - IT SHOULD RETURN A STRING
     * - DISPLAY THIS MESSAGE "Enter text"
     * - USE THE SCANNER TO CAPTURE THE USERS INPUT
     * - IF THE USER HAS ENTERED A VALUE RETURN IT
     * - IF THE USER HASN'T ENTERED ANYTHING
     *   - DISPLAY THIS MESSAGE "Unable to understand input, try again"
     *   - TRY TO GET THE INPUT AGAIN.
     */
    public String getStringInput() {
        System.out.println("Enter text below: ");

        String userInput = scanner.nextLine();
        if (userInput.equals("")) {
            System.out.println("Unable to understand input, try again");
            return getStringInput();
        } else {
            return userInput;
        }
    }

}
