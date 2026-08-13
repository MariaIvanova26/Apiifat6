package page;

import enums.CurrenciesNaming;
import io.restassured.response.ValidatableResponse;
import utils.PropertyReader;
import static io.restassured.RestAssured.given;

public class BasePage {

    public static final String BASE_URL = PropertyReader.getProperty("apiifat.url");

    public static String buildUrl(CurrenciesNaming query) {
        return BasePage.BASE_URL.formatted(query);
    }

    public static ValidatableResponse baseProperties(CurrenciesNaming query){
        return   given()
                .log().all()
                .when()
                .get(BasePage.buildUrl(query))
                .then().log().all();
    }
}
