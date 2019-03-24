package internal;

/**
 * Interfész a periódikus cselekvés megvalósítására.
 */
public interface ITickable {
    /**
     * Aki valamilyen periódikus cselekvést csinál, azt ebben a fgvényben valósítja meg.
     */
    void tick();
}
