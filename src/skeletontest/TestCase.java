package skeletontest;


class TestCase {


    private static int id = 0;
    private int serialNumber;
    private Runnable method;
    private String name;

    TestCase(Runnable method, String name){
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
