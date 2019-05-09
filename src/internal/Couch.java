package internal;

import Graphics.CouchView;
import Graphics.Drawable;
import utility.Logger;

/**
 * A fotel. Ha egy álmos panda mellé lép akkor bele tud ülni.
 */
public class Couch extends Thing {

    private SleepyPanda restingPanda;

    public Couch(Field field) {
        super(field);
    }

    @Override
    public Drawable getDrawable() {
        CouchView couchView = new CouchView();
        couchView.setCoordinates(this.coordinates);
        return couchView;
    }

    public Couch(){}

    void setRestingPanda(SleepyPanda restingPanda) {
        this.restingPanda = restingPanda;
    }

    /**
     * Minden időegységben tickel a kanapé, ami ezáltal csökkent egy belső számlálót, ami ha eléri a 0-t, akkor a saját eseményét tüzeli.
     */
    @Override
    public void tick() {
    	Logger.increaseTabulation();
        logger.log(this+".tick()");
        if (--counter <= 0) {
            if (restingPanda != null) {
                Field wakeUpHere = field.getNeighbours().get(0);
                restingPanda.move(wakeUpHere);
                restingPanda.refreshPanda();
            }
            doEvent();
            counter = 20;
        }
        Logger.decreaseTabulation();
    }

    /**
     * Véletlenszerűen hívódik meg. Ha meghívódik minden szomszédos mezőn álló dolognak szól. hogy ide le lehet ülni.
     */
    @Override
    public void doEvent() {
    	Logger.increaseTabulation();
        logger.log(this+".doEvent(" + ")");

        for (Field neighbour : field.getNeighbours()) {
            GameObject gameObject = neighbour.getGameObject();
            logger.log("\t"+gameObject+".restingSpotAvailable()");
            gameObject.restingSpotAvailable(this);
        }
        Logger.decreaseTabulation();
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " " + "Field: " + this.field;
    }
}
