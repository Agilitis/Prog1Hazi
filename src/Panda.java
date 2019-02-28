public class Panda extends Animal {

    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
        orangutan.setPullThis(this);
    }

    @Override
    protected void hitByPanda(Panda panda) {

    }

    @Override
    protected void hitByAnimal(Animal animal) {
        animal.hitByPanda(this);
    }

    @Override
    protected void eventHappened(Thing thing) {

    }

    @Override
    public void tick() {
        //some logic to define when
        //witch field exactly need to be defined
        move(getStepOptions()[0]);
    }
    protected void putToSleep(Couch sleepHere){}
    protected void getScared(){}
    protected void getJumpScared(){}
}
