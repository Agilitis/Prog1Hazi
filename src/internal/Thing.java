package internal;

/**
 * Álltalános, nem mozgó dolog, mely eseményt tud generálni.
 */
public abstract class Thing extends GameObject {
    int counter;

    public Thing(Field field) {
        super(field);
        counter = 1;
    }

    /**
     * Minden időegységben tickelnek a játékgépek, és ha a belső számlálójuk eléri a 0-t, akkor végrehajtják a saját eseményüket.
     */
    @Override
    public void tick() {
        logger.log(this + ".tick()");
        if(--counter <= 0){
            logger.log(this +".doEvent()");
            doEvent();
            counter = 20;
        }
    }

    abstract void doEvent();

}

