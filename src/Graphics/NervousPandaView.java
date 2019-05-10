package Graphics;

import internal.NervousPanda;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class NervousPandaView extends ObjectView {
    private NervousPanda nervousPanda;
    public NervousPandaView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/nervousPanda.png"));
    }
}
