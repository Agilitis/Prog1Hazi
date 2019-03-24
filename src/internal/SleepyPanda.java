package internal;

public class SleepyPanda extends Panda {
    public SleepyPanda(Field field) {
        super(field);
    }

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
    private boolean isSleepy = true;

    protected void putToRest(Couch sleepHere) {
        logger.log("Sleepy panda going to sleep now.");
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
            logger.log("Sleepy panda: " +hashCode()+" found a resting spot: " + couch.hashCode());
            putToRest(couch);
        }
    }
}
