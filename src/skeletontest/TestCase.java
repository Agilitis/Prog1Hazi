package skeletontest;

/**
 * A kulonbozo teszteseteket megvalosito osztaly. Minden tesztesethez peldanyosodik egy a megfelelo parameterekkel.
 */
public class TestCase {


    private static int id = 0;
    private int serialNumber;
    private Runnable method;
    private String name;

    /**
     * Konstruktor
     * @param method    Az a metodus amely a megvalosítja a tesztesetet.
     * @param name  A teszteset neve.
     */
    public TestCase(Runnable method, String name){
        this.serialNumber = ++id;
        this.method = method;
        this.name = name;
    }


    int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Runnable getMethod() {
        return method;
    }

    public void setMethod(Runnable method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
