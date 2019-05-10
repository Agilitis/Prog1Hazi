package Graphics;

import internal.Orangutan;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class OrangutanView extends ObjectView{
    private Orangutan orangutan;
    public OrangutanView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/orangutan.png"));
    }
}
