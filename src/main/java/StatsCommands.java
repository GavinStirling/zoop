import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatsCommands extends Commands {
    public StatsCommands() {
        super("Stats", new String[]{"Print Animal Name's","Print Tame animals", "Print Least happy", "By type", "Back" }, "stats");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();
        int userInput = getIntegerInput();

        switch (userInput) {
            case 1:
                Zoo.getZoo().forEach(animal -> printMessage(animal.getName()));
                break;
            case 2:
                List<Animal> CheckTameAnimals = Zoo.getZoo();
                List<String> tameAnimals = CheckTameAnimals.stream()
                        .filter(Animal::getIsTame)
                        .map(Animal::getName)
                        .collect(Collectors.toList());
                tameAnimals.forEach(this::printMessage);
                printMessage("There are a total of " + tameAnimals.size() + " tame animals in the zoo.");
                break;
            case 3:
                List<Animal> checkHappyAnimals = Zoo.getSortedAnimals();
                printMessage(checkHappyAnimals.get(checkHappyAnimals.size()-1).toString());
                break;
            case 4:
                printMessage("Select animal type below:");
                printMessage("1. Lions \n2. Magpies");
                int animalSelection = getIntegerInput();
                String type = "";
                if (animalSelection == 1) {
                    type = "lion";
                } else if (animalSelection == 2) {
                    type = "magpie";
                }
                List<Animal> typeAnimals = Zoo.getZoo();
                String finalType = type;
                List<String> selectedType = typeAnimals.stream()
                        .filter(animal -> animal.getType().equals(finalType))
                        .map(Animal::getName)
                        .collect(Collectors.toList());
                selectedType.forEach(this::printMessage);
                printMessage("There are a total of " + selectedType.size() + " in the zoo.");
                break;
            case 5:
                setNextCommands("home");
                break;
        }

//        } else if(userInput == 4){
//            // FIND OUT WHETHER THE USER WANTS TO VIEW BY LIONS OR MAGPIES
//            // BASED ON WHAT THEY CHOOSE
//            // PRINT OUT THE TOTAL NUMBER OF THAT ANIMAL TYPE
//            // PRINT THE ANIMAL TYPE ANIMALS
//        } else {
//            setNextCommands("home");
//        }

    }
}