package internal;

public abstract class Thing extends GameObject {
    int counter;

    public Thing(Field field) {
        super(field);
    }

    @Override
    public void tick() {
        if(counter-- <= 0){
            doEvent();
            counter = 20;
        }
    }

    abstract void doEvent();

}

