package skeletontest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SkeletonTestMain {

    private static final String EXCEPTION_TEXT = "This test case has not been implemented yet!";
    private static TestCaseStore testCases = new TestCaseStore();

    public static void main(String... args) {
        testFixtures();
        handleTests();
    }

    private static void testFixtures() {
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalStepsScenario, "Animal Steps Scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalHitsPandaScenario, "Animal hits panda scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalHitsOrangutanScenario, "Animal hits orangutan scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalHitsThingScenario, "Animal hits thing scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalUsesTeleportAloneScenario, "Animal uses teleport alone scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanUsesTeleportWhilePullingPandasScenario, "Orangutan uses teleport while pulling panda scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanStepsWhilePullingPandasScenario, "Orangutan steps while pulling pandas scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanStepsOnFinishWhilePullingPandasScenario, "Orangutan steps on finish while pulling panda scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::couchFireItsEventScenario, "Couch fires its event scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::arcadeMachineFireItsEventScenario, "Arcade machine fires its event scneario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::brokenFieldGetsSteppedOnScenario, "Broken field gets stepped on scenario"));
    }



    private static void handleTests() {
        int userChoice;

        while (true) {
            testCases.displayTestOptions();
            userChoice = getTestScenarioFromUser();
            if (userChoice == 0) {
                break;
            }
            testCases.run(userChoice);
        }
    }

    private static void brokenFieldGetsSteppedOnScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void arcadeMachineFireItsEventScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void chocolateVendingMachineFireItsEventScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void couchFireItsEventScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void orangutanStepsOnFinishWhilePullingPandasScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void orangutanStepsWhilePullingPandasScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void orangutanUsesTeleportWhilePullingPandasScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void animalUsesTeleportAloneScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void animalHitsThingScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void animalHitsOrangutanScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void animalHitsPandaScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);

    }

    private static void animalStepsScenario() {
        throw new UnsupportedOperationException(EXCEPTION_TEXT);
    }

    private static int getTestScenarioFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }
}
