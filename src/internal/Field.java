package internal;

public class Field {

    protected Field[] neighBours;
    private boolean isDamagable;
    private int life;
    private boolean isBroken;
    private GameObject gameObject;

    public void acceptAnimal(Animal animal) {
        if (!isBroken) {
            if (gameObject != null) {
                gameObject.hitByAnimal(animal);
            }
            else {
                gameObject = animal;
                animal.replaceField(this);
                sufferDamage(1);
            }
        }
        else {
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

    Field[] getNeighbours() {
        return new Field[0];
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
