package utils;

import com.google.gson.*;
import org.testng.Assert;

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

    public static <T> List<T> getList(String jsonString, Class<T> cls) {
        SmartLogger.logInfo(String.format("Converting json String to List<%s>", cls.getName()));
        List<T> list = new ArrayList<>();
        JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();

        for (JsonElement jsonElement : jsonArray) {
            list.add(getObject(jsonElement.toString(), cls));
        }

        return list;
    }

    public static <T> T getObject(String jsonString, Class<T> cls) throws JsonSyntaxException {
        SmartLogger.logInfo(String.format("Converting json string to %s", cls.getName()));
        return getGson().fromJson(jsonString, cls);
    }

    public static String getString(Object object) {
        SmartLogger.logInfo("Converting Object to String");
        return getGson().toJson(object);
    }

    public static void assertIsJsonArrayFormatResponse(String response) {
        boolean actualResult;

        try {
            JsonConverter.getObject(response, JsonArray.class);
            actualResult = true;
        } catch (JsonSyntaxException exception) {
            SmartLogger.logError("Can't converting response to json array.");
            actualResult = false;
        }

        Assert.assertTrue(actualResult, "Response isn't json array format.");
    }

    public static void assertIsJsonElementFormatResponse(String response) {
        boolean actualResult;

        try {
            JsonConverter.getObject(response, JsonElement.class);
            actualResult = true;
        } catch (JsonSyntaxException exception) {
            SmartLogger.logError("Can't converting response to json element.");
            actualResult = false;
        }

        Assert.assertTrue(actualResult, "Response isn't json element format.");
    }
}