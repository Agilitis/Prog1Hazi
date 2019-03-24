package utility;

/**
 * A fgvényhívások kiírására használható osztály.
 */
public class Logger {

    /**
     * Ez a fgvény írja ki az üzenetet.
     * @param message
     */
    public void log(String message) {
        System.out.print("\t"+message+"\n");
    }

}
