public class Orangutan extends Animal {



    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
    }

    @Override
    protected void hitByPanda(Panda panda) {
        setPullThis(panda);
        panda.setCanMoveAlone(false);
    }

    @Override
    protected void die() {
        releaseHands();
    }

    @Override
    public void goToZoo() {
        field.removeGameObject();
        if(pullThis != null){
            pullThis.goToZoo();
        }
    }

    @Override
    protected void hitByAnimal(Animal animal) {
        animal.hitByOrangutan(this);
    }

    @Override
    public void tick() {
    }
}
