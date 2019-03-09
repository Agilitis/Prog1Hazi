package Internal;

public class NervousPanda extends Panda {

    public void scare() {
         pulledBy.releaseHands();
    }

    @Override
    void chocolateVendingMachineBeepSoundPlayed() {
        scare();
    }
}
