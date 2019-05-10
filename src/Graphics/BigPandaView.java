package Graphics;

import internal.BigPanda;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BigPandaView extends ObjectView {
    private BigPanda bigPanda;
    public BigPandaView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/bigPanda.png"));
    }
}
