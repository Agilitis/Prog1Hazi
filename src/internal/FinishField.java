package internal;


public class FinishField extends Field {

    public FinishField(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    @Override
    public void acceptAnimal(Animal animal) {
        logger.log(this + "." + "acceptAnimal(" + animal + ")");
        logger.log("\t" + animal + ".goToZoo()");
        animal.goToZoo();
    }
}
