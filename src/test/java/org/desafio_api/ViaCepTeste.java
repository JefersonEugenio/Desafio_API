package org.desafio_api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class test {
    
    @Test
    public void deveListar() {
        RestAssured.given()
                .when()
                    .get("/92440094/json")

                .then()
                .log().body()
                .statusCode(200);
    }

}