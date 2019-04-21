package utility;

import skeletontest.SkeletonTestMain;

import java.lang.reflect.Method;

/**
 * Leforditja a user altal adott parancsot
 */
public final class CommandInterpreter {
    private CommandInterpreter(){}

    public static Method getMethodToInvoke(){
        try {
            return SkeletonTestMain.class.getMethod("test", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
