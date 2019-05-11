package Graphics;

import internal.ChocolateVendingMachine;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * A csokiautomata megjeleniteseert felelos.
 */
public class ChocolateMachineView extends ObjectView {
    ChocolateVendingMachine chocolateVendingMachine;
    public ChocolateMachineView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/chocolateMachine.png"));
    }
}
