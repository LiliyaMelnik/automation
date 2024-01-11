package api.utils;

import com.google.gson.Gson;

public class Utils {

    private Utils() {
        throw new IllegalArgumentException("This is utility class");
    }

    public static <T> String toJson(T object) {
        return new Gson().toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return new Gson().fromJson(json, classOfT);
    }
}
