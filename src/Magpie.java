/**
 * FOCUSING ON INHERITANCE
 *
 * MAGPIE CLASS GAINS ALL FIELDS AND METHODS FROM ANIMAL CLASS
 * - GIVES THE ANIMAL CONSTRUCTOR THE DATA IT NEEDS
 * - STORES & GETS WHETHER IT IS FLYING OR NOT
 */

public class Magpie extends Animal {
    private boolean isFlying;

    public Magpie(String name, String id) {
        //Super -> Pass the information that the class needs
        super(name, "magpie", id, "Caaawwww");
        this.isFlying = false;
        }

    public boolean getIsFlying() {
        return isFlying;
    }

    @Override
    public String toString() {
        // To return the original string we can use super.toString() which calls the previous implementation from the Animal class

        return super.toString() + "\nisFlying: " +isFlying;
    }

    // RECEIVE TREAT -> OVERRIDE IT
    // - IF THE ANIMAL IS FLYING YOU DON'T GIVE IT A TREAT & STOPS FLYING
    // - IF IT IS NOT FLYING YOU CAN GIVE IT A TREAT & STARTS FLYING
    @Override
    public void receiveTreat() {
        if (isFlying) {
            System.out.println(this.getName() + " is flying at the moment. They will stop flying and you can try again.");
            isFlying = false;
        } else {
            super.receiveTreat();
            isFlying = true;
            System.out.println(this.getName() + " started flying after you gave them a treat!");
        }
    }
}
