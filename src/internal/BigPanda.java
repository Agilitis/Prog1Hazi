package internal;

public class BigPanda extends Panda {

    public BigPanda(Field field) {
        super(field);
    }

    public void scare() {
        logger.log("\t"+this+".scare()");
        field.sufferDamageByAnimal(5, this);
    }

    @Override
    void chocolateVendingMachineBeepSoundPlayed() {
        this.scare();
    }


}
