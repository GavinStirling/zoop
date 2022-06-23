/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */

public class Main {
    public static void main(String[] args) {
        // Initialise the class
        // Pass in the correct parameters
        Animal gavin = new Animal("Gavin", "Dog", "animal-1");

//        System.out.println(gavin.getId());
//        System.out.println(gavin.getIsTame());
        gavin.setIsTame(true);
//        System.out.println(gavin.getIsTame());

        Animal rob = new Animal("Rob", "Orca", "animal-2");

//        System.out.println(rob.getId());
//        System.out.println(rob.getHappiness());
        rob.giveTreat();
        rob.giveTreat();
        rob.giveTreat();
        rob.giveTreat();
        rob.giveTreat();
//        System.out.println(rob.getHappiness());
//        rob.setHappiness(3000);
//        System.out.println(rob.getHappiness());

        System.out.println(rob.getAnimalInfo());


    }
}
