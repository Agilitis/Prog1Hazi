public class Machine extends Thing {
    @Override
    public void pandaListenedToEvent(Panda panda) {
        panda.getJumpScared();
    }

    @Override
    protected void eventHappened(Thing thing) {

    }
}
