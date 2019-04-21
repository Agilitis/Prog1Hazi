package internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;
import utility.CommandInterpreter;

/**
 * A Main osztaly. Ez fog ossze minden mas osztalyt es biztositja a mukodesuket.
 */
public class Game {
    private static Game instance = new Game();  //singleton
    private Timer timer = new Timer();
    private ArrayList<Player> players = new ArrayList<>();  //there are more players
    private static boolean gameOn = true;
    private Level currentLevel; //the level everything happens on

    private Game(){}

    private static int getOperationMode(){
        return new Scanner(System.in).nextInt();
    }

    private void start(int operationMode){
        if(operationMode == 0){    //game mode
            this.initialise();
            while (gameOn) {
                for(Player player : players){
                    player.doAction();  //either does something or not
                }
                timer.tick();
            }
        }
        else if(operationMode == 1){   //test mode
            currentLevel = new Level();
            currentLevel.initialise();
            Method methodToInvoke;
            ArrayList<Object> parameters;

            while(getOperationMode() == 1) {    //for now
                try {
                    methodToInvoke = CommandInterpreter.getMethodToInvoke();
                    parameters = CommandInterpreter.getParameters();
                    Objects.requireNonNull(methodToInvoke).invoke(this, parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
                } catch (IllegalAccessException | InvocationTargetException | NullPointerException e) {
                    System.out.println("Hiba a vegrehajtasban!");
                }
            }
        }
        else{
            Logger.getAnonymousLogger().info("No such operation mode! Exiting program!");
        }
    }

    private void initialise() {
    }

    public static Game getInstance(){
        return instance;
    }

    public static void main(String... args){
        instance.start(getOperationMode());
    }
}
