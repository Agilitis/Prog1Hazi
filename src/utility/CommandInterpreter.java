package utility;

import internal.Game;
import internal.Level;
import skeletontest.SkeletonTestMain;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * Determine witch method to invoke, and set up parameters
     * @return  A fgveny amit meg kell hivni a parancs vegrehajtasahoz
     */
    public static Method getMethodToInvoke(){
        try {
            parameters.clear();
            ArrayList<String> splittedCommand = new ArrayList<>(Arrays.asList(scanner.nextLine().replaceAll("\\s+","").split(COMMAND_SEPARATOR)));
            int actualParamOfCommand = splittedCommand.size();

            Method methodToInvoke;
            switch (splittedCommand.get(0)){
                case "Addanimal":
                    switch (splittedCommand.get(1)){
                        case "panda":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            parameters.add(splittedCommand.get(4));
                            methodToInvoke = SkeletonTestMain.class.getMethod("addPanda", Level.class, String.class, String.class, String.class);
                            break;
                        case "sleepypanda":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            parameters.add(splittedCommand.get(4));

                            methodToInvoke = SkeletonTestMain.class.getMethod("addSleepyPanda", Level.class, String.class, String.class, String.class);
                            break;
                        case "bigpanda":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            parameters.add(splittedCommand.get(4));
                            methodToInvoke = SkeletonTestMain.class.getMethod("addBigPanda", Level.class, String.class, String.class, String.class);
                            break;
                        case "nervouspanda":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            parameters.add(splittedCommand.get(4));
                            methodToInvoke = SkeletonTestMain.class.getMethod("addNervousPanda", Level.class, String.class, String.class, String.class);
                            break;
                        case "orangutan":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            methodToInvoke = SkeletonTestMain.class.getMethod("addOrangutan", Level.class, String.class, String.class, String.class);
                            break;
                            default:
                                parameters.addAll(splittedCommand);
                                methodToInvoke = SkeletonTestMain.class.getMethod("test", String.class, Object.class, Object.class, Object.class);
                                break;
                    }
                    break;
                case "Additem":
                    switch (splittedCommand.get(1)){
                        case "couch":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            methodToInvoke = SkeletonTestMain.class.getMethod("addCouch", Level.class, String.class, String.class, Object.class);
                            break;
                        case "arcademachine":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            methodToInvoke = SkeletonTestMain.class.getMethod("addArcadeMachine", Level.class, String.class, String.class, Object.class);
                            break;
                        case "chocolatemachine":
                            parameters.add(Game.getInstance().getCurrentLevel());
                            parameters.add(splittedCommand.get(2));
                            parameters.add(splittedCommand.get(3));
                            methodToInvoke = SkeletonTestMain.class.getMethod("addChocolateMachine", Level.class, String.class, String.class, Object.class);
                            break;
                            default:
                                parameters.addAll(splittedCommand);
                                methodToInvoke = SkeletonTestMain.class.getMethod("test", String.class, Object.class, Object.class, Object.class);
                                break;
                    }
                    break;
                case "Release":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    methodToInvoke = SkeletonTestMain.class.getMethod("release", Level.class, String.class, Object.class, Object.class);
                    break;
                case "Moveanimal":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    parameters.add(splittedCommand.get(2));
                    methodToInvoke = SkeletonTestMain.class.getMethod("moveAnimal", Level.class, String.class, String.class, Object.class);
                    break;
                case "Triggerthing":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    methodToInvoke = SkeletonTestMain.class.getMethod("triggerThing", Level.class, String.class, Object.class, Object.class);
                    break;
                case "Damagefield":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    parameters.add(splittedCommand.get(2));
                    methodToInvoke = SkeletonTestMain.class.getMethod("damageField", Level.class, String.class, String.class, Object.class);
                    break;
                case "Breakfield":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    methodToInvoke = SkeletonTestMain.class.getMethod("breakField", Level.class, String.class, Object.class, Object.class);
                    break;
                case "Automat":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    methodToInvoke = SkeletonTestMain.class.getMethod("automat", Level.class, String.class, Object.class, Object.class);
                    break;
                case "Stat":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    methodToInvoke = SkeletonTestMain.class.getMethod("stat", Level.class, String.class, Object.class, Object.class);
                    break;
                case "File":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    methodToInvoke = SkeletonTestMain.class.getMethod("file", Level.class, String.class, Object.class, Object.class);
                    break;
                case "Save":
                    parameters.add(Game.getInstance().getCurrentLevel());
                    parameters.add(splittedCommand.get(1));
                    methodToInvoke = SkeletonTestMain.class.getMethod("save", Level.class, String.class, Object.class, Object.class);
                    break;
                default:
                        parameters.addAll(splittedCommand);
                        methodToInvoke = SkeletonTestMain.class.getMethod("test", String.class, Object.class, Object.class, Object.class);
                        break;
            }

            for(int i = 0; i < 10; i++){
                parameters.add(null);
            }

            return methodToInvoke;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Object> getParameters() {
        return parameters;
    }
}
