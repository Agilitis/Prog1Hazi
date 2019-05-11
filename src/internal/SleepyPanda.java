package internal;

import Graphics.Drawable;
import Graphics.SleepyPandaView;
import utility.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Olyan panda aki a fotel eseményére tud reagálni.
 */
public class SleepyPanda extends Panda {
    public SleepyPanda(String name, Field field) {
        super(name, field);
    }
    public SleepyPanda(){}
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
        this.coordinates = sleepHere.getField().getCoordinates();
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
        if (canMoveAlone) {
            Random rand = new Random();
            ArrayList<Field> stepOptions = getStepOptions();
            Field movingTo = stepOptions.get(rand.nextInt(stepOptions.size()));
            move(movingTo);
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

    @Override
    public String toString(){
        return "Name: " + this.name + " " + "Field: " + this.field;
    }

    @Override
    public Drawable getDrawable() throws IOException {
        SleepyPandaView sleepyPandaView = new SleepyPandaView();
        sleepyPandaView.setCoordinates(this.coordinates);
        return sleepyPandaView;
    }
}
