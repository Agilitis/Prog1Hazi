package internal;


import java.util.ArrayList;
import java.util.List;

public class Teleport extends Field {
    private ArrayList<Teleport> teleportNeighbours = new ArrayList<>();

    public Teleport(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    @Override
    public void acceptAnimal(Animal animal) {
        Teleport teleportNeighbour = teleportNeighbours.get(0);
        logger.log(this+".acceptAnimal(" + animal + ")");
        teleportNeighbour.teleportHere(animal);
    }

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
