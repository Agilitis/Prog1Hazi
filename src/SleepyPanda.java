public class SleepyPanda extends Panda {
    private int stamina;
    private boolean isSleepy = false;

    protected void putToRest(Couch sleepHere) {
        sleepHere.setRestingPanda(this);
        field.removeGameObject();
        canMoveAlone = false;
        releaseHands();
    }

    @Override
    public void tick() {
        if(stamina-- <= 0){
            isSleepy = true;
        }
    }

    void refreshPanda(){
        isSleepy = false;
        stamina = 20;
    }

    @Override
    public void restingSpotAvailable(Couch couch) {
        if(isSleepy){
            putToRest(couch);
        }
    }
}
