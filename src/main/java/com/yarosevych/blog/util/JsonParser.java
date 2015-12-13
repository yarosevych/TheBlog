package com.yarosevych.blog.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonParser {

    public static Map<String, String> parsePost(String json) {
        Map<String, String> parsedJson = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            parsedJson.put("nickname", jsonObject.getString("nickname"));
            parsedJson.put("topic", jsonObject.getString("topic"));
            parsedJson.put("body", jsonObject.getString("body"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsedJson;
    }

    public static Map<String, Object> parseComment(String json) {
        Map<String, Object> parsedJson = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            parsedJson.put("body", jsonObject.getString("body"));
            parsedJson.put("postId", jsonObject.getInt("postId"));
            parsedJson.put("nickname", jsonObject.getString("nickname"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsedJson;
    }
}
