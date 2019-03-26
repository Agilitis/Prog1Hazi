package internal;

import utility.Logger;

/**
 * Olyan panda aki a fotel eseményére tud reagálni.
 */
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

    /**
     * A pandát elaltatjuk egy kanapén.
     * @param sleepHere A kanapé, amin a panda alhat.
     */
    protected void putToRest(Couch sleepHere) {
    	Logger.increaseTabulation();
        logger.log(this+".putToRest("+sleepHere+")");
        sleepHere.setRestingPanda(this);
        field.removeGameObject();
        canMoveAlone = false;
        releaseHands();
        Logger.decreaseTabulation();
    }

    /**
     * Minden időegyésgben az álmos panda fáradtsága csökken.
     */
    @Override
    public void tick() {
        if(stamina-- <= 0){
            isSleepy = true;
        }
    }

    /**
     * A panda éberségét felvesszük újra az alapértelmezett mértékre. Ez pl akkor történhet meg, ha aludt egy kanapén.
     */
    void refreshPanda(){
        setSleepy(false);
        setStamina(20);
    }

    /**
     * Ezt a függvényét, hívja megy egy kanapé a pandának, ha az éppen eltüzeli az eseményét és a panda ott áll mellette.
     * @param couch A kanapé, ami az eseményt kiadta.
     */
    @Override
    public void restingSpotAvailable(Couch couch) {
    	Logger.increaseTabulation();
        if(isSleepy){
            putToRest(couch);
        }
        Logger.decreaseTabulation();
    }
}
