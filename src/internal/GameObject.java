package internal;

import utility.Logger;

public abstract class GameObject implements ITickable {
    Logger logger = new Logger();

    protected Field field;

    public GameObject(Field field) {
        this.field = field;
        this.field.setGameObject(this);
    }

    protected void hitByAnimal(Animal animal){}

    protected void replaceField(Field newField){
        field = newField;
    }

	public Field getField() {
		return field;
	}

    public void restingSpotAvailable(Couch couch) {

    }

    void chocolateVendingMachineBeepSoundPlayed(){

    }

    void arcadeMachineRingSoundPlayed(){

    }
}
