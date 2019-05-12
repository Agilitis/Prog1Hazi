package Graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Kirajzolja a játékos pillanatnyi pontjait.
 */
public class ScoreView extends ObjectView {

    public ScoreView(int x,int y)
    {
        this.setCoordinates(new int[]{x,y});
    }

    @Override
    public void draw(Graphics g) {
        String str = "Score: 0";
        Font f = new Font("Arial",0,36);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        g.setColor(Color.yellow);
        g.drawString(str, coordinates[0], coordinates[1] + fm.getHeight());
    }
}
