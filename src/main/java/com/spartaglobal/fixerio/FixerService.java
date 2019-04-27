package com.spartaglobal.fixerio;

import com.spartaglobal.fixerio.RatesService.RatesJsonDeserialiser;
import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface FixerService {

    public JSONObject getRates();

    public boolean getSuccess();

    public int getTimeStamp();

    public String getBase();

    public LocalDate getDate();
}
