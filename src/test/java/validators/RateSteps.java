package validators;

import enums.CurrenciesNaming;
import page.BaseApi;

public class RateSteps {

    public String getResponse(CurrenciesNaming query) {
        return  BaseApi.baseProperties(query)
                .extract().asString();
    }
}
