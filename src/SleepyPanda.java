public class SleepyPanda extends Panda {

    public void putToSleep(Couch sleepHere){
        sleepHere.setSleepingPanda(this);
        field.removeGameObject();
        pullThis = null;
    }
}
