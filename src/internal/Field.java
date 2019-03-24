package internal;

import utility.Logger;

import java.util.ArrayList;

public class Field {
    Logger logger = new Logger();
    ArrayList<Field> neighBours = new ArrayList<>();

    public boolean isDamagable() {
        return isDamagable;
    }

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
        if(life <=0){
            setBroken(true);
        }else{
            this.life = life;
        }

    }

    public void addNeighbour(Field neighbour) {
        neighBours.add(neighbour);
    }

    public void acceptAnimal(Animal animal) {
        logger.log("\t"+this+".acceptAnimal(" + animal + ")");

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

    /**
     * Egy állat sebzést okoz a mezőnek, ha a mező összetörik, akkor az állat utána, meghal.
     * @param damage a sebzés mértéke
     * @param byAnimal az állat, amely a sebzést okozta
     */
    public void sufferDamageByAnimal(int damage, Animal byAnimal) {
        if (isDamagable) {
            logger.log(this+".sufferDamageByAnimal(" + damage + ")");
            life -= damage;
            if (life <= 1) {
                setBroken(true);
                byAnimal.die();
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
