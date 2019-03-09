package Internal;

public class SleepyPanda extends Panda {
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public boolean isSleepy() {
        return isSleepy;
    }

    public void setSleepy(boolean sleepy) {
        isSleepy = sleepy;
    }

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
        setSleepy(false);
        setStamina(20);
    }

    @Override
    public void restingSpotAvailable(Couch couch) {
        if(isSleepy){
            putToRest(couch);
        }
    }
}
