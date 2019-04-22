package internal;

import utility.Logger;

/**
 * A játékban a csokiautómata. Véletlenszerűen kiadja a hangját, mely a szomszédos mezőkön hallatszik és a
 * pandák reagálhatnak rá.
 */
public class ChocolateVendingMachine extends Thing {

    public ChocolateVendingMachine(Field field) {
        super(field);
    }
    public ChocolateVendingMachine(){}
    /**
     * Fgvény, mely megvalósítja a hang kiadását. Minden szomszédos mezőtől elkéri az ott található gameObjectet és
     * meghívja a chocolateVendingMachineBeepSoundPlayed() fgvényét.
     */
    @Override
    public void doEvent() {
    	Logger.increaseTabulation();
        for(Field neighbour : field.getNeighbours()){
            GameObject gameObject = neighbour.getGameObject();
            logger.log(gameObject+".chocolateVendingMachineBeepSoundPlayed()");
            gameObject.chocolateVendingMachineBeepSoundPlayed();
        }
        Logger.decreaseTabulation();
    }
}
