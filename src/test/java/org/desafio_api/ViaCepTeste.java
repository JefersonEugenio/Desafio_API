package org.desafio_api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.desafio_api.supports.BaseTest;
import org.junit.jupiter.api.Test;

public class ViaCepTeste extends BaseTest {

    @Test
    public void validZipCodeTest() {
        RestAssured.given()
                .when()
                    .get("/92440094/json")

                .then()
                    .log().body()
                    .statusCode(HttpStatus.SC_OK);
    }

}