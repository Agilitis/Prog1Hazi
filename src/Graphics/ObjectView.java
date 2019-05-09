package Graphics;

import java.awt.*;

public abstract class ObjectView implements Drawable{
    protected Image image;
    protected int[] coordinates = new int[2];

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, coordinates[0], coordinates[1], null);
    }
}
