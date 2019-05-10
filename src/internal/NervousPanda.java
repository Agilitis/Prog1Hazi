package internal;

import Graphics.Drawable;
import Graphics.NervousPandaView;
import utility.Logger;

import java.io.IOException;

/**
 * Olyan panda aki a játékautómata hangjára elengedi a többiek kezét. Másra nem reagál.
 */
public class NervousPanda extends Panda {

    public NervousPanda(String name, Field field) {
        super(name, field);
    }
    public NervousPanda(){}
    /**
     * Ha meghallja a játékautómata hangját hívódik. Elengedi a többi panda kezét, mely hatására a sor felbomlik.
     */
    @Override
    public void scare() {
    	Logger.increaseTabulation();
        logger.log(this +".scare()");
        logger.log(this+".releaseHands()");
        releaseHands();
        Logger.decreaseTabulation();
    }
    /**
     * Ezt a fgvényt hívja az ArcadeMachine mikor kiadja a hangot. Meghívja a scare()-t.
     */
    @Override
    void arcadeMachineRingSoundPlayed() {
    	Logger.increaseTabulation();
        logger.log(this + "arcadeMachineRingSoundPlayed()");
        scare();
        Logger.decreaseTabulation();
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " " + "Field: " + this.field;
    }

    @Override
    public Drawable getDrawable() throws IOException {
        NervousPandaView nervousPandaView = new NervousPandaView();
        nervousPandaView.setCoordinates(this.coordinates);
        return nervousPandaView;
    }
}
