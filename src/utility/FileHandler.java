package utility;

import internal.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Ez az osztaly valositja meg a file elereseket.
 */
public final class FileHandler {
    private FileHandler(){}
    private static JSONObject jsonObject;


    @SuppressWarnings("Duplicates")
    public static Level loadMap(String mapName){
        Level level = new Level();
        try {
            jsonObject = (JSONObject) new JSONParser().parse(new FileReader("input/maps/" + mapName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONArray fields = (JSONArray) jsonObject.get("fields");
        JSONArray finishFields = (JSONArray) jsonObject.get("finishFields");
        JSONArray teleports = (JSONArray) jsonObject.get("teleports");
        JSONArray neighbours = (JSONArray) jsonObject.get("neighbours");
        JSONArray teleportNeighbours = (JSONArray) jsonObject.get("teleportNeighbours");
        JSONArray pandas = (JSONArray) jsonObject.get("pandas");
        JSONArray sleepyPandas = (JSONArray) jsonObject.get("sleepyPandas");
        JSONArray bigPandas = (JSONArray) jsonObject.get("bigPandas");
        JSONArray nervousPandas = (JSONArray) jsonObject.get("nervousPandas");
        JSONArray chocolateMachines = (JSONArray) jsonObject.get("chocolateMachines");
        JSONArray arcadeMachines = (JSONArray) jsonObject.get("arcadeMachines");
        JSONArray couches = (JSONArray) jsonObject.get("couches");

        for (Object field : fields){
            String fieldName = ((JSONObject)field).get("name").toString();
            boolean damagable = (int)((JSONObject)field).get("damagable") != 0;
            int health = Integer.parseInt (((JSONObject)field).get("damagable").toString());
            JSONArray jsonCoords = (JSONArray)((JSONObject)field).get("coords");
            int[] corrds = new int[jsonCoords.size()];
            for (int i = 0; i < jsonCoords.size(); ++i) {
                corrds[i] = (int)jsonCoords.get(i);
            }
            level.addField(new Field(fieldName, damagable, health, corrds));
        }

        for (Object finishField : finishFields){
            String fieldName = ((JSONObject)finishField).get("name").toString();
            JSONArray jsonCoords = (JSONArray)((JSONObject)finishField).get("coords");
            int[] corrds = new int[jsonCoords.size()];
            for (int i = 0; i < jsonCoords.size(); ++i) {
                corrds[i] = (int)jsonCoords.get(i);
            }
            level.addField(new FinishField(fieldName, corrds));
        }

        for (Object teleport : teleports){
            String fieldName = ((JSONObject)teleport).get("name").toString();
            JSONArray jsonCoords = (JSONArray)((JSONObject)teleport).get("coords");
            int[] corrds = new int[jsonCoords.size()];
            for (int i = 0; i < jsonCoords.size(); ++i) {
                corrds[i] = (int)jsonCoords.get(i);
            }
            level.addField(new Teleport(fieldName, corrds));
        }

        for (Object neighbour : neighbours){
            String fieldName = ((JSONObject)neighbour).get("name").toString();
            JSONArray fieldNeighbours = (JSONArray) ((JSONObject)neighbour).get("fields");
            Field field = level.getField(fieldName);
            if(field != null){
                for(Object fieldNeighbour : fieldNeighbours){
                    field.addNeighbour(level.getField(fieldNeighbour.toString()));
                }
            }
        }

        for (Object teleportNeighbour : teleportNeighbours){
            String teleportName = ((JSONObject)teleportNeighbour).get("name").toString();
            JSONArray fieldNeighbours = (JSONArray) ((JSONObject)teleportNeighbour).get("fields");
            Teleport teleport = (Teleport) level.getField(teleportName);
            if(teleport != null){
                for(Object fieldNeighbour : fieldNeighbours){
                    teleport.addTeleportNeighbour((Teleport)level.getField(fieldNeighbour.toString()));
                }
            }
        }

        for (Object panda : pandas){
            String pandaName = ((JSONObject)panda).get("name").toString();
            String fieldName = ((JSONObject)panda).get("field").toString();
            level.addAnimal(new Panda(pandaName, level.getField(fieldName)));
        }

        for (Object sleepyPanda : sleepyPandas){
            String pandaName = ((JSONObject)sleepyPanda).get("name").toString();
            String fieldName = ((JSONObject)sleepyPanda).get("field").toString();
            level.addAnimal(new SleepyPanda(pandaName, level.getField(fieldName)));
        }

        for (Object bigPanda : bigPandas){
            String pandaName = ((JSONObject)bigPanda).get("name").toString();
            String fieldName = ((JSONObject)bigPanda).get("field").toString();
            level.addAnimal(new BigPanda(pandaName, level.getField(fieldName)));
        }

        for (Object nervousPanda : nervousPandas){
            String pandaName = ((JSONObject)nervousPanda).get("name").toString();
            String fieldName = ((JSONObject)nervousPanda).get("field").toString();
            level.addAnimal(new NervousPanda(pandaName, level.getField(fieldName)));
        }

        for(Object chocolateMachine : chocolateMachines){
            String name = ((JSONObject)chocolateMachine).get("name").toString();
            String fieldName = ((JSONObject)chocolateMachine).get("field").toString();
            level.addThing(new ChocolateVendingMachine(name, level.getField(fieldName)));
        }

        for(Object arcadeMachine : arcadeMachines){
            String name = ((JSONObject)arcadeMachine).get("name").toString();
            String fieldName = ((JSONObject)arcadeMachine).get("field").toString();
            level.addThing(new ArcadeMachine(name, level.getField(fieldName)));
        }

        for(Object couch : couches){
            String name = ((JSONObject)couch).get("name").toString();
            String fieldName = ((JSONObject)couch).get("field").toString();
            level.addThing(new Couch(name, level.getField(fieldName)));
        }

        return level;
    }

}
