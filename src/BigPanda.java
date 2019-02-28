public class BigPanda extends Panda {

    @Override
    public void scare(){field.sufferDamage(5);}
    @Override
    protected void eventHappened(Thing thing) {
        thing.pandaListenedToEvent(this);
    }
}
