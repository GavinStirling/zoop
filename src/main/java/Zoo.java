import java.util.*;

/**
 * RESPONSIBLE FOR STORING & RETRIEVING ANIMALS
 * - WHAT IS A STATIC FIELD / METHOD?
 * These are fields and methods which can be accessed without an instance of the class being instantiated.
 * - WHAT IS HAPPENING ON LINES 15 - 21?
 * The static method is initialised during the build process just once.
 * We are adding 5 Magpie and 5 Lions to the static list. Each Animal instance is given a random name using getRandomName.
 * - WHY IS getRandomName() PRIVATE?
 * It is only used in the Zoo class and should not be accessed directly from anywhere outside.
 * - IN MAIN GET A ANIMAL AT INDEX 0
 */

public class Zoo implements Iterable<Animal> {

    private static final List<Animal> zoo = new ArrayList<>();

    static {
        for (int i = 0; i < 5; i++) {
            zoo.add(new Magpie(getRandomName()));
            zoo.add(new Lion(getRandomName()));
        }
    }

    public static List<Animal> getZoo(){
        return zoo;
    }

    private static String getRandomName() {
        String[] names = {"Aiman",
                "Ali",
                "Fernanda",
                "Gavin",
                "Hassan",
                "Hugo",
                "Isobelle",
                "Mark",
                "Mohammad",
                "Rachel",
                "Samuel",
                "Wesley",
                "Will",};

        int random = (int) (Math.random() * names.length);
        return names[random];
    }

    public static Animal getAnimalByIndex(int index) {
        return zoo.get(index);
    }

    public static void getSortedAnimals () {
        // Sorting our animals
        Collections.sort(zoo);
    }

    @Override
    public Iterator<Animal> iterator() {
        return this.zoo.iterator();
    }

}
