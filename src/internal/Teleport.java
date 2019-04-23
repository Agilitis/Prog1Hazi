package internal;


import java.util.ArrayList;
import java.util.List;

import utility.Logger;

/**
 * Különleges mező. Nem lehet rálépni, ha megkísérlik az állatot egy másik helyre teleportálja.
 */
public class Teleport extends Field {
    private ArrayList<Teleport> teleportNeighbours = new ArrayList<>();

    public Teleport(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    public Teleport(){}

    @Override
    public String toString() {
        return String.format("name: %s",this.name) + super.toString();
    }

    /**
     * Az egyik teleportszomszédjának meghívja a teleportHere()-fgvényét a kapott állattal.
     * @param animal    Az állat aki rá akar lépni a mezőre.
     */
    @Override
    public void acceptAnimal(Animal animal) {
    	Logger.increaseTabulation();
        Teleport teleportNeighbour = teleportNeighbours.get(0);
        logger.log(this+".acceptAnimal(" + animal + ")");
        teleportNeighbour.teleportHere(animal);
        Logger.decreaseTabulation();
    }

    /**
     * Az első nem üres mezőre kirakja az állatot.
     * @param animal az animal, amit ki kell raknia az első nem üres mezőre.
     */
    private void teleportHere(Animal animal) {
    	Logger.increaseTabulation();
        for(Field neighbour: neighBours){
            if(neighbour.getGameObject() == null){
                logger.log(this+".teleportHere(" + animal + ")");

                animal.replaceField(neighbour);
                return;
            }
        }
        Logger.decreaseTabulation();
    }

    public List<Teleport> getTeleportNeighbours() {
        return teleportNeighbours;
    }

    public void addTeleportNeighbour(Teleport teleport){
        teleportNeighbours.add(teleport);
    }
}
