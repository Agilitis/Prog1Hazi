package internal;


public class FinishField extends Field {

    public FinishField(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    @Override
    public void acceptAnimal(Animal animal) {
        animal.goToZoo();
    }
}
