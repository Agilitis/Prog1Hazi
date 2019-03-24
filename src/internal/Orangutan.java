package internal;

import utility.Logger;

/**
 * Olyan állat akit a játékos tud irányítani. Ha pandával ütközik megfogja és maga után húzza.
 */
public class Orangutan extends Animal {


    public Orangutan(Field field) {
        super(field);
    }

    public Orangutan(){}

    /**
     * Ha az orángutánt egy másik orángutánnal ütköztetjük, akkor ez hívódik meg, semmi nem történhet ilyenkor. Ez implicit azt eredményezi, hogy nem is lép az orángután ide.
     * @param orangutan Az orángután, ami ütközött az adott orángutánnal.
     */
    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
    	Logger.increaseTabulation();
        logger.log(this+".hitByOrangutan(" + orangutan + ")");
        Logger.decreaseTabulation();
        //This is left blank in order to emphasize that an Orangutan hitBy an Orangutan does NOTHING.
    }

    /**
     * Az orángutánt, ha egy pandával ütköztetjük, akkor ez hívódik meg. Ha az orángután még nem húzott pandát maga után, akkor ezt a pandát berakjuk mögé, ha viszont húzott, akkor a sor végére kerül.
     * @param panda A panda, amivel ütközött az orángután.
     */
    @Override
    protected void hitByPanda(Panda panda) {
    	Logger.increaseTabulation();
        logger.log(this+".hitByPanda(" + panda + ")");
        if (pullThis != null) {
			pullThis.setPulledBy(panda);
			panda.setPullThis(pullThis);
		}
        Field tmp = panda.getField();
        panda.replaceField(this.field);
        this.replaceField(tmp);

        setPullThis(panda);
		pullThis.setPulledBy(this);
        pullThis.setCanMoveAlone(false);
        Logger.decreaseTabulation();
    }

    /**
     * Ha az orángután meghal, akkor csak elengedi a kezét mindenkinek.
     */
    @Override
    protected void die() {
    	Logger.increaseTabulation();
        logger.log(this + ".die()");
        releaseHands();
        Logger.decreaseTabulation();
    }

    /**
     * Az orángután ha az álaltkertbe megy, akkor minden mögötte levő állat is az állatkertbe megy.
     */
    @Override
    public void goToZoo() {
    	Logger.increaseTabulation();
        field.removeGameObject();
        if(pullThis != null){
            pullThis.goToZoo();
        }
        Logger.decreaseTabulation();
    }

    /**
     * Az orángutánt egy állattal ütköztetjük, még nem tudjuk milyen objektumról van szó, ezért vissza is kell ütköztetni.
     * @param animal Az állat, amivel ütközik az orángután.
     */
    @Override
    protected void hitByAnimal(Animal animal) {
    	Logger.increaseTabulation();
        logger.log(this+".hitByAnimal(" + animal+ ")");
        animal.hitByOrangutan(this);
        Logger.decreaseTabulation();
    }


    @Override
    public void tick() {

    }
}
