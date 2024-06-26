package org.desafio_api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class test {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://viacep.com.br/ws";
    }

    @Test
    public void deveListar() {
        RestAssured.given()
                .when()
                    .get("/92440094/json")

                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void teste() {
        when().
                get("https://reqres.in/api/users?page=2").
//                get("https://reqres.in/api/users/7").
        then().
                log().body().
                statusCode(200);
    }

}