package internal;


import Graphics.Drawable;
import Graphics.TeleportView;
import utility.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Különleges mező. Nem lehet rálépni, ha megkísérlik az állatot egy másik helyre teleportálja.
 */
public class Teleport extends Field {
    private ArrayList<Teleport> teleportNeighbours = new ArrayList<>();

    public Teleport(String name, int[] coords) {
        super(name, false, 20, coords);
    }

    public Teleport(){}

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

    @Override
    public String toString(){
        return "Name: " + this.name;
    }

    @Override
    public Drawable getDrawable() throws IOException {
        TeleportView teleportView = new TeleportView();
        teleportView.setCoordinates(this.coordinates);
        return teleportView;
    }
}
