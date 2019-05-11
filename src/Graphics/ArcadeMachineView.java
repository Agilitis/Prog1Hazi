package Graphics;

import internal.ArcadeMachine;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Az arcadeMachine megjeleniteseert felelos. Kirajzolja a kepet.
 */
public class ArcadeMachineView extends ObjectView{
    private ArcadeMachine arcadeMachine;
    public ArcadeMachineView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/arcadeMachine.png"));
    }
}
