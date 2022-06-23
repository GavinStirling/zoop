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

public class Animal {
    // Add fields to an object
    // Access-modifier Type Field-name
    private String name;
    private String type;
    private String id;
    private boolean isTame;
    private int happiness;


    // Constructor
    // - Takes values and assigns them to fields
    // - When initialised
    public Animal (String name, String type, String id ) {
        // this -> refers to the object
        this.name = name;
        this.type = type;
        this.id = id;

        //Sets default value
        this.happiness = (int) (Math.random()*100 +1);
        this.isTame = this.happiness > 50;
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

    public int getHappiness() {
        return happiness;
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
        if (newHappiness <=100) {
            setHappiness(newHappiness);
            System.out.println(this.name + " now has a happiness level of: " + this.happiness);
        } else {
            setHappiness(100);
            System.out.println(this.name + " now has a maximum happiness level of: " + this.happiness);
        }
    }

    public void petAnimal() {
        if (!this.isTame) {
            System.out.println(this.name + " can only be petted once they are tamed. Try some treats first!");
        } else {
            int additionalHappiness = (int) (Math.random() * 5 + 1);
            addHappiness(additionalHappiness);
            System.out.println("You petted " + this.name + " and their happiness increased by " + additionalHappiness + " to " + this.happiness);
        }
    }

    public void giveTreat() {
        int additionalHappiness = (int) (Math.random() * 15 + 1);
        addHappiness(additionalHappiness);
        System.out.println("You gave " + this.name + " a treat and their happiness increased by " + additionalHappiness + " to " + this.happiness);
    }

    public String getAnimalInfo() {
        String tameString = "They are not tame";
        if (this.isTame) {
            tameString = "They are tame";
        }

        return String.format("%s is a %s and their ID is %s. %s and have a happiness level of %s out of 100.", this.name, this.type, this.id, tameString, this.happiness);
    }

    public void isTamed() {
        this.isTame = this.happiness > 50;
        if (this.isTame) {
            System.out.println(this.name + " has now been tamed!");
        }
    }


}
