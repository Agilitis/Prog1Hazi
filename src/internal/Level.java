package internal;

import java.util.ArrayList;

/**
 * A palya. Osszefogja a mezoket.
 */
public class Level {
    private ArrayList<Field> fields = new ArrayList<>();
    private ArrayList<Panda> zoo = new ArrayList<>();   //for the pandas, who were sent to the zoo
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Thing> things = new ArrayList<>();

    public ArrayList<Field> getFields() {
        return fields;
    }

    public ArrayList<Panda> getZoo() {
        return zoo;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    void initialise(){

    }

    public void addField(Field field){
        fields.add(field);
    }

    public Field getField(String name){
        for(Field field : fields){
            if(field.getName().equals(name)){
                return field;
            }
        }
        return null;
    }

    public Animal getAnimal(String name){
        for(Animal animal : animals){
            if(animal.getName().equals(name)){
                return animal;
            }
        }
        return null;
    }

    public Thing getThing(String name){
        for(Thing thing : things){
            if(thing.getName().equals(name)){
                return thing;
            }
        }
        return null;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void addThing(Thing thing){
        things.add(thing);
    }

    void test(){
        for(Field field : fields){
            System.out.println(field.toString());
        }
        for(Animal animal : animals){
            System.out.println(animal.toString());
        }
        for(Thing thing : things){
            System.out.println(thing.toString());
        }
    }

}
