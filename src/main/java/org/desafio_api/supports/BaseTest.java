package org.desafio_api.supports;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest extends EndPoints {

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpecJson;

    @BeforeEach
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();

        responseSpecJson = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

    }

}