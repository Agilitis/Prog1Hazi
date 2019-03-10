package internal;


public class FinishField extends Field {

    public FinishField(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    @Override
    public void acceptAnimal(Animal animal) {
        logger.log("Accepting animal: "+ animal + " sending it to zoo!");
        animal.goToZoo();
    }
}
