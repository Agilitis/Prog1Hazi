package Internal;

public class ChocolateVendingMachine extends Thing {

    @Override
    void doEvent() {
        for(Field neighbour : field.getNeighbours()){
            GameObject gameObject = neighbour.getGameObject();
            gameObject.chocolateVendingMachineBeepSoundPlayed();
        }
    }
}
