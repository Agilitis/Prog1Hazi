public class BigPanda extends Panda {

    public void getJumpScared(){
        field.sufferDamage(5);
    }
    @Override
    protected void eventHappened(Thing thing) {
        thing.pandaListenedToEvent(this);
    }
}
