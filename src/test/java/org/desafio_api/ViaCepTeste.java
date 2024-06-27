package org.desafio_api;

import org.apache.http.HttpStatus;
import org.desafio_api.supports.BaseTest;
import org.desafio_api.supports.Fakers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ViaCepTeste extends BaseTest {

    private Fakers fakers = new Fakers();

    @Test
    public void validZipCodeTest() {
        given()
            .spec(requestSpec)
        .when()
            .get(CEP_PUCRS + JSON)
        .then()
            .spec(responseSpecJson)
            .log().body()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void validZipCode2Test() {
        given()
            .spec(requestSpec)
        .when()
            .get( fakers.getCode() + JSON)
        .then()
            .spec(responseSpecJson)
            .log().body()
            .statusCode(HttpStatus.SC_OK);
    }

}