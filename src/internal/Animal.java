package internal;

public abstract class Animal extends GameObject {
    public Animal(Field field) {
        super(field);
    }

    public Animal(){}

    int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    private int pointValue;

    public void setPullThis(Panda pullThis) {

        pullThis.setPulledBy(this);
        this.pullThis = pullThis;
        pullThis.canMoveAlone = false;
    }

    public Animal getPullThis() {
        return pullThis;
    }

    public boolean canMoveAlone() {
        return canMoveAlone;
    }

    Panda pullThis;

    void setCanMoveAlone(boolean canMoveAlone) {
        this.canMoveAlone = canMoveAlone;
}

    boolean canMoveAlone = true;

    @Override
    protected void replaceField(Field newField) {
        this.field.removeGameObject();
        logger.log("\t\t"+this + ".replaceField("+newField+")");

        if (this.pullThis != null) {
            this.pullThis.replaceField(field);
        }
        this.field = newField;
        this.field.setGameObject(this);
        newField.sufferDamageByAnimal(1, this);
    }

    void releaseHands() {
        logger.log("\t" + this +".releaseHands()");
        if (pullThis != null) {
            pullThis.releaseHands();
            pullThis = null;
        }
    }

    public void move(Field moveHere) {
        logger.log(this+".move(" + moveHere + ")");

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
