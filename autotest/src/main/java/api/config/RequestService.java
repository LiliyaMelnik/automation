package api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static api.config.PropertyService.getPropertyFromApiFile;

public class RequestService {

    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT = "Content-Type";
    private static final String URL = String.valueOf(getPropertyFromApiFile("url"));

    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .addHeader(CONTENT, APPLICATION_JSON)
                .build();
    }
}
