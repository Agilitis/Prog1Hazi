package internal;


import java.util.ArrayList;
import java.util.List;

public class Teleport extends Field {
    private ArrayList<Teleport> teleportNeighbours = new ArrayList<>();

    public Teleport(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    public Teleport(){}

    @Override
    public void acceptAnimal(Animal animal) {
        Teleport teleportNeighbour = teleportNeighbours.get(0);
        logger.log(this+".acceptAnimal(" + animal + ")");
        teleportNeighbour.teleportHere(animal);
    }

    /**
     * Az első nem üres mezőre kirakja az állatot.
     * @param animal az animal, amit ki kell raknia az első nem üres mezőre.
     */
    private void teleportHere(Animal animal) {
        for(Field neighbour: neighBours){
            if(neighbour.getGameObject() == null){
                logger.log(this+".teleportHere(" + animal + ")");

                animal.replaceField(neighbour);
                return;
            }
        }
    }

    public List<Teleport> getTeleportNeighbours() {
        return teleportNeighbours;
    }

    public void addTeleportNeighbour(Teleport teleport){
        teleportNeighbours.add(teleport);
    }
}
