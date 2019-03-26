package utility;

/**
 * A fgvényhívások kiírására használható osztály.
 */
public class Logger {

	private static int tabulation;
    /**
     * Ez a fgvény írja ki az üzenetet.
     * @param message
     */
    public void log(String message) {
    	for (int i = 0; i <= tabulation; i++) {
    		System.out.print("\t");
    	}
        System.out.print(message+"\n");
    }
    
    public static void resetTabulation() {
    	tabulation = 0;
    }
    
    public static void increaseTabulation() {
    	tabulation++;
    }
    
    public static void decreaseTabulation() {
    	tabulation--;
    }

}
