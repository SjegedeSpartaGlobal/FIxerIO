package com.spartaglobal.fixerio.RatesService;

import com.spartaglobal.fixerio.RatesService.RatesJsonDeserialiser;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.UUID;

public class RatesWriter {

    private FileWriter file;
    private RatesJsonDeserialiser parser;

    public RatesWriter(JSONObject jsonObject) {
        try {
            file = new FileWriter("resources/"+getUniqueFileName("json"));
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getUniqueFileName(String extension) {
        String fileName = MessageFormat.format("{0}.{1}", UUID.randomUUID(), extension.trim());
        return fileName;
    }
}
