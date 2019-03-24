package internal;

public class ArcadeMachine extends Thing {

    public ArcadeMachine(Field field) {
        super(field);
        counter = 1;
    }

    @Override
    public void doEvent() {
        for(Field neighbour : field.getNeighbours()){
            logger.log(neighbour + ".getGameObject()");
            GameObject gameObject = neighbour.getGameObject();
            logger.log("\t" + gameObject + ".arcadeMachineRingSoundPlayed()");
            gameObject.arcadeMachineRingSoundPlayed();
        }
    }
}
