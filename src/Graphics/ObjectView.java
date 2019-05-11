package Graphics;

import java.awt.*;

/**
 * Absztrakt osztaly, a megjelenites kozos dolgait tarolja.
 */
public abstract class ObjectView implements Drawable{
    protected Image image;
    protected int[] coordinates = new int[2];

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Kirajzolja a kepet a megadott koordinatakra.
     * @param g A grafika amivel rajzolni lehet.
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, coordinates[0], coordinates[1], null);
    }
}
