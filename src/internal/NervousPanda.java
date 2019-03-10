package internal;

public class NervousPanda extends Panda {

    public NervousPanda(Field field) {
        super(field);
    }

    public void scare() {
        if(pulledBy != null){
            pulledBy.releaseHands();
        }
    }


    @Override
    void arcadeMachineRingSoundPlayed() {
        logger.log("Nervous panda was scared.");
        scare();
    }
}
