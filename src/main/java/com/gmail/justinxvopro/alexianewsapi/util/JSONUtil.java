package com.gmail.justinxvopro.alexianewsapi.util;

import org.json.JSONObject;

public class JSONUtil {
    public static String getOrNull(JSONObject o, String key) {
	return o.optString(key, null);
    }
}
