package internal;

import utility.Logger;

/**
 * Olyan panda aki ha megijed ugrik egyet és ettől a mező nagymértékben sebződik.
 */
public class BigPanda extends Panda {

    public BigPanda(Field field) {
        super(field);
    }

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


}
