package internal;

import java.util.ArrayList;

/**
 * ITickable objektumokat fog ossze es biztositja a mukodesuket.
 */
public class Timer {
    private ArrayList<ITickable> tickables = new ArrayList<>();

    public void initialize() {
        //put things in tickables
    }

    void tick(Level level){
        for(Animal animal : level.getAnimals()){
            animal.tick();
        }
        level.removeAnimals();
    }
}
