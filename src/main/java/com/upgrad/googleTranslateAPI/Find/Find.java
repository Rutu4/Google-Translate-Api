package com.upgrad.googleTranslateAPI.Find;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.net.URLEncoder;


import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import com.upgrad.googleTranslateAPI.GoogleAPI;
import com.upgrad.googleTranslateAPI.Translate.Language;


    public class Find extends GoogleAPI {


        private static String URL = "https://www.googleapis.com/language/translate/v2/detect?key=" + GoogleAPI.key + "&q=";


        public static DetectResult execute(final String text) throws Exception {
            validateReferrer();

            final java.net.URL url = new URL(URL + URLEncoder.encode(text, ENCODING));

            final JSONObject json = retrieveJSON(url);

            JSONObject results = (JSONObject) ((JSONArray) json.getJSONObject("data").getJSONArray("detections").get(0)).get(0);
            return new DetectResult(
                    Language.fromString(results.getString("language")),
                    results.getBoolean("isReliable"),
                    results.getDouble("confidence"));
        }
    }

}
