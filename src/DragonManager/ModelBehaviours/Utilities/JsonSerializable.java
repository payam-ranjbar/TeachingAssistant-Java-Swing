package DragonManager.ModelBehaviours.Utilities;

import org.json.simple.JSONObject;

public interface JsonSerializable {
    JSONObject serialize() throws Exception;
    void deserialize(String json) throws Exception;
}
