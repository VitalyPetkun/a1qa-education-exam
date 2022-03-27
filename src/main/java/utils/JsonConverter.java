package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    private static Gson gson;

    private JsonConverter() {
        gson = new Gson();
    }

    private static Gson getGson() {
        if (gson == null)
            new JsonConverter();
        return gson;
    }

    public static <T> T getObject(JsonReader jsonReader, Class<T> cls) {
        SmartLogger.logInfo("Converting jsonReader to Object");
        return getGson().fromJson(jsonReader, cls);
    }

    public static <T> T getObject(String jsonString, Class<T> cls) {
        SmartLogger.logInfo("Converting jsonString to Object");
        return getGson().fromJson(jsonString, cls);
    }

    public static <T> List<T> getList(String jsonString, Class<T> cls) {
        SmartLogger.logInfo("Converting jsonString to List");
        List<T> list = new ArrayList<>();
        JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();

        for (JsonElement jsonElement : jsonArray) {
            list.add(getObject(jsonElement.toString(), cls));
        }

        return list;
    }

    public static String getString(Object object) {
        SmartLogger.logInfo("Converting Object to String");
        return getGson().toJson(object);
    }
}