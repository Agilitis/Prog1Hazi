package internal;

public class NervousPanda extends Panda {

    public NervousPanda(Field field) {
        super(field);
    }

    public void scare() {
        logger.log(this +".scare()");
        logger.log("\t"+this+".releaseHands()");
        releaseHands();
    }


    @Override
    void arcadeMachineRingSoundPlayed() {
        logger.log(this + "arcadeMachineRingSoundPlayed()");
        scare();
    }
}
