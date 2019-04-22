package internal;

import utility.Logger;

/**
 * Ă�lltalĂˇnos, nem mozgĂł dolog, mely esemĂ©nyt tud generĂˇlni.
 */
public abstract class Thing extends GameObject {
    int counter;

    public Thing(Field field) {
        super(field);
        counter = 1;
    }
    public Thing(){}
    /**
     * Minden idĹ‘egysĂ©gben tickelnek a jĂˇtĂ©kgĂ©pek, Ă©s ha a belsĹ‘ szĂˇmlĂˇlĂłjuk elĂ©ri a 0-t, akkor vĂ©grehajtjĂˇk a sajĂˇt esemĂ©nyĂĽket.
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

    abstract void doEvent();

    public void trigger(){
        doEvent();
    }
}

