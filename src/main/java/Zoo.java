import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List animals = new ArrayList<Animal>();

    public Zoo( List animals) {
        this.animals = animals;
    }

    public List getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
}
