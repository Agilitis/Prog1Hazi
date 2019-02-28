public abstract class Animal  extends GameObject{

    public void setPullThis(Animal pullThis) {
        this.pullThis = pullThis;
    }

    protected Animal pullThis;

    public void setCanMoveAlone(boolean canMoveAlone) {
        this.canMoveAlone = canMoveAlone;
    }

    protected boolean canMoveAlone;

    protected void replaceField(Field newPlace){
        field.removeGameObject();
        if(pullThis != null){
            pullThis.replaceField(field);
        }
        field = newPlace;
    }
    protected void releaseHands(){
        if(pullThis!= null){
            pullThis.releaseHands();
            pullThis = null;
        }
    }
    protected void move(Field moveHere) {
        if(canMoveAlone) {
            moveHere.acceptAnimal(this);
        }
    }
    protected abstract void hitByOrangutan(Orangutan orangutan);
    protected abstract void hitByPanda(Panda panda);
    protected Field[] getStepOptions(){ return new Field[0];}

    @Override
    protected void die() {
        field.removeGameObject();
        pullThis = null;
    }
}
