package internal;

/**
 * Olyan panda aki a játékautómata hangjára elengedi a többiek kezét. Másra nem reagál.
 */
public class NervousPanda extends Panda {

    public NervousPanda(Field field) {
        super(field);
    }

    /**
     * Ha meghallja a játékautómata hangját hívódik. Elengedi a többi panda kezét, mely hatására a sor felbomlik.
     */
    public void scare() {
        logger.log(this +".scare()");
        logger.log("\t"+this+".releaseHands()");
        releaseHands();
    }

    /**
     * Ezt a fgvényt hívja az ArcadeMachine mikor kiadja a hangot. Meghívja a scare()-t.
     */
    @Override
    void arcadeMachineRingSoundPlayed() {
        logger.log(this + "arcadeMachineRingSoundPlayed()");
        scare();
    }
}
