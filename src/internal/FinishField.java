package internal;


public class FinishField extends Field {

    public FinishField(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    /**
     * A finishfieldre, ha egy állat lép, akkor azt az állatkertbe küldi.
     * @param animal Az állat, amit az állatkertbe kell küldeni.
     */
    @Override
    public void acceptAnimal(Animal animal) {
        logger.log(this + "." + "acceptAnimal(" + animal + ")");
        logger.log("\t" + animal + ".goToZoo()");
        animal.goToZoo();
    }
}
