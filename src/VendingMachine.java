public class VendingMachine extends Thing {
    @Override
    public void pandaListenedToEvent(Panda panda) {
        panda.scare();
    }
}
