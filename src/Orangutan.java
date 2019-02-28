public class Orangutan extends Animal {
    @Override
    protected void hitByOrangutan(Orangutan orangutan) {

    }

    @Override
    protected void hitByPanda(Panda panda) {

        pullThis = panda;
    }

    @Override
    protected void hitByAnimal(Animal animal) {
        animal.hitByOrangutan(this);
    }

    @Override
    protected void eventHappened(Thing thing) {

    }

    @Override
    public void tick() {

    }
}
