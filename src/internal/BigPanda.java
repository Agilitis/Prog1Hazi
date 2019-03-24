package internal;

public class BigPanda extends Panda {

    public BigPanda(Field field) {
        super(field);
    }

    public void scare() {
        logger.log(this+".scare()");
        field.sufferDamage(5);
    }

    @Override
    void chocolateVendingMachineBeepSoundPlayed() {
        logger.log(this+".choclateVendingMachineBeepSoundPlayed()");
        this.scare();
    }


}
