package Graphics;

import internal.Game;
import internal.Orangutan;
import internal.Player;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class OrangutanView extends ObjectView{
    private Orangutan orangutan;

    public OrangutanView(Orangutan o) throws IOException {
        InputStream inputStream;
        this.orangutan = o;
        this.image = ImageIO.read(new File("input/ObjectGraphics/orangutan.png"));
    }

    @Override
    public void draw(Graphics g){
        if(Game.getInstance().getSelectedPlayer() != null)
        {
            if(this.orangutan.equals(Game.getInstance().getSelectedPlayer().getOrangutan()))
            {
                g.setColor(Color.RED);
                g.drawString("Selected",coordinates[0],coordinates[1]);
            }
        }
        g.setColor(Color.BLACK);
        g.drawImage(image, coordinates[0], coordinates[1], null);
    }
}
