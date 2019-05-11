package Graphics;

import java.awt.*;

/**
 * Mindenki implementalja akit ki lehet rajzolni.
 */
public interface Drawable {
    /**
     * Ezzel a fgvennyel rajzolja ki mindenki magat.
     * @param g A grafika amivel rajzolni lehet.
     */
    void draw(Graphics g);
}
