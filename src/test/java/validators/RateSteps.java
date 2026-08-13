package validators;

import enums.CurrenciesNaming;
import page.BasePage;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;

public class RateSteps {
    public String getResponse(CurrenciesNaming query) {
        return  BasePage.baseProperties(query)
                .statusCode(200)
                .header("Content-Type", containsString("application/json"))
                .body("$", hasKey("amount"))
                .body("$", hasKey("grow"))
                .body("$", hasKey("scale"))
                .extract().asString();
    }
}
