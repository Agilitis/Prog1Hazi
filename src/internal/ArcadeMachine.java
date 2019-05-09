package internal;

import Graphics.ArcadeMachineView;
import Graphics.Drawable;
import utility.Logger;

/**
 * A játékgép. Tulajdonsága, hogy véletlenszerűen hangot ad ki, mely a szomszédos mezőkön hallatszik és a
 * pandák reagálhatnak rá.
 */
public class ArcadeMachine extends Thing {

    public ArcadeMachine(Field field) {
        super(field);
        counter = 1;
    }

    @Override
    public Drawable getDrawable() {
        ArcadeMachineView arcadeMachineView = new ArcadeMachineView();
        arcadeMachineView.setCoordinates(this.coordinates);
        return arcadeMachineView;
    }

    public ArcadeMachine(){}
    /**
     * Fgvény, mely megvalósítja a hang kiadását. Minden szomszédos mezőtől elkéri az ott található gameObjectet és
     * meghívja az arcadeMachineRingSoundPlayed() fgvényét.
     */
    @Override
    public void doEvent() {
    	Logger.increaseTabulation();
        for(Field neighbour : field.getNeighbours()){
            logger.log(neighbour + ".getGameObject()");
            GameObject gameObject = neighbour.getGameObject();
            logger.log("\t" + gameObject + ".arcadeMachineRingSoundPlayed()");
            gameObject.arcadeMachineRingSoundPlayed();
        }
        Logger.decreaseTabulation();
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " " + "Field: " + this.field;
    }
}
