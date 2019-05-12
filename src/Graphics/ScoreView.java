package Graphics;

import internal.Game;
import internal.Player;

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
        Player p = Game.getInstance().getSelectedPlayer();
        String str = "Score: ";
        if(p == null)
        {
            str += "0";
        }
        else
        {
            str += p.getScore();
        }
        Font f = new Font("Arial",0,36);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        g.setColor(Color.red);
        g.drawString(str, coordinates[0], coordinates[1] + fm.getHeight());
    }
}
