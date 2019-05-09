package internal;

import Graphics.Drawable;
import utility.Logger;

/**
 * Egy álltalános dolog a játékban. Minden ami a mezőkön tud lenni az gameObject. Absztrakt osztály.
 */
public abstract class GameObject implements ITickable {
    Logger logger = new Logger();
    protected int[] coordinates = new int[2];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    public GameObject(){}

    public void setField(Field field) {
        this.field = field;
    }

    protected Field field;

    public GameObject(Field field) {
        this.field = field;
        this.field.setGameObject(this);
        this.coordinates = field.getCoordinates();
    }


    /**
     * Akkor hívódik, ha egy állat nekiment. A leszármazottak felüldefiniálják, hogy egyedi módon reagálhassanak.
     * @param animal
     */
    protected void hitByAnimal(Animal animal){
    	Logger.increaseTabulation();
        logger.log(this+".hitByAnimal(" + animal + ")");
        Logger.decreaseTabulation();
    }

    /**
     * Ez a fgvény teszi át a gameObjectet a mezőről egy másikra.
     * @param newField  A mező amire rálép.
     */
    protected void replaceField(Field newField){
        field = newField;
    }

	public Field getField() {
		return field;
	}

    /**
     * Leszármmazott használja, hogy reagálhasson a Thingek eseményeire.
     * @param couch Az eseményt generáló Couch.
     */
    public void restingSpotAvailable(Couch couch) {

    }
    /**
     * Leszármmazott használja, hogy reagálhasson a Thingek eseményeire.
     */
    void chocolateVendingMachineBeepSoundPlayed(){

    }
    /**
     * Leszármmazott használja, hogy reagálhasson a Thingek eseményeire.
     */
    void arcadeMachineRingSoundPlayed(){

    }

    public abstract Drawable getDrawable();
}
