package DragonManager.Models;

import DragonManager.ModelBehaviours.Behaviours.Inferior;
import DragonManager.ModelBehaviours.Utilities.DragonRaceUtilities;
import DragonManager.ModelBehaviours.Utilities.JsonSerializable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class Dragon implements JsonSerializable, Inferior {
    public DragonRace race;
    public int lifeSpan;
    public String name;

    public Dragon(){}

    public Dragon(String name, int lifeSpan, DragonRace race) {
        this.name = name;
        this.lifeSpan = lifeSpan;
        this.race = race;
    }

    @Override
    public JSONObject serialize() throws Exception {
        JSONObject serialized = new JSONObject();

        //putting our data to a JSON object
        serialized.put("life-span", lifeSpan);
        serialized.put("name", name);
        // race attribute is not an string
        // to convert it into string it used by a helper class - DragonRaceUtilities
        serialized.put("race", DragonRaceUtilities.convertToString(race));



        return serialized;
    }

    @Override
    public void deserialize(String json) throws Exception {
        JSONParser parser = new JSONParser();

        //casting the result of parsing in to a JSONObject
        //because the parse method returns an Object instance
        JSONObject data = (JSONObject) parser.parse(json);

        name = (String) data.get("name");
        lifeSpan = Integer.parseInt(String.valueOf(data.get("life-span")));

        /**
         * using the helper class to converting string value to an Enum value
         * @see DragonRaceUtilities
         */
        race = DragonRaceUtilities.convetStringToDataEnum((String) data.get("race"));

    }

    public ArrayList<Dragon> deserializeArray(JSONArray array) throws Exception {
        System.out.println(array.toJSONString());
        ArrayList<Dragon> result = new ArrayList<>();
        var itr = array.iterator();

        while(itr.hasNext()){
            var json = (JSONObject) itr.next();


            Dragon d = new Dragon((String)json.get("name"),
                                    Integer.parseInt((String)json.get("life-span")),
                                    DragonRaceUtilities.convetStringToDataEnum((String) json.get("race"))
                                );

            result.add(d);


        }

        return new ArrayList<>();
    }

    @Override
    public String toString() {
        try {

            return "a " + DragonRaceUtilities.convertToString(race) + " named " + name;

        } catch (Exception e) {

            e.printStackTrace();

        }
        return name;
    }

    @Override
    public void attack() {
        System.out.println("fire");
    }
}
