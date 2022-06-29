/**
 * FOCUSING ON CLASS SYNTAX
 *
 * ANIMAL CLASS RESPONSIBLE FOR:
 * - STORING NAME
 * - STORING TYPE
 * - STORING & GETTING ID
 * - STORING & GETTING & SETTING ISTAME
 * - STORING & GETTING & SETTING HAPPINESS
 *  - HAPPINESS CANNOT GO ABOVE 100
 *  - IF HAPPINESS GOES ABOVE 50 THE ANIMAL IS TAME
 * - PETTING THE ANIMAL
 * - GIVING THE ANIMAL A TREAT
 * - GETTING THE ANIMALS INFORMATION
 */

// Implementing an interface -> Comparable is an interface in the JDK which makes it easier to sort classes

public class Animal implements Comparable<Animal> {
    // Add fields to an object
    // Access-modifier Type Field-name
    private String name;
    private String type;
    private String id;
    private boolean isTame;
    private int happiness;
    private final String sound;

    // Static fields & methods -> Is accessible without initialising the class
    private static int animalCount = 0;

    public static int getAnimalCount() {
        return animalCount;
    }

    public static void setAnimalCount(int animalCount) {
        Animal.animalCount = animalCount;
    }


    // Constructor
    // - Takes values and assigns them to fields
    // - When initialised
    public Animal (String name, String type, String id, String sound) {
        // this -> refers to the object
        this.name = name;
        this.type = type;
        this.id = id;
        this.sound = sound;

        //Sets default value
        this.happiness = (int) (Math.random()*100 +1);
        this.isTame = this.happiness > 50;

        // Increasing static field when a new animal is created
        setAnimalCount(animalCount + 1);
    }

    // Creating an overloaded constructor method which doesn't require an id string
    public Animal (String name, String type, String sound) {
        // this() calls the original constructor method
        this(name, type,"-" + animalCount, sound);
    }

    // Getter -> Method
    // - How we retrieve private information
    // - Unable to be changed

    public String getId() {
        return id;
    }

    public boolean getIsTame() {
        return isTame;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public String getSound() {
        return sound;
    }

    // Setter -> Method
    // - How we set private information

    public void setIsTame(boolean isTame) {
        this.isTame = isTame;
    }

    public void setHappiness(int happiness) {
        if (happiness <= 100) {
            this.happiness = happiness;
        }
    }

    public void addHappiness(int additionalHappiness) {
        int newHappiness = this.happiness + additionalHappiness;
        if (newHappiness <= 100) {
            setHappiness(newHappiness);
//            System.out.println(this.name + " now has a happiness level of: " + happiness);
        } else {
            setHappiness(100);
            System.out.println(this.name + " now has a maximum happiness level of: " + happiness);
        }
    }

    public void petAnimal() {
        if (!this.isTame) {
            System.out.println(this.name + " can only be petted once they are tamed. Try some treats first!");
        } else {
            int additionalHappiness = (int) (Math.random() * 5 + 1);
            System.out.println("You petted " + name + " and their happiness increased by " + additionalHappiness + " to " + happiness);
            addHappiness(additionalHappiness);
            isTamed();
        }
    }

    public void receiveTreat() {
        int additionalHappiness = (int) (Math.random() * 15 + 1);
        System.out.println("You gave " + name + " a treat and their happiness increased by " + additionalHappiness + " to " + happiness);
        addHappiness(additionalHappiness);
        isTamed();
    }

    // Annotation explicitly stating we want to override the toSting method from the Object class which we extend from/inherited.
    // This allows us to implement our own logic for the toString function.
    @Override
    public String toString() {
        return String.format("\nName: %s \nType: %s \nID: %s \nTame: %s \nHappiness: %s", name, type, id, isTame, happiness);
    }

    public void isTamed() {
        if (this.happiness >= 50 && !isTame) {
            setIsTame(true);
            System.out.println(this.name + " has now been tamed!");
        }
    }

    // Implementation of the compareTo method from the comparable interface class
    @Override
    public int compareTo(Animal animal) {
        // Sorting the animals by happiness
        // > 0 -> Put the animal ahead
        // = 0 -> Keeps their place
        // < 0 -> Puts the animal behind
        return animal.getHappiness() - happiness;
    }
}
