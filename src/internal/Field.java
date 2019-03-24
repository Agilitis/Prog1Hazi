package internal;

import utility.Logger;

import java.util.ArrayList;

/**
 * Egy mező a játékban. Feladata, hogy tárolja a játékban előforduló gameObjecteket és biztosítsa a mozgásukat,
 * a közöttük lévő kommunikációt és stabil felület legyen, melyen a dolgok tudnak létezni.
 */
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

    /**
     * Fgvény mely megvalósítja a mozgásokat. Egy állat move() fgvénye hívja meg átadva saját magát. A Mező felelőssége
     * eldönteni, hogy ő össze van-e törve, és ha igen akkor meghívja az állat die()-ját.
     * Ha van valaki a mezőn, akkor ütközteti őket.
     * Egyéb esetben elindítja az állat mozgását a replaceField() meghívásával.
     * @param animal    Az állat aki rá akar lépni a mezőre.
     */
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
