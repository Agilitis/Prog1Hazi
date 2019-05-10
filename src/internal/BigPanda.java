package internal;

import Graphics.BigPandaView;
import Graphics.Drawable;
import utility.Logger;

import java.io.IOException;

/**
 * Olyan panda aki ha megijed ugrik egyet és ettől a mező nagymértékben sebződik.
 */
public class BigPanda extends Panda {

    public BigPanda(String name, Field field) {
        super(name, field);
    }
    public BigPanda(){}
    /**
     * A panda megijed, ekkor az alatta levő mezőnek 5 sebzést okoz.
     */
    public void scare() {
    	Logger.increaseTabulation();
        logger.log(this+".scare()");
        field.sufferDamageByAnimal(5, this);
        Logger.decreaseTabulation();
    }

    /**
     * Ezzel reagál a csokiautómata hangjára. Meghívja a scare() fgvényt.
     */
    @Override
    void chocolateVendingMachineBeepSoundPlayed() {
        this.scare();
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " " + "Field: " + this.field;
    }

    @Override
    public Drawable getDrawable() throws IOException {
        BigPandaView bigPandaView = new BigPandaView();
        bigPandaView.setCoordinates(this.coordinates);
        return bigPandaView;
    }
}
