public class Couch extends Thing {

    private SleepyPanda restingPanda;


    void setRestingPanda(SleepyPanda restingPanda) {
        this.restingPanda = restingPanda;
    }

    @Override
    public void tick() {
        if(counter-- <= 0){
            if(restingPanda != null){
                Field wakeUpHere = field.getNeighbours()[0];
                restingPanda.move(wakeUpHere);
                restingPanda.refreshPanda();
            }
            doEvent();
            counter = 20;
        }
    }

    @Override
    void doEvent() {
        for(Field neighbour : field.getNeighbours()){
            GameObject gameObject = neighbour.getGameObject();
            gameObject.restingSpotAvailable(this);
        }
    }
}
