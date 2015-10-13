package com.yarosevych.blog.util;

import com.yarosevych.blog.domain.Post;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oyarosevych on 12.10.2015.
 */
public class BlogJsonParser {

    public static Map<String, String> parseAddPost(String json) {
        Map<String, String> parsedJson = new HashMap<String, String>();
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
}
