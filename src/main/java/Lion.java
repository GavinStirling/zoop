/**
 * CREATE A LION CLASS
 * THIS SHOULD INHERIT FROM OUR ANIMAL BASE CLASS
 * IT SHOULD GIVE THE BASE CLASS CONSTRUCTOR THE INFORMATION IT NEEDS
 * IT NEEDS A NEW FIELD isSleeping & A GETTER FOR THIS FIELD
 */

public class Lion extends Animal {
    private boolean isSleeping;

    public Lion(String name, String id) {
        super(name, "lion", id, "Rooaarr");
        isSleeping = false;
        this.setIsTame(this.getHappiness() >= 70);
    }

    public boolean getIsSleeping() {
        return isSleeping;
    }
}