package com.spartaglobal.fixerio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private String apiKey;
    Properties appProperties;

    private String BaseUrl;

    public PropertiesReader() {
        try {
            appProperties = new Properties();
            appProperties.load(new FileReader("resources/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        apiKey = appProperties.getProperty("api_key");
    }


    public String getApiKey() {
        return apiKey;
    }


    public String getBaseUrl() {
        return appProperties.getProperty("base_url");
    }

    public String getEndPoint(){
        return appProperties.getProperty("latest_endpoint");
    }

}
