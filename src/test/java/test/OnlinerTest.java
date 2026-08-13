package test;

import enums.CurrenciesNaming;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validators.RateSteps;
import validators.RateValidator;
import static enums.CurrenciesNaming.*;

public class OnlinerTest {
    private final RateSteps steps = new RateSteps();
    private final RateValidator validator = new RateValidator();

    @DataProvider(name = "currencies")
    public Object[][] currencyCheck() {
        return new Object[][]{
                {USD},
                {EUR},
                {RUB}
        };
    }

    @Test(dataProvider = "currencies")
    public void checkRates(CurrenciesNaming query) {
        steps.getResponse(query);
        validator.validateSchema(query);
        validator.validateHeaders(query);
        validator.validateKeys(query);
        validator.validateRegex(query);
        validator.validateStatusCode(200, query);
    }
}
