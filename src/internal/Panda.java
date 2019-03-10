package internal;


public class Panda extends Animal {
    protected Animal pulledBy;
    public Panda(Field field) {
        super(field);
    }

    public void setPulledBy(Animal animal) {
		pulledBy = animal;
	}

    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
        logger.log("Panda was hit by an Orangutan!");
        orangutan.setPullThis(this);
        pulledBy = orangutan;
        canMoveAlone = false;
    }

    @Override
    protected void hitByPanda(Panda panda) {
        logger.log("Panda was hit by another Panda, doing nothing!");
	    //Pandas don't do anythin when hit by another panda. Intentionally left BLANK.

    }

    //They don't actually die, but go to a nice place.
    @Override
    protected void die() {
        logger.log("Panda 'died'. Not actually dead.");
        field.removeGameObject();
        pulledBy.releaseHands();
    }

    @Override
    public void goToZoo() {
        logger.log("Panda went to Zoo.");
        if(pullThis != null){
            pullThis.goToZoo();
        }
        ///pont
        die();
    }

    @Override
    protected void hitByAnimal(Animal animal) {
        logger.log("Panda was hit by an Animal, hitting back!");
        animal.hitByPanda(this);
    }


    @Override
    public void tick() {
        //some logic to define when
        //witch field exactly needs to be defined
        move(getStepOptions()[0]);
    }

    protected void putToRest(Couch sleepHere) {
	    //Virutal function, we cannot create Panda objects anyway.
    }

    protected void scare() {
        //Virutal function, we cannot create Panda objects anyway.

    }
}
