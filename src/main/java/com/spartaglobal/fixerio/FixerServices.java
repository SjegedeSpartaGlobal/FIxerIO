package com.spartaglobal.fixerio;

public class FixerServices {
    private HTTPManager httpManager;
    private RatesDTO rates;

    public FixerServices() {
        httpManager = new HTTPManager();
        rates = new RatesDTO(httpManager.getResponseBody());

    }

    public RatesDTO getRates() {
        return rates;
    }
}
