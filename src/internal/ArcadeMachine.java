package internal;

public class ArcadeMachine extends Thing {

    public ArcadeMachine(Field field) {
        super(field);
    }

    @Override
    public void doEvent() {
        logger.log("Arcade machine making noise at field: " + this.getField());
        for(Field neighbour : field.getNeighbours()){
            logger.log("Neighbour notified for arcade machine sound at: " + neighbour.hashCode());
            GameObject gameObject = neighbour.getGameObject();
            gameObject.arcadeMachineRingSoundPlayed();
        }
    }
}
