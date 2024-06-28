package org.desafio_api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.desafio_api.supports.BaseTest;
import org.desafio_api.supports.Fakers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ViaCepTeste extends BaseTest {

    private Fakers fakers = new Fakers();

    @Feature("Consulta de CEP na PUCRS")
    @DisplayName("Validar CEP")
    @Description("O usuário insere um CEP válido")
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

    @Feature("Consulta de CEP aleatória")
    @DisplayName("Invalidar CEP")
    @Description("O usuário insere aleatoriamente um CEP inválido")
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