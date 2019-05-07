package skeletontest;

import internal.*;
import utility.CommandInterpreter;
import utility.FileHandler;
import utility.Logger;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

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
        FileHandler.loadMap("map1.json");
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
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanWithPandasStepsOnNonBrokenEmptyField, "Orangutan With Pandas Steps On Non-Broken Empty Field"));
        testCases.addTestCase(new TestCase(SkeletonTestMain::orangutanWithPandasStepsOnBrokenEmptyField, "Orangutan With Pandas Steps On Broken Empty Field"));
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
    	Logger.resetTabulation();

    	Scanner scanner = new Scanner(System.in);
        System.out.println("A mezo torott?(1/0)");
        int fieldIsBroken = scanner.nextInt();
        switch (fieldIsBroken){
            case 1:
                //initialize
                Field f1 = new Field();
                Field f2 = new Field(true,0);
                Orangutan o = new Orangutan(f1);

                //setting up the environment
                f1.addNeighbour(f2);
                f2.addNeighbour(f1);

                //do the work
                o.move(f2);
                break;
            case 0:
                //initialize
                Field f3 = new Field();
                Field f4 = new Field();
                Orangutan or = new Orangutan(f3);

                //setting up the environment
                f3.addNeighbour(f4);
                f4.addNeighbour(f3);

                //do the work
                or.move(f4);
                break;
                default:
                    System.out.println("Not a valid answer! Pick an other use-case!");
                    break;
        }

    }

    /**
     * A fgvény azt a scenáriót valósítja meg, mikor egy orángután húz maga után egy sor pandát, majd mikor egy üres mezőre
     * lépnek egy a sor alatt lévő csempe eltörik. Ennek hatására az éppen rajta lévő állat meghal, és
     * a sor visszafelé felbomlik, azonban a mögötte lévő állatok már nem halnak meg.
     */
    private static void orangutanStepsOnEmptyFieldFieldBreakWhilePandasCome(){
    	Logger.resetTabulation();

    	//initialize
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
    	Logger.resetTabulation();

    	//initialize
        Field f1 = new Field(false, 10);
        Field f2 = new Field(false, 10);
        Field f3 = new Field(false, 10);

        //Setting up the environment
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
    	Logger.resetTabulation();

    	//initialize
        Teleport t1 = new Teleport();
        Teleport t2 = new Teleport();

        Field f0 = new Field();
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();

        Orangutan o = new Orangutan(f0);

        Panda p1 = new Panda(f1);
        Panda p2 = new Panda(f2);

        //setting up the environment
        o.setPullThis(p1);
        p1.setPullThis(p2);
        p2.setPulledBy(p1);
        p1.setPulledBy(o);

        t1.addTeleportNeighbour(t2);
        t2.addTeleportNeighbour(t1);
        t2.addNeighbour(f3);

        f0.addNeighbour(t1);
        f1.addNeighbour(f0);

        //do the work
        o.move(t1);
    }

    /**
     * Az orángután rálép a Finish fieldre, ahonnan ezáltal minden mögötte haladó panda bekerül az állatkertbe.
     */
    private static void orangutanWithPandasStepsOnFinishField(){
    	Logger.resetTabulation();

    	//initialize
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
    private static void orangutanWithPandasStepsOnNonBrokenEmptyField(){
    	Logger.resetTabulation();

    	//initialize
        Field f0 = new Field(false, 20);
        Field f1 = new Field(false, 10);
        Field f2 = new Field(false, 10);
        Field f3 = new Field(false,1);

        Orangutan o = new Orangutan(f0);

        Panda p1 = new Panda(f1);
        Panda p2 = new Panda(f2);
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
    private static void orangutanWithPandasStepsOnBrokenEmptyField(){
    	Logger.resetTabulation();

    	//initialize
    	Field f0 = new Field(false, 20);
        Field f1 = new Field(false, 10);
        Field f2 = new Field(false, 10);
        Field f3 = new Field(true,0);
        Orangutan o = new Orangutan(f0);

        Panda p1 = new Panda(f1);
        Panda p2 = new Panda(f2);
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
    	Logger.resetTabulation();

    	//initialize
        Field f1 = new Field();
        Field f2 = new Field(true, 10);
        Field f3 = new Field();
        Field f4 = new Field();

        ChocolateVendingMachine ch = new ChocolateVendingMachine(f1);

        BigPanda bp = new BigPanda(f2);

        Panda p1 = new Panda(f3);
        Panda p2 = new Panda(f4);

        //setting up the environment
        bp.setPullThis(p1);
        p1.setPullThis(p2);
        f1.addNeighbour(f2);
        f1.addNeighbour(f3);
        f1.addNeighbour(f4);

        //do the work
        ch.tick();
    }

    /**
     * A játékgép megszólal, a mellette álló panda pedig megijed.
     */
    private static void arcadeMachineFireEvent(){
    	Logger.resetTabulation();

    	//initialize
        Field f1 = new Field(false, 20);
        Field f3 = new Field(false, 20);
        Field f4 = new Field(false, 20);
        Field f2 = new Field(true, 20);
        //setting up the environment
        ArcadeMachine a = new ArcadeMachine(f1);
        NervousPanda np = new NervousPanda(f2);
        Panda p1 = new Panda(f3);
        Panda p2 = new Panda(f4);
        np.setPullThis(p1);
        p1.setPullThis(p2);
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
    	Logger.resetTabulation();

    	//initialize
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();

        Couch co = new Couch(f1);

        SleepyPanda sp = new SleepyPanda(f2);

        Panda p1 = new Panda(f3);

        //setting up the environment
        sp.setPullThis(p1);
        f1.addNeighbour(f2);
        f1.addNeighbour(f3);

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
//=============================================================================================================================
    public static void loadMap(String level, Object arg1, Object arg2, Object arg3){

    }

    public static void addPanda(Level level, String field, String name, String follow){
        Panda panda = new Panda();
        level.addAnimal(panda, field, name, follow);

    }

    public static void addSleepyPanda(Level level, String field, String name, String follow){
        SleepyPanda sp = new SleepyPanda();
        level.addAnimal(sp,field,name,follow);
    }

    public static void addBigPanda(Level level, String field, String name, String follow){
        BigPanda bp = new BigPanda();
        level.addAnimal(bp,field,name,follow);
    }

    public static void addNervousPanda(Level level, String field, String name, String follow){
        NervousPanda np = new NervousPanda();
        level.addAnimal(np, field, name, follow);
    }

    public static void addOrangutan(Level level, String field, String name, String follow){
        Orangutan o = new Orangutan();
        level.addAnimal(o, field, name, follow);
    }

    public static void addCouch(Level level, String field, String name, Object arg1){
        Couch c = new Couch();
        level.addThing(c, field, name);
    }

    public static void addArcadeMachine(Level level, String field, String name, Object arg1){
        ArcadeMachine am = new ArcadeMachine();
        level.addThing(am, field,name);
    }

    public static void addChocolateMachine(Level level, String field, String name, Object arg1){
        ChocolateVendingMachine ch = new ChocolateVendingMachine();
        level.addThing(ch, field, name);
    }

    public static void release(Level level, String name, Object arg1, Object arg2){
        Animal animal = level.getAnimal(name);
        if(animal != null){
            animal.releaseHands();
        }
    }

    public static void moveAnimal(Level level, String start, String finish, Object arg1){
        Field field = level.getField(start);
        Field fieldEnd = level.getField(finish);
        if(field != null && fieldEnd != null){
            try {
                Animal animal = (Animal) field.getGameObject();
                animal.move(fieldEnd);
            }
            catch (Exception e){

            }
        }
    }

    public static void triggerThing(Level level, String name, Object arg1, Object arg2){
        Thing thing = level.getThing(name);
        if(thing != null){
            thing.trigger();
        }
    }

    public static void damageField(Level level, String name, String damage, Object arg1){
        Field field = level.getField(name);
        if(field != null){
            field.sufferDamageByAnimal(Integer.parseInt(damage), new Panda());
        }
    }

    public static void breakField(Level level, String name, Object arg1, Object arg2){
        Field field = level.getField(name);
        if(field != null){
            field.sufferDamageByAnimal(100, new Panda());
        }
    }

    public static void automat(Level level, String on, Object arg1, Object arg2){}

    public static void stat(Level level, String name, Object arg1, Object arg2){
        Field field = level.getField(name);
        Animal animal = level.getAnimal(name);
        Thing thing = level.getThing(name);
        if(field != null){
            System.out.println(field.toString());
        }
        if(animal != null){
            System.out.println(animal.toString());
        }
        if(thing != null){
            System.out.println(thing.toString());
        }
    }

    public static void file(Level level, String file, Object arg1, Object arg2)  {
        File fileToRead = new File("input/sequences/"+file);
        ArrayList<Object> parameters;
        Method methodToInvoke;
        Scanner sc = null;
        try {
            sc = new Scanner(fileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            try {
                String command = sc.nextLine();
                methodToInvoke = CommandInterpreter.getMethodToInvoke(command);
                parameters = CommandInterpreter.getParameters();
                Objects.requireNonNull(methodToInvoke).invoke(methodToInvoke, parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
            } catch (IllegalAccessException | InvocationTargetException | NullPointerException e) {
                System.out.println("Hiba a vegrehajtasban!");
            }
        }
    }

    public static void save(Level level, String fileName, Object arg1, Object arg2){}

    public static void test(String msg, Object arg1, Object arg2, Object arg3){
        System.out.println(msg);
        System.out.println((String)arg1);
        System.out.println((String)arg2);
        System.out.println((String)arg3);
    }

    public static void damageField() {
    }
}
