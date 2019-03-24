package internal;

/**
 * Álltalános panda. Nem reagál a Thingek eseményeire. Ha nem fogják a kezét véletlenszerűen mászkál a pályán.
 * Ha ütközik egy orángutánnal, az megfogja a kezét és onnantól csak akkor lép ha az orángután maga után húzza.
 */
public class Panda extends Animal {
    protected Animal pulledBy;
    public Panda(Field field) {
        super(field);
    }

    public Panda(){}

    public void setPulledBy(Animal animal) {
		pulledBy = animal;
	}

    /**
     * Ha nekimegy egy orángutánnak, akkor hívódik. Beállítja a mezői a megfelelő értékekre.
     * @param orangutan Az orángután akivel ütközött
     */
    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
        logger.log(this+".hitByOrangutan(" + orangutan + ")");

        orangutan.setPullThis(this);
        pulledBy = orangutan;
        canMoveAlone = false;
    }

    /**
     * Ha pandával ütközik akkor hívódik. Nem csinál semmit, mmivel nem reagál másik pandával való ütközésre.
     * @param panda
     */
    @Override
    protected void hitByPanda(Panda panda) {
        logger.log(this+".hitByPanda(" + panda + ")");
	    //Pandas don't do anythin when hit by another panda. Intentionally left BLANK.

    }

    /**
     * Ha összetörik alatta egy csempe, vagy egy összetört csempére lép akkor hívódik. Leveszi magát a csempéről
     * és felbontja a mogotte lévő pandacsapatot ha van ilyen.
     */
    //They don't actually die, but go to a nice place.
    @Override
    protected void die() {
        logger.log(this+".die()");
        field.removeGameObject();
        if(pulledBy != null){
            pulledBy.releaseHands();
        }
    }

    /**
     * Leveszi a pandát a mezőről, pontot ad a játékosnak és végul meghívja a die()-t. Ha van mögötte panda, akit
     * húz annak is meghívja a fgvényét.
     */
    @Override
    public void goToZoo() {
        logger.log("\t"+this+".goToZoo()");
        if(pullThis != null){
            pullThis.goToZoo();
        }
        ///pont
        die();
    }

    /**
     * Akkor hívódik, ha nekimegy egy animal. Meghívja az animalnak a hitByPanda()- fgvényét.
     * @param animal Az állat akivel ütközött.
     */
    @Override
    protected void hitByAnimal(Animal animal) {
        logger.log(this +".hitByAnimal("+animal+")");
        animal.hitByPanda(this);
    }

    /**
     * A véletlenszerű mozgást valósítja meg. Bizonyos időnként meghívja a move()-t, a lehetséges célmezők
     * egyikére.
     */
    @Override
    public void tick() {
        //some logic to define when
        //witch field exactly needs to be defined
        move(getStepOptions()[0]);
    }

    /**
     * Leszármazott használja.
     * @param sleepHere A fotel ahova le lehet ülni.
     */
    protected void putToRest(Couch sleepHere) {
	    //Virutal function, we cannot create Panda objects anyway.
    }

    /**
     * Leszármazott használja.
     */
    protected void scare() {
        //Virutal function, we cannot create Panda objects anyway.

    }
}
