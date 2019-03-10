package internal;

public class BigPanda extends Panda {

    public BigPanda(Field field) {
        super(field);
    }

    public void scare() {
        logger.log("Panda: " + this.hashCode() + " was scared! Jumping once.");
        field.sufferDamage(5);
    }

    @Override
    void chocolateVendingMachineBeepSoundPlayed() {
        logger.log("Panda: " + this.hashCode() + "heard a sound from a chochlate machine.");
        this.scare();
    }


}
