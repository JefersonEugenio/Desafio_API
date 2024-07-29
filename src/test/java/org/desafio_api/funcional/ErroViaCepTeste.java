package org.desafio_api.funcional;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.desafio_api.baseTeste.BaseTest;
import org.desafio_api.supports.Fakers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ErroViaCepTeste extends BaseTest {

    private Fakers fakers = new Fakers();

    @Feature("Consulta de CEP aleatória")
    @Description("O usuário insere aleatoriamente um CEP inválido")
    @Test
    @DisplayName("Invalidar CEP")
    public void deveRetornar200QuandoCEPcomFaker() {
        given()
            .when()
                .get( fakers.getCode() + "/json")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/JsonErroCEPJsonSchemas.json"))
                .body("erro", equalTo("true"))
        ;
    }

    @Feature("Consulta CEP com inválido")
    @ParameterizedTest
    @DisplayName("Teste de CEP inválido")
    @ValueSource(strings = {"00000", "0000000", "000000000", "abcdefghij", "!?@#*&$%", "95 01010"})
    public void deveRetornar400QuandoCEPInvalido(String cepInvalido) {
        given()
            .when()
                .get(cepInvalido + "/json")
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("ViaCEP 400"),
                        containsString("Http 400"),
                        containsString("{Bad Request}"))
        ;

    }

    @Feature("Consulta de CEP vazio")
    @Description("O usuário não insere um CEP, e ele fica vazio")
    @Test
    @DisplayName("Vazio CEP")
    public void deveRetornar400QuandoCEPEstiverVazio() {
        String vazioCEP = "";

        given()
            .when()
                .get( vazioCEP + "/json")
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("ViaCEP 400"),
                        containsString("Http 400"),
                        containsString("{Bad Request}"))
        ;
    }

}