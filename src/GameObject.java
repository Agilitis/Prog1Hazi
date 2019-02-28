public abstract class GameObject implements ITickable {

    protected Field field;

    protected void hitByAnimal(Animal animal){}
    protected void die(){}

    protected void eventHappened(Thing thing){}
    protected void replaceField(Field newField){
        field = newField;
    }
}
