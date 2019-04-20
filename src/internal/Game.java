package internal;

import skeletontest.SkeletonTestMain;
import skeletontest.TestCase;
import skeletontest.TestCaseStore;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import skeletontest.TestCase;

/**
 * A Main osztaly. Ez fog ossze minden mas osztalyt es biztositja a mukodesuket.
 */
public class Game {
    private static Game instance = new Game();  //singleton
    private Timer timer = new Timer();
    private ArrayList<Level> levels = new ArrayList<>(); //to be able to have more levels
    private ArrayList<Player> players = new ArrayList<>();  //there are more players
    private static boolean gameOn = true;
    private Level currentLevel; //the level everything happens on

    private Game(){}

    private static int getOperationMode(){
        return new Scanner(System.in).nextInt();
    }

    private void start(int operationMode){
        if(operationMode == 0){    //game mode
            while (gameOn) {
                //game loop
            }
        }
        else if(operationMode == 1){   //test mode
            currentLevel = new Level();
            currentLevel.inicialise();


        }
        else{
            Logger.getAnonymousLogger().info("No such operation mode! Exiting program!");
        }
    }

    public static Game getInstance(){
        return instance;
    }

    public static void main(String... args){
        instance.start(getOperationMode());
    }
}
