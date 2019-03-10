package skeletontest;

import internal.*;

import java.util.InputMismatchException;
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
        testCases.addTestCase(new TestCase(SkeletonTestMain::couchFiresItsEventScenario, "Couch fires its event scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::arcadeMachineFiresItsEventScenario, "Arcade machine fires its event scneario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::chocolateVendingMachineFiresItsEventScenario, "Choclate vending machine fires its event."));
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
            testCases.run(userChoice-1);
        }
    }

    private static void brokenFieldGetsSteppedOnScenario() {
        Field field1 = new Field( true, 10);
        Field field2 = new Field( true, 0);
        Panda panda1 = new SleepyPanda(field1);
        panda1.move(field2);

    }

    private static void arcadeMachineFiresItsEventScenario() {
        Field field1 = new Field( false, 20);
        Field field2 = new Field( false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new NervousPanda(field1);
        ArcadeMachine arc1 = new ArcadeMachine(field2);
        arc1.doEvent();
    }

    private static void chocolateVendingMachineFiresItsEventScenario() {
        Field field1 = new Field( false, 20);
        Field field2 = new Field( false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new BigPanda(field1);
        ChocolateVendingMachine choc1 = new ChocolateVendingMachine(field2);
        choc1.doEvent();
    }

    private static void couchFiresItsEventScenario() {
        Field field1 = new Field( false, 20);
        Field field2 = new Field( false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new SleepyPanda(field1);
        Couch couch1 = new Couch(field2);
        couch1.doEvent();

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
        int readValue;
        try{
            readValue = reader.nextInt();
        }catch(InputMismatchException e){
            readValue = 0;
            System.err.println("We can only handle number imputs. Please next time running the program consider using numbers only.");
        }
        return readValue;
    }
}
