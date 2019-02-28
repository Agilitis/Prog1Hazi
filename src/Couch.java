public class Couch extends Thing {

    private Panda sleepingPanda;

    @Override
    public void pandaListenedToEvent(Panda panda) {
        panda.putToSleep(this);
    }

    @Override
    protected void eventHappened(Thing thing) {

    }

    public void setSleepingPanda(Panda sleepingPanda) {
        this.sleepingPanda = sleepingPanda;
    }

    @Override
    public void tick(){
        //normal event
        doEvent();

        //if someone is sleeping
        sleepingPanda.move(field.getNeighbours()[0]);
    }
}
