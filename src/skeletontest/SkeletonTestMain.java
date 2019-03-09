package skeletontest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SkeletonTestMain {

    private static final String EXCEPTION_TEXT = "This test case has not been implemented yet!";

    public static void main(String... args){
        handleTests();
    }

    private static void displayTestOptions() {
        System.out.println(
                "0.Exit\n"+
                "1.Animal steps\n"+ //nm szettem külön mert itt nm kell szetvalasztani a panda es az o. lepeset
                "2.Animal hits panda\n"+
                "3.Animal hits orangutan\n"+
                "4.Animal hits Thing\n"+
                "5.Animal uses Teleport alone\n"+
                "6.Orangutan uses Teleport while pulling Pandas\n"+
                "7.Orangutan steps while pulling Pandas\n"+
                "8.Orangutan steps on Finish, pulling Pandas\n"+
                "9.Couch fire its event\n"+
                "10.ChocolateVendingMachine fire its event\n"+
                "11.ArcadeMachine fire its event.\n"+
                "12.Broken Field gets stepped on\n"
        );
    }

    private static void handleTests(){
        int userChoice;
        Map<Integer, Runnable> testCases = new HashMap<>();
        testCases.put(1, SkeletonTestMain::animalStepsScenario);
        testCases.put(2, SkeletonTestMain::animalHitsPandaScenario);
        testCases.put(3, SkeletonTestMain::animalHitsOrangutanScenario);
        testCases.put(4, SkeletonTestMain::animalHitsThingScenario);
        testCases.put(5, SkeletonTestMain::animalUsesTeleportAloneScenario);
        testCases.put(6, SkeletonTestMain::orangutanUsesTeleportWhilePullingPandasScenario);
        testCases.put(7, SkeletonTestMain::orangutanStepsWhilePullingPandasScenario);
        testCases.put(8, SkeletonTestMain::orangutanStepsOnFinishWhilePullingPandasScenario);
        testCases.put(9, SkeletonTestMain::couchFireItsEventScenario);
        testCases.put(11, SkeletonTestMain::arcadeMachineFireItsEventScenario);
        testCases.put(12, SkeletonTestMain::brokenFieldGetsSteppedOnScenario);

        while(true){
            displayTestOptions();
            userChoice = getTestScenarioFromUser();
            if(userChoice == 0){
                break;
            }
            testCases.get(userChoice).run();
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
