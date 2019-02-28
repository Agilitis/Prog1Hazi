public class VendingMachine extends Thing {
    @Override
    public void pandaListenedToEvent(Panda panda) {
        panda.getScared();
    }

    @Override
    protected void eventHappened(Thing thing) {

    }
}
