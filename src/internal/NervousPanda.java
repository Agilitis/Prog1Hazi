package internal;

public class NervousPanda extends Panda {

    public NervousPanda(Field field) {
        super(field);
    }

    public void scare() {
        logger.log(this +".scare()");
        if(pulledBy != null){
            logger.log(pulledBy+".releaseHands()");
            pulledBy.releaseHands();
        }
    }


    @Override
    void arcadeMachineRingSoundPlayed() {
        logger.log(this + "arcadeMachineRingSoundPlayed()");
        scare();
    }
}
