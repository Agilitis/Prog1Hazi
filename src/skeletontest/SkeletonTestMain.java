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
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalSteps, "Animal Steps Scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalHitsPanda, "Animal hits panda scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalHitsOrangutan, "Animal hits orangutan scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalHitsThing, "Animal hits thing scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::animalUsesTeleportAlone, "Animal uses teleport alone scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanUsesTeleportWhilePullingPandas, "Orangutan uses teleport while pulling panda scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanStepsWhilePullingPandas, "Orangutan steps while pulling pandas scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanStepsOnFinishWhilePullingPandas, "Orangutan steps on finish while pulling panda scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::couchFiresItsEvent, "Couch fires its event scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::arcadeMachineFiresItsEvent, "Arcade machine fires its event scneario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::chocolateVendingMachineFiresItsEvent, "Choclate vending machine fires its event."));
        testCases.addTestCase(new TestCase(SkeletonTestMain::brokenFieldGetsSteppedOn, "Broken field gets stepped on scenario"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::pandaHitsPanda, "Panda hits panda scenario"));
    }


    private static void handleTests() {
        int userChoice;

        while (true) {
            testCases.displayTestOptions();
            userChoice = getTestScenarioFromUser() - 1;
            if (userChoice == 0) {
                break;
            }
            testCases.run(userChoice);
        }
    }

    private static void brokenFieldGetsSteppedOn() {
        Field field1 = new Field(true, 10);
        Field field2 = new Field(true, 0);
        Panda panda1 = new SleepyPanda(field1);
        panda1.move(field2);

    }

    private static void arcadeMachineFiresItsEvent() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new NervousPanda(field1);
        ArcadeMachine arc1 = new ArcadeMachine(field2);
        arc1.doEvent();
    }

    private static void chocolateVendingMachineFiresItsEvent() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new BigPanda(field1);
        ChocolateVendingMachine choc1 = new ChocolateVendingMachine(field2);
        choc1.doEvent();
    }

    private static void couchFiresItsEvent() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        field1.addNeighbour(field2);
        field2.addNeighbour(field1);

        Panda panda1 = new SleepyPanda(field1);
        Couch couch1 = new Couch(field2);
        couch1.doEvent();

    }

    private static void orangutanStepsOnFinishWhilePullingPandas() {
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

    private static void orangutanStepsWhilePullingPandas() {
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

    private static void orangutanUsesTeleportWhilePullingPandas() {
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

    private static void animalUsesTeleportAlone() {


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

    private static void animalHitsThing() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        Couch couch = new Couch(field1);
        Panda panda = new SleepyPanda(field2);

        panda.move(field1);
    }

    private static void animalHitsOrangutan() {
        Field field1 = new Field(false, 20);
        Field field2 = new Field(false, 20);

        Orangutan orangutan = new Orangutan(field1);
        Panda panda = new SleepyPanda(field2);

        panda.move(field1);
    }

    private static void animalHitsPanda() {
        Field field1 = new Field(false, 10);
        Field field2 = new Field(false, 20);

        Orangutan orangutan = new Orangutan(field2);
        Panda panda = new SleepyPanda(field1);

        orangutan.move(field1);
    }

    private static void animalSteps() {
        Field field1 = new Field(false, 10);
        Field field2 = new Field(false, 20);

        Panda panda = new SleepyPanda(field1);

        panda.move(field2);
    }

    private static void pandaHitsPanda(){
        Field field1 = new Field(false, 10);
        Field field2 = new Field(false, 20);

        Panda panda1 = new SleepyPanda(field1);
        Panda panda2 = new BigPanda(field2);

        panda1.move(field2);
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
