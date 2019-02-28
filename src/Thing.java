public abstract class Thing extends GameObject {

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
