package Graphics;

import internal.SleepyPanda;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SleepyPandaView extends ObjectView {
    private SleepyPanda sleepyPanda;
    public SleepyPandaView() throws IOException {
        InputStream inputStream;
        this.image = ImageIO.read(new File("input/ObjectGraphics/sleepyPanda.png"));
    }
}
