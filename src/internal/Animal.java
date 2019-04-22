package internal;

import utility.Logger;

/**
 * Absztrakt osztály. Egy álltalános állatot reprezentál.
 */
public abstract class Animal extends GameObject {
    public Animal getPulledBy() {
        return pulledBy;
    }

    public void setPulledBy(Animal pulledBy) {
        this.pulledBy = pulledBy;
    }

    protected Animal pulledBy;

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

    /**
     * Beállít az Animalnak egy olyan Pandát, amit húzhat.
     * @param pullThis Egy panda, amit húzhat az animal maga után, ha mozog.
     */
    public void setPullThis(Panda pullThis) {
    	Logger.increaseTabulation();
        pullThis.setPulledBy(this);
        this.pullThis = pullThis;
        pullThis.canMoveAlone = false;
        Logger.decreaseTabulation();
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

    /**
     * A mozgást logikailag befejezi, ekkroa már mindent megvizsgált a controller, hogy mozoghat-e ide animal.
     * @param newField Az új mező, ahova az állat lép.
     */
    @Override
    protected void replaceField(Field newField) {
    	Logger.increaseTabulation();
        this.field.removeGameObject();
        logger.log(this + ".replaceField("+newField+")");

        if (this.pullThis != null) {
            this.pullThis.replaceField(field);
        }
        this.field = newField;
        this.field.setGameObject(this);
        newField.sufferDamageByAnimal(1, this);
        Logger.decreaseTabulation();
    }

    /**
     * Rekurzívan elengedik egymás kezét az állatok.
     */
    public void releaseHands() {
    	Logger.increaseTabulation();
        logger.log(this +".releaseHands()");
        if (pullThis != null) {
            pullThis.releaseHands();
            pullThis = null;
        }
        Logger.decreaseTabulation();
    }

    /**
     * A mozgást elindítja, ekkor még semmi nem dőlhet el a mozgásról.
     * @param moveHere A mező ahova a mozgást indítja a controller.
     */
    public void move(Field moveHere) {
    	Logger.increaseTabulation();
        logger.log(this+".move(" + moveHere + ")");

        if (canMoveAlone) {
            moveHere.acceptAnimal(this);
        }
        Logger.decreaseTabulation();
    }

    protected abstract void hitByOrangutan(Orangutan orangutan);

    protected abstract void hitByPanda(Panda panda);

    Field[] getStepOptions() {
        return new Field[0];
    }

    protected abstract void die();

    public abstract void goToZoo();
}
