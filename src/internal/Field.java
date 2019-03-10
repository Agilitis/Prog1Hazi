package internal;

import utility.Logger;

import java.util.ArrayList;

public class Field {
    Logger logger = new Logger();
    ArrayList<Field> neighBours = new ArrayList<>();
    private boolean isDamagable;
    private int life;
    private boolean isBroken;
    private GameObject gameObject;

    public Field(boolean isDamagable, int life) {
        this.isDamagable = isDamagable;
        this.life = life;
    }

    public void addNeighbour(Field neighbour){
        neighBours.add(neighbour);
    }

    public void acceptAnimal(Animal animal) {
        logger.log("Accepting animal: " + animal.hashCode());
        if (!isBroken) {
            if (gameObject != null) {
                gameObject.hitByAnimal(animal);
            }
            else {
                logger.log("Accepting animal without any problem: " + animal.hashCode());
                gameObject = animal;
                animal.replaceField(this);
                sufferDamage(1);
            }
        }
        else {
            logger.log("Animal stepped on broken field.");
            animal.die();
        }
    }

    void sufferDamage(int damage) {
        if (isDamagable) {
            life -= damage;
            if (life <= 0) {
                isBroken = true;
            }
        }
    }

    ArrayList<Field> getNeighbours() {
        return neighBours;
    }

    GameObject getGameObject() {
        return gameObject;
    }

    void removeGameObject() {
        gameObject = null;
    }

	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}
}
