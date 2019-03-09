package internal;

public class Orangutan extends Animal {



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
        setPullThis(panda);
		panda.setPulledBy(this);
        panda.setCanMoveAlone(false);
		
		Field tmp = panda.getField();
		panda.replaceField(field);
		replaceField(tmp);

		panda.getField().setGameObject(panda);
		field.setGameObject(this);
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
        animal.hitByOrangutan(this);
    }


    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not yet tickable");
    }
}
