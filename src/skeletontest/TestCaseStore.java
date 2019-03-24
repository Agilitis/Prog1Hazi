package skeletontest;


import java.util.ArrayList;
import java.util.List;

/**
 * A tesztesetek tarolasara szolgalo osztaly.
 */
public class TestCaseStore {
    private ArrayList<TestCase> testCases = new ArrayList<>();

    void addTestCase(TestCase testCase){
        testCases.add(testCase);
    }

    public List<TestCase> getTestCases(){
        return testCases;
    }

    /**
     * A konzolra kiirja az osszes teszteset nevet es a hozzatartozo szamot.
     */
    void displayTestOptions() {
        testCases.forEach(testCase -> System.out.println(testCase.getSerialNumber()+". "+testCase.getName()));
    }

    /**
     * A kapott szamnak megfelelo tesztnek elinditja a beregisztralt fgvenyet.
     * @param userChoice    A felhasznalo altal valasztott teszt szama.
     */
    void run(int userChoice) {
        testCases.get(userChoice).getMethod().run();
    }
}
