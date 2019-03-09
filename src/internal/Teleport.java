package internal;

public class Teleport extends Field {


    @Override
    public void acceptAnimal(Animal animal) {
        Field neighbour = neighBours[0];
        neighbour.acceptAnimal(animal);
    }
}
