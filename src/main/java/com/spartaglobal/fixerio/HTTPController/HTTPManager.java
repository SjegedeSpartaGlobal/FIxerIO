package com.spartaglobal.fixerio.HTTPController;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPManager {

    private CloseableHttpResponse fullResponse;


    public HTTPManager() {
        makeAllRatesCall();
    }

    //cornstructor methods
    private void makeAllRatesCall(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getLatestRates = new HttpGet(PropertiesReader.getBaseurl() +PropertiesReader.getEndPoint()+PropertiesReader.getApiAccessKey()+PropertiesReader.getApiKey());
            System.out.println(PropertiesReader.getBaseurl() +PropertiesReader.getEndPoint()+PropertiesReader.getApiAccessKey()+PropertiesReader.getApiKey());
            fullResponse = httpClient.execute(getLatestRates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Accessor methods
    public String getResponseBody(){
        String bodyResult = null;
        try{
           bodyResult = EntityUtils.toString(fullResponse.getEntity());

        }catch(IOException e){

        }

        return bodyResult;
    }
}
