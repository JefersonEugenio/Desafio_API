package org.desafio_api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class ViaCepTeste {

    @Test
    public void validZipCodeTest() {
        RestAssured.given()
                .when()
                    .get("/92440094/json")

                .then()
                .log().body()
                .statusCode(200);
    }

}