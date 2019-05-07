package internal;


import skeletontest.TestCaseStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

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
                bufferedReader.readLine();
                System.out.println("The step options are:");

                ArrayList<Field> stepOptions = orangutan.getStepOptions();
                for(Field field : stepOptions){
                    System.out.println(field.getName());
                }

                String sFieldToStep = bufferedReader.readLine();
                for(Field field : stepOptions){
                    if(field.getName().equals(sFieldToStep)){
                        orangutan.move(field);
                    }
                }
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
