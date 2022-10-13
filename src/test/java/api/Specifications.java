package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static utils.Configuration.getConfigurationValue;

public class Specifications {

    public static RequestSpecification requestRickAndMorty(){
        return new RequestSpecBuilder()
                .setBaseUri(getConfigurationValue("serialBaseUrl"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestReqres(){
        return new RequestSpecBuilder()
                .setBaseUri(getConfigurationValue("reqresUrl"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseOK200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseOK201() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();
    }
}