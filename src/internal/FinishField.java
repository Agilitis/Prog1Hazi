package internal;

import Graphics.Drawable;
import Graphics.FinishFieldView;
import utility.Logger;

import java.io.IOException;

/**
 * A célmező. Ha rálép egy állat azt az állatkertbe küldi.
 */
public class FinishField extends Field {

    public FinishField(String name, int[] coords) {
        super(name, false, 20, coords);
    }

    /**
     * A finishfieldre, ha egy állat lép, akkor azt az állatkertbe küldi.
     * @param animal Az állat, amit az állatkertbe kell küldeni.
     */
    @Override
    public void acceptAnimal(Animal animal) {
    	Logger.increaseTabulation();
        logger.log(this + "." + "acceptAnimal(" + animal + ")");
        animal.steppedOnFinish();
        Logger.decreaseTabulation();
    }

    @Override
    public String toString(){
        return "Name: " + this.name;
    }

    @Override
    public Drawable getDrawable() throws IOException {
        FinishFieldView finishFieldView = new FinishFieldView();
        finishFieldView.setCoordinates(this.coordinates);
        return finishFieldView;
    }

}
