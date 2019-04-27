package com.spartaglobal.fixerio;

import com.spartaglobal.fixerio.HTTPController.HTTPManager;
import com.spartaglobal.fixerio.RatesService.RatesDTO;

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
