package com.spartaglobal.fixerio.RatesService;

import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class RatesDTO {

    private JSONObject rates;
    private JSONObject ratesRates;

    public RatesDTO(String jsonString) {
        RatesJsonDeserialiser parser = new RatesJsonDeserialiser(jsonString);
        rates = parser.getRatesJson();
        ratesRates = (JSONObject) rates.get("rates");
    }

    public JSONObject getRates() {
        return ratesRates;
    }

    public double getRate(String key) {
        JSONObject tempRates = getRates();
        double value = (double) tempRates.get(key);
        return value;
    }

    public boolean getSuccess(){
        return (boolean) rates.get("success");
    }

    public int getTimeStamp(){
        return (int) rates.get("timestamp");
    }

    public String getBase(){
        return (String) rates.get("base");
    }

    public LocalDate getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate date  = LocalDate.parse((String) rates.get("date"), formatter);
        return date;
    }
    
    public int amount(){
        return ratesRates.size();
    }
}
