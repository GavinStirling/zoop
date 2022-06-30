import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private final User user;

    public ManageCommands(User user) {
        super("Manage", new String[]{"All Animal Info", "View Animals by Happiness", "Search", "Back"}, "manage");
        this.user = user;
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        switch (userInput) {
            case 1:
                printMessage("All Animal Info: \n");

                // Pass in a lambda expression
                // Parameter -> Do something
                // (Parameter1, Parameter 2) -> Do something
                // Parameter -> {Return something}

                Zoo.getZoo().forEach(animal -> printMessage(animal.toString()));

                break;
            case 2:
                printMessage("Animal by Happiness: \n");
                Zoo.getSortedAnimals().forEach(animal -> printMessage(animal.toString()));

//                for (Animal animal : Zoo.getZoo()) {
//                    printMessage(animal.toString());
//                }

                break;
            case 3:
                printMessage("Enter Search Term: ");
                String searchTerm = getStringInput();

                // There needs to be a way of searching an animal and a user
                // They are different classes
                // Using the interface as the type to make a list of searchable items
                List<Searchable> toSearch = new ArrayList<>();
                // Get the animal array list and add all animals to the toSearchArray
                toSearch.addAll(Zoo.getZoo());
                toSearch.add(user);

                List<String> searchResults = toSearch.stream()
                        .filter(searchItem -> searchItem.hasMatch(searchTerm) ) // Passing back only the items which return true
                        .map(Searchable::toString) // Convert items to string -> Replaces the lambda expression with a method reference
                        .collect(Collectors.toList()); // Collect and convert into a list

                printMessage(searchResults.size() + " result(s) are found.");
                searchResults.forEach(this::printMessage);

                // Method reference vs. lambda expression
                // .map(Searchable::toString) = .map(filteredItem -> filteredItem.toString())
                // searchResults.forEach(this::printMessage) = searchResults.forEach(animal -> printMessage(animal))

//                for (Searchable searchItem : toSearch) {
//                    // Use the hasMatch method to return a boolean. Can only call methods within the interface class.
//                    if (searchItem.hasMatch(searchTerm)) {
//                        // Use the toString method to return a string. Can only call methods within the interface class.
//                        printMessage(searchItem.toString());
//                    }
//                }

                break;
            case 4:
                setNextCommands("home");
                break;
        }

    }



}
