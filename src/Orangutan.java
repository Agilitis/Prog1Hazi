public class Orangutan extends Animal {



    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
    }

    @Override
    protected void hitByPanda(Panda panda) {
        pullThis = panda;
        panda.setCanMoveAlone(true);
    }

    @Override
    protected void die() {
        releaseHands();
    }

    @Override
    protected void hitByAnimal(Animal animal) {
        animal.hitByOrangutan(this);
    }

    @Override
    public void tick() {
    }
}