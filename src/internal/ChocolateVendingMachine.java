package internal;

public class ChocolateVendingMachine extends Thing {

    public ChocolateVendingMachine(Field field) {
        super(field);
    }

    @Override
    public void doEvent() {
        logger.log("Choclate vending machine " + this.hashCode() + " making sound!");
        for(Field neighbour : field.getNeighbours()){
            GameObject gameObject = neighbour.getGameObject();
            gameObject.chocolateVendingMachineBeepSoundPlayed();
        }
    }
}
