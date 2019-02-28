public abstract class GameObject implements ITickable {

    protected Field field;

    protected abstract void hitByAnimal(Animal animal);
    protected abstract void die();

    protected abstract void eventHappened(Thing thing);
    protected void replaceField(Field newField){
        field = newField;
    }
}
