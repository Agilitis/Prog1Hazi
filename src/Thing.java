public abstract class Thing extends GameObject {


    @Override
    protected void hitByAnimal(Animal animal) {

    }

    @Override
    protected void die() {

    }

    protected void doEvent(){
        GameObject objectToNotify = field.getNeighbours()[0].getGameObject();
        objectToNotify.eventHappened(this);
    }

    @Override
    public void tick(){
        doEvent();
    }

    public abstract void pandaListenedToEvent(Panda panda);
}
