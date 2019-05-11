package Graphics;

import internal.Teleport;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * A teleport megjeleniteseert felelos.
 */
public class TeleportView extends ObjectView {
    private Teleport teleport;
    public TeleportView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/teleport.png"));
    }
}
