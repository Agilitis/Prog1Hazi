package internal;

import java.util.ArrayList;

/**
 * ITickable objektumokat fog ossze es biztositja a mukodesuket.
 */
public class Timer {
    private ArrayList<ITickable> tickables = new ArrayList<>();

    public void inicialize(){
        //put thing in tickables
    }

    public void tick(){
        for(ITickable iTickable : tickables){
            iTickable.tick();
        }
    }
}
