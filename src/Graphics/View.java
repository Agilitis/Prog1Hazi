package Graphics;

import internal.Animal;
import internal.Field;
import internal.Level;
import internal.Thing;

import javax.swing.*;
import java.util.ArrayList;

public class View extends JFrame {
    private JPanel mainPanel = new JPanel();

    private ArrayList<Drawable> drawables = new ArrayList<>();


    public View(){
        this.setVisible(true);
        this.setSize(600,500);
        this.setTitle("PandaPlaza");
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(mainPanel);
    }

    public void update(Level level){
        ArrayList<Thing> things = level.getThings();
        ArrayList<Animal> animals = level.getAnimals();
        ArrayList<Field> fields = level.getFields();

        for(Field field : fields){
            drawables.add(field.getDrawable());
        }
        for(Thing thing : things){
            drawables.add(thing.getDrawable());
        }
        for(Animal animal : animals){
            drawables.add(animal.getDrawable());
        }


    }
}
