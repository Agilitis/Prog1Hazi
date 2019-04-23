package internal;


import skeletontest.TestCaseStore;
import utility.CommandInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A jatekon belul a jatekos megtestesitoje. Ha a jatekos tesz valamit, ezen az osztalyon keresztul teszi.
 */
class Player {
    private Orangutan orangutan = new Orangutan();
    private Method methodToInvoke;
    private ArrayList<Object> parameters;
    private static TestCaseStore testCaseStore = new TestCaseStore();

    void doAction() {
        try {BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            if(bufferedReader.ready()){
                String command = bufferedReader.readLine();
                System.out.println("The step options are:");

                ArrayList<Field> stepOptions = orangutan.getStepOptions();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Orangutan getOrangutan() {
        return orangutan;
    }

    public void setOrangutan(Orangutan orangutan) {
        this.orangutan = orangutan;
    }
}
