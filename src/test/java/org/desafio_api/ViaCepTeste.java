package org.desafio_api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.desafio_api.supports.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ViaCepTeste extends BaseTest {

    @Test
    public void validZipCodeTest() {
        given()
            .spec(requestSpec)
        .when()
            .get("92440094/" + JSON)
        .then()
            .log().body()
            .statusCode(HttpStatus.SC_OK);
    }

}