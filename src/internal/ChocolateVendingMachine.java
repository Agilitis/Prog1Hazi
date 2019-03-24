package internal;

/**
 * A játékban a csokiautómata. Véletlenszerűen kiadja a hangját, mely a szomszédos mezőkön hallatszik és a
 * pandák reagálhatnak rá.
 */
public class ChocolateVendingMachine extends Thing {

    public ChocolateVendingMachine(Field field) {
        super(field);
    }

    /**
     * Fgvény, mely megvalósítja a hang kiadását. Minden szomszédos mezőtől elkéri az ott található gameObjectet és
     * meghívja a chocolateVendingMachineBeepSoundPlayed() fgvényét.
     */
    @Override
    public void doEvent() {
        for(Field neighbour : field.getNeighbours()){
            GameObject gameObject = neighbour.getGameObject();
            logger.log(gameObject+".chocolateVendingMachineBeepSoundPlayed()");
            gameObject.chocolateVendingMachineBeepSoundPlayed();
        }
    }
}
