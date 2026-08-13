package validators;

import enums.CurrenciesNaming;
import page.BasePage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;
import static org.testng.Assert.assertTrue;


public class RateValidator {

    public void validateSchema(CurrenciesNaming query){
        BasePage.baseProperties(query)
        .body(matchesJsonSchemaInClasspath("schemas/rate_schema.json"));
    }

    public void validateHeaders(CurrenciesNaming query){
        BasePage.baseProperties(query)
                 .header("Content-Type", containsString("application/json"));
    }

    public void validateKeys(CurrenciesNaming query){
        BasePage.baseProperties(query)
                .body("$", hasKey("amount"))
                .body("$", hasKey("grow"))
                .body("$", hasKey("scale"));
    }

    public void validateRegex(CurrenciesNaming query) {
        RateSteps rateSteps = new RateSteps();
        String responseBody = rateSteps.getResponse(query);
        String regex = "amount\"\\s*:\\s*\"\\d+,\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(responseBody);
        assertTrue(matcher.find(), "error");
    }

    public void validateStatusCode(int statusCode, CurrenciesNaming query) {
        BasePage.baseProperties(query)
                .statusCode(statusCode);
    }
}
