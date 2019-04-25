package com.spartaglobal.fixerio;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPManager {

    private PropertiesReader properties = new PropertiesReader();
    private CloseableHttpResponse fullResponse;


    public HTTPManager() {
        makeAllRatesCall();
    }

    //cornstructor methods
    private void makeAllRatesCall(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getLatestRates = new HttpGet(properties.getBaseUrl() +properties.getEndPoint()+"?access_key="+properties.getApiKey());
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
