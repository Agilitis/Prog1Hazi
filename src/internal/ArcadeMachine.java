package internal;

/**
 * A játékgép. Tulajdonsága, hogy véletlenszerűen hangot ad ki, mely a szomszédos mezőkön hallatszik és a
 * pandák reagálhatnak rá.
 */
public class ArcadeMachine extends Thing {

    public ArcadeMachine(Field field) {
        super(field);
        counter = 1;
    }

    /**
     * Fgvény, mely megvalósítja a hang kiadását. Minden szomszédos mezőtől elkéri az ott található gameObjectet és
     * meghívja az arcadeMachineRingSoundPlayed() fgvényét.
     */
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
