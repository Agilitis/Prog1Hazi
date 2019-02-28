public class Machine extends Thing {
    @Override
    public void pandaListenedToEvent(Panda panda) {
        panda.scare();
    }

}
