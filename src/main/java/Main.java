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

//        Zoo animals = new Zoo(new ArrayList());
        System.out.println(Zoo.getAnimalByIndex(0));


//        List<Animal> zoo = new ArrayList<>();
//        zoo.add(new Magpie("Mags"));
//        zoo.add(new Magpie("Mags"));
//        zoo.add(new Magpie("Mags"));
//        zoo.add(new Magpie("Mags"));
//        System.out.println(zoo);


//        Animal magpie = new Magpie("Maggy", "m-1");
//        Magpie otherMagpie = new Magpie("Maggy II", "m-2");

//        System.out.println(magpie.toString());
//        System.out.println(otherMagpie.getIsFlying());
//        magpie.receiveTreat();
//        magpie.receiveTreat();
//        System.out.println(magpie.toString());

//        Lion lion = new Lion("Lucas", "l-1");
//        System.out.println(lion.toString());
//        lion.giveTreat();
//        lion.petAnimal();
//        System.out.println(lion.toString());

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
