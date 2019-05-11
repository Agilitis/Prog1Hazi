package Graphics;

import internal.FinishField;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * A celmezo megjeleniteseert felelos.
 */
public class FinishFieldView extends ObjectView {
    private FinishField finishField;
    public FinishFieldView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/finishField.png"));
    }
}
