package internal;

import utility.Logger;

/**
 * Ă�lltalĂˇnos, nem mozgĂł dolog, mely esemĂ©nyt tud generĂˇlni.
 */
public abstract class Thing extends GameObject {
    int counter;

    public Thing(String name, Field field) {
        super(name, field);
        counter = 1;
    }
    public Thing(){}
    /**
     * Minden edőegységben tickelnek a játékgépek és ha a belső számlálójuk eléri a 0-t akkor végrehajtja a saját eseményeket.
     */
    @Override
    public void tick() {
    	Logger.increaseTabulation();
        logger.log(this + ".tick()");
        if(--counter <= 0){
            logger.log(this +".doEvent()");
            doEvent();
            counter = 20;
        }
        Logger.decreaseTabulation();
    }

    @Override
    public String toString() {
        return "Name: %s, Counter: %s".format(this.name, this.counter);
    }

    abstract void doEvent();

    public void trigger(){
        doEvent();
    }
}

