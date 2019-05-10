package utility;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Leforditja a user altal adott parancsot
 */
public final class CommandInterpreter {
    private CommandInterpreter(){}
    private static ArrayList<Object> parameters = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final int COMMAND_PARAMS = 4;
    private static final String COMMAND_SEPARATOR = "--";

    public static ArrayList<Object> getParameters() {
        return parameters;
    }
}
