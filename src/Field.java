public class Field {

    protected Field[] neighBours;
    private boolean isDamagable;
    private int life;
    private boolean isBroken;
    private GameObject gameObject;

    public void acceptAnimal(Animal animal){
        if(!isBroken) {
            if (gameObject != null) {
                gameObject.hitByAnimal(animal);
            } else {
                gameObject = animal;
                animal.replaceField(this);
                sufferDamage(1);
            }
        }else {
            animal.die();
        }
    }

    public void sufferDamage(int damage){
        if (isDamagable){
            life -= damage;
            if (life <= 0){
                isBroken = true;
            }
        }
    }

    public Field[] getNeighbours(){ return new Field[0];}
    public GameObject getGameObject(){return gameObject;}
    protected void removeGameObject(){gameObject = null;}
}
