public abstract class GameObject implements ITickable {

    protected Field field;

    protected void hitByAnimal(Animal animal){}
    protected void die(){}

    protected void replaceField(Field newField){
        field = newField;
    }

    public void restingSpotAvailable(Couch couch) {

    }

    void chocolateVendingMachineBeepSoundPlayed(){

    }

    void arcadeMachineRingSoundPlayed(){

    }
}
