package Graphics;

import internal.Field;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BrokenFieldView extends ObjectView{
    private Field field;
    public BrokenFieldView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/brokenField.png"));
    }
}
