// Inheritance
public class UserCommands extends Commands {

    private User user;

    public UserCommands() {
        super("Create user", new String[]{}, "user");
    }

    public User getUser() {
        return user;
    }

    @Override
    public void run() {
        // Getting information to create a user
        printGreeting();
        printMessage("Enter Username:");
        String username = getStringInput();

        // Using the retrieved information to create a user
        user = new User(username);
        printMessage(user.toString());

        // Setting up the application to run using basic commands
        setNextCommands("home");
    }
}
