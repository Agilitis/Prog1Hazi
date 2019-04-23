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



    void initialise(){
        //put fields in fields
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

    public void addAnimal(Animal animal, String field, String name, String follow){
        Field fField = getField(field);
        if(fField != null){
            animal.setName(name);
            animal.setField(fField);
            fField.setGameObject(animal);
        }
        Animal aFollow = getAnimal(follow);
        if(aFollow != null){
            aFollow.setPullThis(animal);
            animal.setPulledBy(aFollow);
        }
        animals.add(animal);
    }

    public void addThing(Thing thing, String field, String name){
        Field fField = getField(field);
        if(fField != null){
            fField.setGameObject(thing);
        }
        thing.name = name;
        thing.field = fField;
        things.add(thing);
    }

}
