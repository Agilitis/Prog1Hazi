package skeletontest;


import java.util.ArrayList;
import java.util.List;

public class TestCaseStore {
    private ArrayList<TestCase> testCases = new ArrayList<>();

    void addTestCase(TestCase testCase){
        testCases.add(testCase);
    }

    public List<TestCase> getTestCases(){
        return testCases;
    }

    void displayTestOptions() {
        testCases.forEach(testCase -> System.out.println(testCase.getSerialNumber()+". "+testCase.getName()));
    }

    void run(int userChoice) {
        testCases.get(userChoice).getMethod().run();
    }
}
