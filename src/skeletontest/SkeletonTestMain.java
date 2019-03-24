package skeletontest;

import internal.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Osztaly mely magaban foglalja a teszteseteket es menedzseli a tesztek futasat.
 */
public class SkeletonTestMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String EXCEPTION_TEXT = "This test case has not been implemented yet!";
    private static TestCaseStore testCases = new TestCaseStore();

    /**
     * A main fgveny. A program belepesi pontja, elindítja a tesztesetek futasat illetve a menu megjeleniteset.
     * @param args a szokvanyos main parameter
     */
    public static void main(String... args) {
        testFixtures();
        handleTests();
    }

    /**
     * Fgveny mely a kivant tesztesetekkel feltolti a tesztek kollekciojat.
     */
    private static void testFixtures() {
        testCases.addTestCase(new TestCase(SkeletonTestMain::lonelyAnimalStepsOnEmptyField, "Lonely Animal Steps On Empty Field"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanStepsOnEmptyFieldFieldBreakWhilePandasCome, "Orangutan Steps On Empty Field, Field Break While Pandas Come"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanWithPandasStepsOnFieldWithPanda, "Orangutan With Pandas Steps On Field With Panda"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanWithPandasUsesTeleport, "Orangutan With Pandas Uses Teleport"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanWithPandasStepsOnFinishField, "Orangutan With Pandas Steps On Finish Field"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanWithPandasStepsOnNonBokenEmptyField, "Orangutan With Pandas Steps On Non-Broken Empty Field"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanWithPandasStepsOnBokenEmptyField, "Orangutan With Pandas Steps On Broken Empty Field"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::chocolateVendingMachineFireEvent, "Chocolate VendingMachine Fire Event"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::arcadeMachineFireEvent, "ArcadeMachine Fire Event"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::couchFireEvent, "Couch Fire Event"));
    }

    /**
     * Kiírja a teszteseteket, meghívja a fgvenyt mely visszaadja a felhasznalo valaszat es elinditja azt
     * 0 eseten kilep.
     */
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

    private static void lonelyAnimalStepsOnEmptyField(){
        //initialise
        Orangutan o = new Orangutan();
        Field f1 = new Field();
        Field f2 = new Field();

        //setting up the environment
        o.setField(f1);
        f1.setGameObject(o);
        f1.addNeighbour(f2);
        f2.addNeighbour(f1);


        //do the work
        o.tick();
    }
    private static void orangutanStepsOnEmptyFieldFieldBreakWhilePandasCome(){
        //initialise
        Field f0 = new Field(true,1);
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        Field f4 = new Field();

        Orangutan o = new Orangutan(f0);

        Panda p1 = new Panda(f1);
        Panda p2 = new Panda(f2);
        Panda p3 = new Panda(f3);

        //setting up the environment
        o.setPullThis(p1);
        p1.setPullThis(p2);
        p2.setPullThis(p3);
        p3.setPulledBy(p2);
        p2.setPulledBy(p1);
        p1.setPulledBy(o);
        f1.addNeighbour(f2);
        f1.addNeighbour(f0);
        f2.addNeighbour(f1);
        f2.addNeighbour(f3);
        f3.addNeighbour(f2);
        f3.addNeighbour(f4);
        f4.addNeighbour(f3);

        //do the work
        o.move(f4);
    }
    private static void orangutanWithPandasStepsOnFieldWithPanda(){}
    private static void orangutanWithPandasUsesTeleport(){
        //initialise
        Orangutan o = new Orangutan();

        Panda p1 = new Panda();
        Panda p2 = new Panda();

        Teleport t = new Teleport();

        Field f0 = new Field();
        Field f1 = new Field();
        Field f2 = new Field();

        //setting up the environment

        //do the work
    }
    private static void orangutanWithPandasStepsOnFinishField(){}
    private static void orangutanWithPandasStepsOnNonBokenEmptyField(){
        //initialise
        //setting up the environment
        //do the work
    }
    private static void orangutanWithPandasStepsOnBokenEmptyField(){}
    private static void chocolateVendingMachineFireEvent(){
        //initialise
        //setting up the environment
        //do the work
    }
    private static void arcadeMachineFireEvent(){}
    private static void couchFireEvent(){
        //initialise
        //setting up the environment
        //do the work
    }

    /**
     * Ez a fgveny valositja meg tenylegesen a kommunikaciot a felhasznaloval, a standard inputrol
     * beolvas egy szamot es azt visszaadja
     * @return  A felhasznalotol bekert adat
     */
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
