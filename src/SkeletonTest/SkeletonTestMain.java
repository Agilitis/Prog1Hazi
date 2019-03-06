package SkeletonTest;

import Internal.*;
import java.util.Scanner;

public class SkeletonTestMain {

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
                    CouchFireItsEventScenario();
                    break;
                case 10:
                    ChocolateVendingMachineFireItsEventScenario();
                    break;
                case 11:
                    ArcadeMachineFireItsEventScenario();
                    break;
                case 12:
                    BrokenFieldGetsSteppedOnScenario();
                    break;
                    default:
                        break;
            }
        }
    }

    private static void BrokenFieldGetsSteppedOnScenario() {

    }

    private static void ArcadeMachineFireItsEventScenario() {

    }

    private static void ChocolateVendingMachineFireItsEventScenario() {

    }

    private static void CouchFireItsEventScenario() {

    }

    private static void orangutanStepsOnFinishWhilePullingPandasScenario() {

    }

    private static void orangutanStepsWhilePullingPandasScenario() {

    }

    private static void orangutanUsesTeleportWhilePullingPandasScenario() {

    }

    private static void animalUsesTeleportAloneScenario() {

    }

    private static void animalHitsThingScenario() {

    }

    private static void animalHitsOrangutanScenario() {

    }

    private static void animalHitsPandaScenario() {

    }

    private static void animalStepsScenario() {
    }

    private static int getTestScenarioFromUser() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }
}
