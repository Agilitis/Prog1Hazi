package Graphics;

import internal.Field;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * A field megjeleniteseert felelos.
 */
public class FieldView extends ObjectView{
    private Field field;

    public void setField(Field field) {
        this.field = field;
    }

    public FieldView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/field.png"));
    }

    /**
     * Kirajzolja a fieldet es berajzolja a szomszedsagokat.
     * @param g A grafika amivel lehet rajzolni.
     */
    @Override
    public void draw(Graphics g){
        g.drawImage(image, coordinates[0], coordinates[1], null);
        for(int i = 0; i < field.getNeighbours().size(); i++){
            g.setColor(Color.black);
            g.drawLine(coordinates[0] + 60, coordinates[1] + 60, field.getNeighbours().get(i).getCoordinates()[0] + 60, field.getNeighbours().get(i).getCoordinates()[1] + 60);
        }
    }
}
