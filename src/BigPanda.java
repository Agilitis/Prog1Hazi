public class BigPanda extends Panda {

    public void scare() {
        field.sufferDamage(5);
    }

    @Override
    void chocolateVendingMachineBeepSoundPlayed() {
        this.scare();
    }


}
