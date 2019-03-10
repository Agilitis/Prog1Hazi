package internal;

public class Orangutan extends Animal {


    public Orangutan(Field field) {
        super(field);
    }

    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
        //This is left blank in order to emphasize that an Orangutan hitBy an Orangutan does NOTHING.
    }

    @Override
    protected void hitByPanda(Panda panda) {
		if (pullThis != null) {
			pullThis.setPulledBy(panda);
			panda.setPullThis(pullThis);
		}
        Field tmp = panda.getField();
        panda.replaceField(this.field);
        this.replaceField(tmp);

        pullThis = panda;
		pullThis.setPulledBy(this);
        pullThis.setCanMoveAlone(false);

    }

    @Override
    protected void die() {
        releaseHands();
    }

    @Override
    public void goToZoo() {
        field.removeGameObject();
        if(pullThis != null){
            pullThis.goToZoo();
        }
    }

    @Override
    protected void hitByAnimal(Animal animal) {
        logger.log(this + " has been hit by " + animal + " hitting back!");
        animal.hitByOrangutan(this);
    }


    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not yet tickable");
    }
}
