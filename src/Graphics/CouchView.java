package Graphics;

import internal.Couch;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CouchView extends ObjectView {
    private Couch couch;
    public CouchView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/couch.png"));
    }
}
