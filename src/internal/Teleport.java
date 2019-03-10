package internal;


public class Teleport extends Field {


    public Teleport(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    @Override
    public void acceptAnimal(Animal animal) {
        Field neighbour = neighBours.get(0);
        neighbour.acceptAnimal(animal);
    }
}
