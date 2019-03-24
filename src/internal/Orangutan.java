package internal;

public class Orangutan extends Animal {


    public Orangutan(Field field) {
        super(field);
    }

    public Orangutan(){}

    @Override
    protected void hitByOrangutan(Orangutan orangutan) {
        logger.log(this+".hitByOrangutan(" + orangutan + ")");
        //This is left blank in order to emphasize that an Orangutan hitBy an Orangutan does NOTHING.
    }

    @Override
    protected void hitByPanda(Panda panda) {
        logger.log(this+".hitByPanda(" + panda + ")");
        if (pullThis != null) {
			pullThis.setPulledBy(panda);
			panda.setPullThis(pullThis);
		}
        Field tmp = panda.getField();
        panda.replaceField(this.field);
        this.replaceField(tmp);

        setPullThis(panda);
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
        logger.log(this+".hitByAnimal(" + animal+ ")");
        animal.hitByOrangutan(this);
    }


    @Override
    public void tick() {
        Field moveHere = field.getNeighbours().get(0);
        move(moveHere);
    }
}
