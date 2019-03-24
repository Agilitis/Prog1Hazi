package internal;

import utility.Logger;

import java.util.ArrayList;

public class Field {
    Logger logger = new Logger();
    ArrayList<Field> neighBours = new ArrayList<>();
    private boolean isDamagable;

    public Field(){}

    public int getLife() {
        return life;
    }

    private int life;

    private void setBroken(boolean broken) {
        logger.log(this+".setBroken(" + true + ")");
        isBroken = broken;
    }

    private boolean isBroken;
    private GameObject gameObject;

    public Field(boolean isDamagable, int life) {
        this.isDamagable = isDamagable;
        this.life = life;
    }

    public void addNeighbour(Field neighbour) {
        neighBours.add(neighbour);
    }

    public void acceptAnimal(Animal animal) {
        logger.log(this+".acceptAnimal(" + animal + ")");
        if (!isBroken) {
            if (gameObject != null) {
                gameObject.hitByAnimal(animal);
            } else {
                gameObject = animal;
                animal.replaceField(this);
            }
        } else {
            animal.die();
        }
    }

    public void sufferDamage(int damage) {
        if (isDamagable) {
            logger.log(this+".sufferDamage(" + damage + ")");
            life -= damage;
            if (life <= 1) {
                setBroken(true);
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
        if (this.gameObject != null && this.gameObject != gameObject) {
            logger.log("Warning: Replacing !" + gameObject + "  " + this.gameObject);
        }
        this.gameObject = gameObject;
    }


}
