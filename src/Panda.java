public class Panda extends Animal {
    protected Animal pulledBy;

	public void setPulledBy(Animal animal) {
		pulledBy = animal;
	}

    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
        orangutan.setPullThis(this);
        pulledBy = orangutan;
        canMoveAlone = false;
    }

    @Override
    protected void hitByPanda(Panda panda) {

    }

    //They don't actually die, but go to a nice place.
    @Override
    protected void die() {
        field.removeGameObject();
        pulledBy.releaseHands();
    }

    @Override
    public void goToZoo() {
        if(pullThis != null){
            pullThis.goToZoo();
        }
        ///pont
        die();
    }

    @Override
    protected void hitByAnimal(Animal animal) {
        animal.hitByPanda(this);
    }


    @Override
    public void tick() {
        //some logic to define when
        //witch field exactly needs to be defined
        move(getStepOptions()[0]);
    }

    protected void putToRest(Couch sleepHere) {
    }

    protected void scare() {
    }
}
