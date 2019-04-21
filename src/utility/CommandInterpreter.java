package utility;

import skeletontest.SkeletonTestMain;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Leforditja a user altal adott parancsot
 */
public final class CommandInterpreter {
    private CommandInterpreter(){}
    private static ArrayList<Object> parameters = new ArrayList<>();

    /**
     * Determine witch method to invoke, and set up parameters
     * @return  A fgveny amit meg kell hivni a parancs vegrehajtasahoz
     */
    public static Method getMethodToInvoke(){
        try {
            parameters.add("lol, it works!");
            parameters.add(null);
            parameters.add(null);
            parameters.add(null);
            return SkeletonTestMain.class.getDeclaredMethod("test", String.class, Object.class, Object.class, Object.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Object> getParameters() {
        return parameters;
    }
}
