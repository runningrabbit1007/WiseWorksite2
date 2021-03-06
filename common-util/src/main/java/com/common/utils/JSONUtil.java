package com.common.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.util.Base64;

import com.common.utils.system.AppUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class JSONUtil {

    private static final Gson gson = new Gson();

    private static final JsonParser jsonParser = new JsonParser();

    private JSONUtil() {
        throw new AssertionError();
    }

    public static String toJSONFromGeneric(Object object) {
        Type mySuperClass = object.getClass().getGenericSuperclass();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object, mySuperClass);
    }

    /**
     * An object into a string
     *
     * @param object
     * @return
     */
    public static String toJSON(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /**
     * Returns the JSON String representation of an object.
     *
     * @param object
     *            an arbitrary object.
     * @param typeOfT
     *            the type of the desired arbitrary object.
     * @return a JSON String representation of the object.
     */
    public static String toJson(Object object, Type typeOfT) {
        return gson.toJson(object, typeOfT);
    }


    /**
     * Put the string into a generic objects
     *
     * @param json
     * @param type
     * @return
     */
    public static <T> T parseObject(String json, Type type) {
        return gson.fromJson(json, type);
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> getJsonObject(String jsonArrayData, Type type) {
        ArrayList<T> arrayList = new ArrayList();
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(jsonArrayData);
            int iSize = jsonArray.length();
            if (iSize > 0) {
                for (int i = 0; i < iSize; i++) {
                    String objStr = jsonArray.getJSONObject(i).toString();
                    T obj = parseObject(objStr, type);
                    arrayList.add(obj);
                }
            } else {
                return null;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return arrayList;
    }


    /**
     * Returns a JsonObject object from a String representation of a JSON
     * object.
     *
     * @param jsonStringObject
     *            a String representation of a JSON object.
     * @return a JsonObject object from the specified String.
     * @throws JsonSyntaxException
     *             if JSON is not a valid representation for an object of type.
     * @throws IllegalStateException
     *             if the element is of another type.
     */
    public static JsonObject toJsonObject(String jsonStringObject)
            throws JsonSyntaxException, IllegalStateException {
        return jsonParser.parse(jsonStringObject).getAsJsonObject();
    }

    /**
     * Returns a JsonArray object from a String representation of a JSON array
     * object.
     *
     * @param jsonStringArray
     *            a String representation of a JSON array object.
     * @return a JsonArray object from the specified String.
     * @throws JsonSyntaxException
     *             if JSON is not a valid representation for an object of type.
     * @throws IllegalStateException
     *             if the element is of another type.
     */
    public static JsonArray toJsonArray(String jsonStringArray)
            throws JsonSyntaxException, IllegalStateException {
        return jsonParser.parse(jsonStringArray).getAsJsonArray();
    }

    public static JsonElement toJsonElement(String jsonStringElement)
            throws JsonSyntaxException, IllegalStateException {
        return jsonParser.parse(jsonStringElement);
    }



    /**
     * Checks if the provided String is a representation of a JSON object.
     *
     * @param jsonStringObject
     *            a possible String representation of a JSON object.
     * @return true if this element is of type JsonObject, false otherwise.
     */
    public static boolean isJsonObject(String jsonStringObject) {
        try {
            return toJsonObject(jsonStringObject).isJsonObject();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /**
     * Checks if the provided String is a representation of a JSON array.
     *
     * @param jsonStringArray
     *            a possible String representation of a JSON array.
     * @return true if this element is of type JsonArray, false otherwise.
     */
    public static boolean isJsonArray(String jsonStringArray) {

        try {
            return toJsonArray(jsonStringArray).isJsonArray();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public static Map<String, Object> parseJSON2Map(String jsonStr){
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                .create();
        Map<String, Object> map = gson.fromJson(jsonStr,
                new TypeToken<Map<String, Object>>() {
                }.getType());
        return map;
    }


    /**
     * @param fileName
     * @return
     */
    @SuppressLint("NewApi")
    @SuppressWarnings("resource")
    public static String FileToBase64(String fileName) {
        String data = "";
        try {
            File file = new File(fileName);
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length() + 100];
            int length = in.read(buffer);
            data = Base64.encodeToString(buffer, 0, length, Base64.NO_WRAP);
        } catch (Exception ex) {
        }
        return data;
    }




}
