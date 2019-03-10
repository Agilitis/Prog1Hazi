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
            testCases.run(userChoice - 1);
        }
    }

    private static void brokenFieldGetsSteppedOnScenario() {
        Field field1 = new Field(true, 10);
        Field field2 = new Field(true, 0);
        Panda panda1 = new SleepyPanda(field1);
        panda1.move(field2);

    }

    private static void arcadeMachineFiresItsEventScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new NervousPanda(field1);
        ArcadeMachine arc1 = new ArcadeMachine(field2);
        arc1.doEvent();
    }

    private static void chocolateVendingMachineFiresItsEventScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new BigPanda(field1);
        ChocolateVendingMachine choc1 = new ChocolateVendingMachine(field2);
        choc1.doEvent();
    }

    private static void couchFiresItsEventScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new SleepyPanda(field1);
        Couch couch1 = new Couch(field2);
        couch1.doEvent();

    }

    private static void orangutanStepsOnFinishWhilePullingPandasScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);
        Field field3 = new Field(false, 20);
        Field field4 = new Field(false, 20);
        Field finishField = new FinishField(false, 20);

        Panda panda1 = new SleepyPanda(field1);
        Panda panda2 = new BigPanda(field2);
        Panda panda3 = new NervousPanda(field3);
        Orangutan orangutan = new Orangutan(field4);

        orangutan.setPullThis(panda3);
        panda3.setPullThis(panda2);
        panda2.setPullThis(panda1);

        orangutan.move(finishField);
    }

    private static void orangutanStepsWhilePullingPandasScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);
        Field field3 = new Field(false, 20);
        Field field4 = new Field(false, 20);
        Field field5 = new Field(false, 20);

        Panda panda1 = new SleepyPanda(field1);
        Panda panda2 = new BigPanda(field2);
        Panda panda3 = new NervousPanda(field3);
        Orangutan orangutan = new Orangutan(field4);

        orangutan.setPullThis(panda3);
        panda3.setPullThis(panda2);
        panda2.setPullThis(panda1);

        orangutan.move(field5);
    }

    private static void orangutanUsesTeleportWhilePullingPandasScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);
        Field field3 = new Field(false, 20);
        Field field4 = new Field(false, 20);
        Teleport teleport = new Teleport(false, 20);
        Teleport teleport2 = new Teleport(false, 20);
        Field field5 = new Field(true, 10);

        Panda panda1 = new SleepyPanda(field1);
        Panda panda2 = new BigPanda(field2);
        Panda panda3 = new NervousPanda(field3);
        Orangutan orangutan = new Orangutan(field4);

        teleport.addTeleportNeighbour(teleport2);

        teleport2.addTeleportNeighbour(teleport);

        teleport2.addNeighbour(field5);

        orangutan.setPullThis(panda3);
        panda3.setPullThis(panda2);
        panda2.setPullThis(panda1);


        orangutan.move(teleport);
    }

    private static void animalUsesTeleportAloneScenario() {


        Field field4 = new Field(false, 20);
        Teleport teleport = new Teleport(false, 20);
        Teleport teleport2 = new Teleport(false, 20);
        Field field5 = new Field(true, 10);

        Orangutan orangutan = new Orangutan(field4);
        teleport.addTeleportNeighbour(teleport2);
        teleport2.addTeleportNeighbour(teleport);
        teleport2.addNeighbour(field5);

        orangutan.move(teleport);
    }

    private static void animalHitsThingScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        Couch couch = new Couch(field1);
        Panda panda = new SleepyPanda(field2);

        panda.move(field1);
    }

    private static void animalHitsOrangutanScenario() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        Orangutan orangutan = new Orangutan(field1);
        Panda panda = new SleepyPanda(field2);

        panda.move(field1);
    }

    private static void animalHitsPandaScenario() {
        Field field1 = new Field(false, 10);
        Field field2 = new Field(false, 20);

        Orangutan orangutan = new Orangutan(field2);
        Panda panda = new SleepyPanda(field1);

        orangutan.move(field1);
    }

    private static void animalStepsScenario() {
        Field field1 = new Field(false, 10);
        Field field2 = new Field(false, 20);

        Panda panda = new SleepyPanda(field1);

        panda.move(field2);
    }

    private static int getTestScenarioFromUser() {
        Scanner reader = new Scanner(System.in);
        int readValue;
        try {
            readValue = reader.nextInt();
        } catch (InputMismatchException e) {
            readValue = 0;
            System.err.println("We can only handle number imputs. Please next time running the program consider using numbers only.");
        }
        return readValue;
    }
}
