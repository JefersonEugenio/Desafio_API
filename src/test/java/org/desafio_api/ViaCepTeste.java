package org.desafio_api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.desafio_api.supports.BaseTest;
import org.desafio_api.supports.Fakers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ViaCepTeste extends BaseTest {

    private Fakers fakers = new Fakers();

    @Feature("Consulta de CEP na PUCRS")
    @DisplayName("Validar CEP")
    @Description("O usuário insere um CEP válido")
    @Test
    public void validateZipCodeTest() {
        given()
            .spec(requestSpec)
        .when()
            .get(CEP_PUCRS + JSON)
        .then()
            .spec(responseSpecJson)
            .log().body()
            .statusCode(HttpStatus.SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "validarCEPJsonSchemas.json"));
    }

    @Feature("Consulta de CEP aleatória")
    @DisplayName("Invalidar CEP")
    @Description("O usuário insere aleatoriamente um CEP inválido")
    @Test
    public void invalidateZipCodeTest() {
        given()
            .spec(requestSpec)
        .when()
            .get( fakers.getCode() + JSON)
        .then()
            .spec(responseSpecJson)
            .log().body()
            .statusCode(HttpStatus.SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "invalidoCEPJsonSchemas.json"));
    }

    @Feature("EXTRA")
    @DisplayName("Verifica CEP e logradouro")
    @Description("O usuario insere cidade e rua")
    @Test
    public void verificaCEPLogradouroTest() {
        given()
            .spec(requestSpec)
        .when()
            .get( EXTRA)
        .then()
            .spec(responseSpecJson)
            .log().body()
            .statusCode(HttpStatus.SC_OK)
            .body("cep[0]", is("92440-284"))
            .body("bairro[0]", is("Guajuviras"))
            .body("localidade[0]", is("Canoas"))
            .body("uf[0]", is("RS"))
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas" + File.separator + "verificadoCEPLogradouroJsonSchemas.json"));
    }

}