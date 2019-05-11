package Graphics;

import internal.Panda;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Kirajzolja a panda objektumot.
 */
public class PandaView extends ObjectView {
    private Panda panda;
    public PandaView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/panda.png"));
    }
}
