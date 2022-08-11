public class VisitCommands extends Commands {
    public User user;

    public VisitCommands(User user) {
        super("Visit", new String[]{"Pet Animal", "Give treat", "Go Back"}, "visit");
        this.user = user;
    }

    @Override
    public void run() {
        printMessage("All Animal Info: \n");
        Zoo.getZoo().forEach(animal -> printMessage(animal.toString()));

        printMessage("Select which animal to visit by entering their ID number below:");
        int userAnimalSelection =  getIntegerInput(Zoo.getZooSize())-1;
        Animal currentAnimal = Zoo.getAnimalByIndex(userAnimalSelection);

        printGreeting();
        printMessage(currentAnimal.toString());
        printCommands();

        int userInput = getIntegerInput();

        switch (userInput) {
            case 1:
                currentAnimal.petAnimal();
                System.out.println(user);
                user.incrementScore();
                break;
            case 2:
                if (user.hasTreatsLeft()) {
                    currentAnimal.receiveTreat();
                    user.giveTreat();
                }
                break;
            case 3:
                setNextCommands("home");
        }
    }
}