public abstract class Animal extends GameObject {
    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    protected int pointValue;

    void setPullThis(Animal pullThis) {
        this.pullThis = pullThis;
    }

    Animal pullThis;

    void setCanMoveAlone(boolean canMoveAlone) {
        this.canMoveAlone = canMoveAlone;
    }

    boolean canMoveAlone;

    protected void replaceField(Field newPlace) {
        field.removeGameObject();

        if (pullThis != null) {
            pullThis.replaceField(field);
        }

        field = newPlace;
    }

    void releaseHands() {
        if (pullThis != null) {
            pullThis.releaseHands();
            pullThis = null;
        }
    }

    void move(Field moveHere) {
        if (canMoveAlone) {
            moveHere.acceptAnimal(this);
        }
    }

    protected abstract void hitByOrangutan(Orangutan orangutan);

    protected abstract void hitByPanda(Panda panda);

    Field[] getStepOptions() {
        return new Field[0];
    }

    protected abstract void die();


    public abstract void goToZoo();
}