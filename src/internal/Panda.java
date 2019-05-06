package internal;

import utility.Logger;

/**
 * Ă�lltalĂˇnos panda. Nem reagĂˇl a Thingek esemĂ©nyeire. Ha nem fogjĂˇk a kezĂ©t vĂ©letlenszerĹ±en mĂˇszkĂˇl a pĂˇlyĂˇn.
 * Ha ĂĽtkĂ¶zik egy orĂˇngutĂˇnnal, az megfogja a kezĂ©t Ă©s onnantĂłl csak akkor lĂ©p ha az orĂˇngutĂˇn maga utĂˇn hĂşzza.
 */
public class Panda extends Animal {
    public Panda(Field field) {
        super(field);
    }

    public Panda(){}


    /**
     * Ha nekimegy egy orĂˇngutĂˇnnak, akkor hĂ­vĂłdik. BeĂˇllĂ­tja a mezĹ‘i a megfelelĹ‘ Ă©rtĂ©kekre.
     * @param orangutan Az orĂˇngutĂˇn akivel ĂĽtkĂ¶zĂ¶tt
     */
    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
    	Logger.increaseTabulation();
        logger.log(this+".hitByOrangutan(" + orangutan + ")");
        if(orangutan.getStepsBeforeCatching() <= 0) {
            orangutan.setPullThis(this);
            pulledBy = orangutan;
            canMoveAlone = false;
        }
        Logger.decreaseTabulation();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Ha pandĂˇval ĂĽtkĂ¶zik akkor hĂ­vĂłdik. Nem csinĂˇl semmit, mmivel nem reagĂˇl mĂˇsik pandĂˇval valĂł ĂĽtkĂ¶zĂ©sre.
     * @param panda
     */
    @Override
    protected void hitByPanda(Panda panda) {
    	Logger.increaseTabulation();
        logger.log(this+".hitByPanda(" + panda + ")");
        Logger.decreaseTabulation();
	    //Pandas don't do anythin when hit by another panda. Intentionally left BLANK.

    }

    /**
     * Ha Ă¶sszetĂ¶rik alatta egy csempe, vagy egy Ă¶sszetĂ¶rt csempĂ©re lĂ©p akkor hĂ­vĂłdik. Leveszi magĂˇt a csempĂ©rĹ‘l
     * Ă©s felbontja a mogotte lĂ©vĹ‘ pandacsapatot ha van ilyen.
     */
    //They don't actually die, but go to a nice place.
    @Override
    protected void die() {
    	Logger.increaseTabulation();
        logger.log(this+".die()");
        if(field != null) {
            field.removeGameObject();
        }
        if(pulledBy != null){
            pulledBy.releaseHands();
        }
        Logger.decreaseTabulation();
    }

    /**
     * Leveszi a pandĂˇt a mezĹ‘rĹ‘l, pontot ad a jĂˇtĂ©kosnak Ă©s vĂ©gul meghĂ­vja a die()-t. Ha van mĂ¶gĂ¶tte panda, akit
     * hĂşz annak is meghĂ­vja a fgvĂ©nyĂ©t.
     */
    @Override
    public void goToZoo() {
    	Logger.increaseTabulation();
        logger.log(this+".goToZoo()");
        if(pullThis != null){
            pullThis.goToZoo();
        }
        ///pont
        die();
        Logger.decreaseTabulation();
    }

    /**
     * Akkor hĂ­vĂłdik, ha nekimegy egy animal. MeghĂ­vja az animalnak a hitByPanda()- fgvĂ©nyĂ©t.
     * @param animal Az Ăˇllat akivel ĂĽtkĂ¶zĂ¶tt.
     */
    @Override
    protected void hitByAnimal(Animal animal) {
    	Logger.increaseTabulation();
        logger.log(this +".hitByAnimal("+animal+")");
        animal.hitByPanda(this);
        Logger.decreaseTabulation();
    }

    /**
     * A vĂ©letlenszerĹ± mozgĂˇst valĂłsĂ­tja meg. Bizonyos idĹ‘nkĂ©nt meghĂ­vja a move()-t, a lehetsĂ©ges cĂ©lmezĹ‘k
     * egyikĂ©re.
     */
    @Override
    public void tick() {
    	Logger.increaseTabulation();
        //some logic to define when
        //witch field exactly needs to be defined
        move(getStepOptions().get(0));
        Logger.decreaseTabulation();
    }

    /**
     * LeszĂˇrmazott hasznĂˇlja.
     * @param sleepHere A fotel ahova le lehet ĂĽlni.
     */
    protected void putToRest(Couch sleepHere) {
	    //Virutal function, we cannot create Panda objects anyway.
    }

    /**
     * LeszĂˇrmazott hasznĂˇlja.
     */
    protected void scare() {
        //Virutal function, we cannot create Panda objects anyway.

    }

    @Override
    public String toString(){
        return "Name: " + this.name + " " + "Field: " + this.field.getName() + "Pull: " + this.pullThis + "PulledBy: " + this.pulledBy;
    }
}
