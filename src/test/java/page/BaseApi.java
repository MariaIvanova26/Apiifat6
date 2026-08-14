package page;

import enums.CurrenciesNaming;
import io.restassured.response.ValidatableResponse;
import utils.PropertyReader;
import static io.restassured.RestAssured.given;

public class BaseApi {

    public static final String BASE_URL = PropertyReader.getProperty("apiifat.url");

    public static String buildUrl(CurrenciesNaming query) {
        return BaseApi.BASE_URL.formatted(query);
    }

    public static ValidatableResponse baseProperties(CurrenciesNaming query){
        return   given()
                .log().all()
                .when()
                .get(BaseApi.buildUrl(query))
                .then().log().all();
    }
}
