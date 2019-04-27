package com.spartaglobal.fixerio.RatesService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RatesJsonDeserialiser {
    private JSONObject ratesJson;
    private JSONParser parser;

    public RatesJsonDeserialiser(String jsonString) {
        try {
            parser = new JSONParser();
            ratesJson = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getRatesJson() {
        return ratesJson;
    }
}
