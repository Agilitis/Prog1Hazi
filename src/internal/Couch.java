package internal;

public class Couch extends Thing {

    private SleepyPanda restingPanda;

    public Couch(Field field) {
        super(field);
    }


    void setRestingPanda(SleepyPanda restingPanda) {
        this.restingPanda = restingPanda;
    }

    /**
     * Minden időegységben tickel a kanapé, ami ezáltal csökkent egy belső számlálót, ami ha eléri a 0-t, akkor a saját eseményét tüzeli.
     */
    @Override
    public void tick() {
        logger.log(this+".tick()");
        if (--counter <= 0) {
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
        logger.log(this+".doEvent(" + ")");

        for (Field neighbour : field.getNeighbours()) {
            GameObject gameObject = neighbour.getGameObject();
            logger.log("\t"+gameObject+".restingSpotAvailable()");
            gameObject.restingSpotAvailable(this);
        }
    }
}
