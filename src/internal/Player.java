package internal;

/**
 * A jatekon belul a jatekos megtestesitoje. Ha a jatekos tesz valamit, ezen az osztalyon keresztul teszi.
 */
class Player {
    private Orangutan orangutan = new Orangutan();

    void doAction() {
    }

    public Orangutan getOrangutan() {
        return orangutan;
    }

    public void setOrangutan(Orangutan orangutan) {
        this.orangutan = orangutan;
    }
}
