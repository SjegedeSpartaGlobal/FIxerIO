package com.spartaglobal.fixerio;

import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RatesDTO {

    private JSONObject rates;

    public RatesDTO(String jsonString) {
        RatesJsonParser parser = new RatesJsonParser(jsonString);
        rates = parser.getRatesJson();
    }

    public JSONObject getRates() {
        return rates;
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
}
