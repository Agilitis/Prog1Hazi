package internal;

public class Couch extends Thing {

    private SleepyPanda restingPanda;

    public Couch(Field field) {
        super(field);
    }


    void setRestingPanda(SleepyPanda restingPanda) {
        this.restingPanda = restingPanda;
    }

    @Override
    public void tick() {
        if (counter-- <= 0) {
            if (restingPanda != null) {
                Field wakeUpHere = field.getNeighbours().get(0);
                restingPanda.move(wakeUpHere);
                restingPanda.refreshPanda();
            }
            doEvent();
            counter = 20;
        }
    }

    @Override
    public void doEvent() {
        logger.log("Restin spot available at: " + this.field + " by " + this.hashCode());
        for (Field neighbour : field.getNeighbours()) {
            GameObject gameObject = neighbour.getGameObject();
            gameObject.restingSpotAvailable(this);
        }
    }
}
