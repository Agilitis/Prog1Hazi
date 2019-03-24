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

    /**
     * A fgveny azt a scenáriót valósítja meg, mikor egy bármilyen állat rálép egy üres mezőre. A mező lehet törött
     * vagy ép, ezt futás közben a felhasználó dönti el. Ha törött az állat meghal, egyébként rálép.
     */
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

    /**
     * A fgvény azt a scenáriót valósítja meg, mikor egy orángután húz maga után egy sor pandát, majd mikor egy üres mezőre
     * lépnek egy a sor alatt lévő csempe eltörik. Ennek hatására az éppen rajta lévő állat meghal, és
     * a sor visszafelé felbomlik, azonban a mögötte lévő állatok már nem halnak meg.
     */
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
    /**
     * Orángután rálép egy mezőre, ahol egy panda áll, és már korábban húzott pandákat. Ekkor az új panda beáll a sorba.
     */
    private static void orangutanWithPandasStepsOnFieldWithPanda(){
        //initialize
        Field f1 = new Field(false, 10);
        Field f2 = new Field(false, 10);
        Field f3 = new Field(false, 10);

        //Setting up the enviroment
        Orangutan o = new Orangutan(f2);
        Panda p = new Panda(f1);
        Panda p1 = new Panda(f3);

        //do the work
        o.move(f1);
    }

    /**
     * A fgvény azt a scenáriót valósítja meg, mikor egy orángután aki egy sor pandát húz maga után belép egy teleportba.
     * A pandák követni fogják az orángutánt ahova azt elteleportálta a teleport.
     */
    private static void orangutanWithPandasUsesTeleport(){
        //initialise
        Teleport t = new Teleport();

        Field f0 = new Field();
        Field f1 = new Field();
        Field f2 = new Field();

        Orangutan o = new Orangutan(f0);

        Panda p1 = new Panda(f1);
        Panda p2 = new Panda();

        //setting up the environment
        o.setPullThis(p1);
        p1.setPullThis(p2);
        p2.setPulledBy(p1);
        p1.setPulledBy(o);

        t.addNeighbour(f2);
        f0.addNeighbour(t);
        f1.addNeighbour(f0);

        //do the work
        o.move(t);
    }
    /**
     * Az orángután rálép a Finish fieldre, ahonnan ezáltal minden mögötte haladó panda bekerül az állatkertbe.
     */
    private static void orangutanWithPandasStepsOnFinishField(){
        FinishField f = new FinishField(false, 10);
        Field f1 = new Field(false, 10);
        Field f2 = new Field(false, 10);
        Field f3 = new Field(false, 10);
        //setting up the environment
        Panda p2 = new Panda(f3);
        Panda p1 = new Panda(f2);
        Orangutan o = new Orangutan(f1);
        o.setPullThis(p1);
        p1.setPullThis(p2);
        //do the work
        o.move(f);
    }

    /**
     * A fgvény azt a sccenáriót valósítja meg, mikor egy orángután aki egy sor pandát húz maga után rálép egy üres,
     * de összetört mezőre. A pandák mind előrrébb lépnek egyet. Ez egy álltalános semmilyen extra körülményt nem tartalmazó lépés.
     */
    private static void orangutanWithPandasStepsOnNonBokenEmptyField(){
        //initialise
        Field f0 = new Field(false, 20);
        Field f1 = new Field(false, 10);
        Field f3 = new Field(false,1);

        Orangutan o = new Orangutan(f0);

        Panda p1 = new Panda(f1);
        Panda p2 = new Panda();
        //setting up the environment
        o.setPullThis(p1);
        p1.setPullThis(p2);

        f0.addNeighbour(f3);
        f0.addNeighbour(f1);
        f1.addNeighbour(f0);
        f3.addNeighbour(f0);

        //do the work
        o.move(f3);
    }



    /**
     * Egy orángután rálép egy összetört mezőre, ahol meghal és szétszakad mögötte a lánc.
     */
    private static void orangutanWithPandasStepsOnBokenEmptyField(){
        Field f0 = new Field(false, 20);
        Field f1 = new Field(false, 10);
        Field f3 = new Field(true,1);

        Orangutan o = new Orangutan(f0);

        Panda p1 = new Panda(f1);
        Panda p2 = new Panda();
        //setting up the environment
        o.setPullThis(p1);
        p1.setPullThis(p2);

        f0.addNeighbour(f3);
        f0.addNeighbour(f1);
        f1.addNeighbour(f0);
        f3.addNeighbour(f0);

        //do the work
        o.move(f3);
    }


    /**
     * A fgvény azt a scenáriót valósítja meg, mikor a csokiautómata elsüti az eseményét. A közelben lévő pandák ennek
     * hatására, ha tudnak az eseményre reagálni, reagálnak.
     */
    private static void chocolateVendingMachineFireEvent(){
        //initialise
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        Field f4 = new Field();

        ChocolateVendingMachine ch = new ChocolateVendingMachine(f1);

        NervousPanda np = new NervousPanda(f2);

        Panda p1 = new Panda(f3);
        Panda p2 = new Panda(f4);

        //setting up the environment
        np.setPullThis(p1);
        p1.setPullThis(p2);

        //do the work
        ch.tick();
    }
    /**
     * A játékgép megszólal, a mellette álló panda pedig megijed.
     */
    private static void arcadeMachineFireEvent(){
        //initialise
        Field f1 = new Field(false, 20);
        Field f2 = new Field(true, 20);
        //setting up the environment
        ChocolateVendingMachine a = new ChocolateVendingMachine(f1);
        BigPanda bp = new BigPanda(f2);
        f1.addNeighbour(f2);
        f2.addNeighbour(f1);
        //do the work
        a.tick();
    }
    /**
     * A fgvény azt a scanáriót valósítja meg, mikor a fotel elsüti az eseményét. A közelben lévő pandák ennek
     * hatására, ha tudnak az eseményre reagálni, reagálnak.
     */
    private static void couchFireEvent(){
        //initialise
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();

        Couch co = new Couch(f1);

        SleepyPanda sp = new SleepyPanda(f2);

        Panda p1 = new Panda(f3);

        //setting up the environment
        sp.setPullThis(p1);

        //do the work
        co.tick();
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
            System.err.println("We can only handle number inputs. Please next time running the program consider using numbers only.");
        }
        return readValue;
    }

}
