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

public class Commands {
    // final -> This property will never change
    private final Scanner scanner = new Scanner(System.in);;
    private final String name;
    private final String[] commands;


    public Commands(String name, String[] commands) {
        this.name = name;
        this.commands = commands;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGreeting() {
        System.out.println("Welcome to the " + name + " commands.");
    }

    public void printCommands() {
        for (int i = 0; i < commands.length; i++) {
            System.out.println((i+1) + ": " + commands[i]);
        }
    }

    // Need to check that the input is within the range of the available commands array
    // If it is then the input integer will be returned
    // If it is not then we can print an error message and try again

    public int getIntegerInput() {
        boolean correctInput = false;
        int input = 0;
        while (!correctInput) {
        int userInput = scanner.nextInt();
            if (userInput > 0 && userInput <= commands.length) {
                correctInput = true;
                input = userInput;
            } else {
                printMessage("Invalid input. Please input a number between 1 and " + commands.length);
            }
        }
        return input;
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
        System.out.println("Enter text");
        String input = "";
        boolean correctInput = false;
        while (!correctInput) {
            String userInput = scanner.nextLine();
            if (userInput.equals("")) {
                System.out.println("Unable to understand input, try again");
            } else {
                correctInput = true;
                input = userInput;
            }
        }
        return input;
    }

}
