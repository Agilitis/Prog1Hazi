package internal;

import Graphics.ChocolateMachineView;
import Graphics.Drawable;
import utility.Logger;

/**
 * A játékban a csokiautómata. Véletlenszerűen kiadja a hangját, mely a szomszédos mezőkön hallatszik és a
 * pandák reagálhatnak rá.
 */
public class ChocolateVendingMachine extends Thing {

    public ChocolateVendingMachine(String name, Field field) {
        super(name, field);
    }

    @Override
    public Drawable getDrawable() {
        ChocolateMachineView chocolateMachineView = new ChocolateMachineView();
        chocolateMachineView.setCoordinates(this.coordinates);
        return chocolateMachineView;
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

    @Override
    public String toString(){
        return "Name: " + this.name + " " + "Field: " + this.field;
    }
}
