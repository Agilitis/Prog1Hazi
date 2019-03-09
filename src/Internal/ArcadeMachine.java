package Internal;

public class ArcadeMachine extends Thing {

    @Override
    void doEvent() {
        for(Field neighbour : field.getNeighbours()){
            GameObject gameObject = neighbour.getGameObject();
            gameObject.arcadeMachineRingSoundPlayed();
        }
    }
}
