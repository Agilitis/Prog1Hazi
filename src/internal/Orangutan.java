package internal;

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
        logger.log(this+".hitByOrangutan(" + orangutan + ")");
        //This is left blank in order to emphasize that an Orangutan hitBy an Orangutan does NOTHING.
    }

    /**
     * Az orángutánt, ha egy pandával ütköztetjük, akkor ez hívódik meg. Ha az orángután még nem húzott pandát maga után, akkor ezt a pandát berakjuk mögé, ha viszont húzott, akkor a sor végére kerül.
     * @param panda A panda, amivel ütközött az orángután.
     */
    @Override
    protected void hitByPanda(Panda panda) {
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

    }

    /**
     * Ha az orángután meghal, akkor csak elengedi a kezét mindenkinek.
     */
    @Override
    protected void die() {
        logger.log(this + ".die()");
        releaseHands();
    }

    /**
     * Az orángután ha az álaltkertbe megy, akkor minden mögötte levő állat is az állatkertbe megy.
     */
    @Override
    public void goToZoo() {
        field.removeGameObject();
        if(pullThis != null){
            pullThis.goToZoo();
        }
    }

    /**
     * Az orángutánt egy állattal ütköztetjük, még nem tudjuk milyen objektumról van szó, ezért vissza is kell ütköztetni.
     * @param animal Az állat, amivel ütközik az orángután.
     */
    @Override
    protected void hitByAnimal(Animal animal) {
        logger.log(this+".hitByAnimal(" + animal+ ")");
        animal.hitByOrangutan(this);
    }


    @Override
    public void tick() {

    }
}
