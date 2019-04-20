package internal;

import java.util.ArrayList;

/**
 * A Main osztaly. Ez fog ossze minden mas osztalyt es biztositja a mukodesuket.
 */
public class Game {
    private static Game instance = new Game();  //singleton
    private Timer timer = new Timer();
    private ArrayList<Level> levels = new ArrayList<>(); //to be able to have more levels
    private ArrayList<Player> players = new ArrayList<>();  //there are more players

    private Game(){}

    public static Game getInstance(){
        return instance;
    }

    public static void main(){

    }
}
