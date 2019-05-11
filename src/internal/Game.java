package internal;

import Graphics.View;
import utility.FileHandler;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * A Main osztaly. Ez fog ossze minden mas osztalyt es biztositja a mukodesuket.
 */
public class Game {
    private static Game instance = new Game();  //singleton
    private Timer timer = new Timer();
    private ArrayList<Player> players = new ArrayList<>();  //there are more players
    private static boolean gameOn = true;
    private Level currentLevel; //the level everything happens on
    private View view;
    private Player selectedPlayer;

    public Timer getTimer() {
        return timer;
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public static boolean isGameOn() {
        return gameOn;
    }

    public static void setGameOn(boolean gameOn) {
        Game.gameOn = gameOn;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    private Game(){}

    private static int getOperationMode(){
        return new Scanner(System.in).nextInt();
    }

    private void start(int operationMode){
        if(operationMode == 0){
            final int delay = Integer.MAX_VALUE;
            int delta = 0;
            this.initialise();
            while (gameOn){
                if(delta == delay) {
                    timer.tick(currentLevel);
                    view.update(currentLevel);
                    delta = 0;
                }
                delta++;
            }
        }
        else if(operationMode == 1){   //test mode
            this.initialise();
            view.update(currentLevel);
        }
        else{
            Logger.getAnonymousLogger().info("No such operation mode! Exiting program!");
        }
    }

    private void initialise() {
        currentLevel = FileHandler.loadMap("map1.json");
        this.view = new View();
        Orangutan o = new Orangutan("orangutan1", currentLevel.getFields().get(9));
        players.add(new Player(o));
        currentLevel.addAnimal(o);
    }

    public static Game getInstance(){
        return instance;
    }

    public static void main(String... args){
        instance.start(0);
        //instance.start(getOperationMode());
    }

    public void leftMouseButtonPressed(int mouseX, int mouseY) {
        for(Player player : players){
            if((Math.abs(player.getOrangutan().getCoordinates()[0] - mouseX) < 80) && (Math.abs(player.getOrangutan().getCoordinates()[1] - mouseY) < 80)){
                selectedPlayer = player;
            }
        }
    }

    public void rightMouseButtonPressed(int mouseX, int mouseY) {
        for(Field field : currentLevel.getFields()){
            if((Math.abs(field.coordinates[0] - mouseX) < 80)&&(Math.abs(field.coordinates[1] - mouseY) < 80)){
                selectedPlayer.moveOrangutan(field);
            }
        }
    }
}
