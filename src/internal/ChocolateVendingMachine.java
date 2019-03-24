package internal;

public class ChocolateVendingMachine extends Thing {

    public ChocolateVendingMachine(Field field) {
        super(field);
    }

    @Override
    public void doEvent() {
        for(Field neighbour : field.getNeighbours()){
            GameObject gameObject = neighbour.getGameObject();
            logger.log(gameObject+".chocolateVendingMachineBeepSoundPlayed()");
            gameObject.chocolateVendingMachineBeepSoundPlayed();
        }
    }
}
