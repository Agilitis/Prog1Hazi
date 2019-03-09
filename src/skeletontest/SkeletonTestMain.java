package skeletontest;

import java.util.Scanner;

public class SkeletonTestMain {

    public static final String EXCEPTION_TEXT = "This test case has not been implemented yet!";

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
                "8.Orangutan steps on Finish pulling Pandas\n"+
                "9.Couch fire its event\n"+
                "10.ChocolateVendingMachine fire its event\n"+
                "11.ArcadeMachine fire its event.\n"+
                "12.Broken Field gets stepped on\n"
        );
    }

    private static void handleTests(){
        int userChoice;
        while (true) {
            displayTestOptions();
            userChoice = getTestScenarioFromUser();
            switch (userChoice) {
                case 0:
                    return;
                case 1:
                    animalStepsScenario();
                    break;
                case 2:
                    animalHitsPandaScenario();
                    break;
                case 3:
                    animalHitsOrangutanScenario();
                    break;
                case 4:
                    animalHitsThingScenario();
                    break;
                case 5:
                    animalUsesTeleportAloneScenario();
                    break;
                case 6:
                    orangutanUsesTeleportWhilePullingPandasScenario();
                    break;
                case 7:
                    orangutanStepsWhilePullingPandasScenario();
                    break;
                case 8:
                    orangutanStepsOnFinishWhilePullingPandasScenario();
                    break;
                case 9:
                    couchFireItsEventScenario();
                    break;
                case 10:
                    chocolateVendingMachineFireItsEventScenario();
                    break;
                case 11:
                    arcadeMachineFireItsEventScenario();
                    break;
                case 12:
                    brokenFieldGetsSteppedOnScenario();
                    break;
                    default:
                        break;
            }
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
