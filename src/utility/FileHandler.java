package utility;

import java.io.*;
import java.util.HashMap;

import internal.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.StyledEditorKit;

/**
 * Ez az osztaly valositja meg a file elereseket.
 */
public final class FileHandler {
    private FileHandler(){}
    private static JSONObject jsonObject;


    public static void loadMap(String mapName){
        Level level = new Level();
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            jsonObject = (JSONObject) new JSONParser().parse(new FileReader("input/maps/" + mapName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray fields = (JSONArray) jsonObject.get("fields");
        JSONArray neighbours = (JSONArray) jsonObject.get("neighbours");
        JSONArray pandas = (JSONArray) jsonObject.get("pandas");
        JSONArray things = (JSONArray) jsonObject.get("things");
        for (var field : fields){
            String fieldName = ((JSONObject)field).get("name").toString();
            String damagable = ((JSONObject)field).get("damagable").toString();
            Boolean isDamagable = 1 == Integer.parseInt(damagable);
            int health = Integer.parseInt (((JSONObject)field).get("damagable").toString());
            System.out.println(fieldName);
            Field newField = new Field(isDamagable, health);
            newField.setName(fieldName);
            level.addField(newField);
        }

        for (var neighbour : neighbours){
            System.out.println("Neighbours: " + neighbour);
            String fieldName = ((JSONObject)neighbour).get("name").toString();
            JSONArray fieldNeighbours = (JSONArray) ((JSONObject)neighbour).get("fields");
            Field field = level.getField(fieldName);
            if(field != null){
                for(var fieldNeighbour : fieldNeighbours){
                    field.addNeighbour(level.getField(fieldNeighbour.toString()));
                }
            }
        }

        for (var panda : pandas){
            System.out.println("Pandas: " + panda);
            String pandaName = ((JSONObject)panda).get("name").toString();
            String type = ((JSONObject)panda).get("type").toString();
            String fieldName = ((JSONObject)panda).get("field").toString();
            String follow = ((JSONObject)panda).get("follow").toString();
            switch(type){
                case "BigPanda":
                    level.addAnimal(new BigPanda(), fieldName, pandaName, follow);
                    break;
                case "NervousPanda":
                    level.addAnimal(new NervousPanda(), fieldName, pandaName, follow);
                    break;
                case "SleepyPanda":
                    level.addAnimal(new SleepyPanda(), fieldName, pandaName, follow);
                    break;
            }

        }

        for (var thing : things){
            System.out.println("Things: " + thing);
            String thingName = ((JSONObject)thing).get("name").toString();
            String type = ((JSONObject)thing).get("name").toString();
            String field = ((JSONObject)thing).get("name").toString();
            switch(type){
                case "ArcadeMachine":
                    level.addThing(new ArcadeMachine(), field, thingName);
                    break;
                case "Couch":
                    level.addThing(new Couch(), field, thingName);
                    break;
                case "ChocolateVendingMachine":
                    level.addThing(new ChocolateVendingMachine(), field, thingName);
                    break;
            }
        }

    }

}
