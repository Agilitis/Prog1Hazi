package internal;

import Graphics.Drawable;
import Graphics.FinishFieldView;
import utility.Logger;

/**
 * A célmező. Ha rálép egy állat azt az állatkertbe küldi.
 */
public class FinishField extends Field {

    public FinishField(boolean isDamagable, int life) {
        super(isDamagable, life);
    }

    /**
     * A finishfieldre, ha egy állat lép, akkor azt az állatkertbe küldi.
     * @param animal Az állat, amit az állatkertbe kell küldeni.
     */
    @Override
    public void acceptAnimal(Animal animal) {
    	Logger.increaseTabulation();
        logger.log(this + "." + "acceptAnimal(" + animal + ")");
        logger.log("\t" + animal + ".goToZoo()");
        animal.goToZoo();
        Logger.decreaseTabulation();
    }

    @Override
    public String toString(){
        return "Name: " + this.name;
    }

    @Override
    public Drawable getDrawable(){
        FinishFieldView finishFieldView = new FinishFieldView();
        finishFieldView.setCoordinates(this.coordinates);
        return finishFieldView;
    }

}
