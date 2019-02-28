public abstract class Thing extends GameObject {
    protected int counter;

    @Override
    public void tick() {
        if(counter-- <= 0){
            doEvent();
            counter = 20;
        }
    }

    abstract void doEvent();

}

