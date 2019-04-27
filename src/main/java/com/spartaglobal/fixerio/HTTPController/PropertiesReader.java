package com.spartaglobal.fixerio.HTTPController;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static Properties appProperties;
    private static String apiKey;
    private static  String baseurl;
    private static String apiAccessKey;
    private static String latestEndpoint;

    private PropertiesReader() {

    }


    public static String getApiKey() {
        if(apiKey==null) {
            setUp();
        }
        return apiKey;
    }


    public static String getBaseurl() {
        if(baseurl==null){
            setUp();
        }

        return baseurl;
    }

    public static String getEndPoint(){
        if(latestEndpoint==null){
            setUp();
        }

        return latestEndpoint;
    }

    public static String getApiAccessKey() {
        if(apiAccessKey==null){
            setUp();
        }
        return apiAccessKey;
    }

    private static void setUp(){
        try {
            appProperties = new Properties();
            appProperties.load(new FileReader("resources/app.properties"));
            apiKey = appProperties.getProperty("api_key");
            apiAccessKey = appProperties.getProperty("api_access_query");
            latestEndpoint = appProperties.getProperty("latest_endpoint");
            baseurl = appProperties.getProperty("base_url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
