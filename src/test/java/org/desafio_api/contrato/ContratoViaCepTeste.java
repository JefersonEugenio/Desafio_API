package org.desafio_api.contrato;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.desafio_api.baseTeste.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;

public class ContratoViaCepTeste extends BaseTest {

    @Feature("Consulta de CEP contrato")
    @Description("Testa contrato para CEP válido")
    @Test
    @DisplayName("Teste de CEP válido")
    public void deveRetornar200QuandoCepForValido() {
        String cepValido = "01001000";

        given()
            .when()
                .get(cepValido + "/json")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body(matchesJsonSchemaInClasspath("schemas/validarCEPJsonSchemas.json"))
                .body("$", hasKey("cep"))
                .body("$", hasKey("logradouro"))
                .body("$", hasKey("complemento"))
                .body("$", hasKey("unidade"))
                .body("$", hasKey("bairro"))
                .body("$", hasKey("localidade"))
                .body("$", hasKey("uf"))
                .body("$", hasKey("ibge"))
                .body("$", hasKey("gia"))
                .body("$", hasKey("ddd"))
                .body("$", hasKey("siafi"));
    }

    @Feature("Consulta de CEP com formato")
    @Description("Testa contrato para CEP válido e formatação")
    @Test
    @DisplayName("Teste de CEP válidos com formatação")
    public void deveRetornar200QuandoCepValidoEmFormatoCerto() {
        String cepValidoComFormatado = "01001-000";

        given()
            .when()
                .get(cepValidoComFormatado + "/json")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/validarCEPJsonSchemas.json"))
                .body("$", hasKey("cep"))
                .body("$", hasKey("logradouro"))
                .body("$", hasKey("complemento"))
                .body("$", hasKey("unidade"))
                .body("$", hasKey("bairro"))
                .body("$", hasKey("localidade"))
                .body("$", hasKey("uf"))
                .body("$", hasKey("ibge"))
                .body("$", hasKey("gia"))
                .body("$", hasKey("ddd"))
                .body("$", hasKey("siafi"))
        ;
    }

    @ParameterizedTest
    @Description("Testa contrato para CEP inválido")
    @ValueSource(strings = {"000000000", "1234", "95010A10", "999999999"})
    public void deveRetornar400QuandoCepForInvalido(String cepInvalido) {
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

    @Test
    @DisplayName("Teste de CEP que não foi registrado")
    public void deveRetornar200ErrorQuandoCepForNaoRegistrado() {
        String cepFulano = "01234567";

        given()
            .when()
                .get(cepFulano + "/json")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/JsonErroCEPJsonSchemas.json"))
                .body("$", hasKey("erro"))
        ;

    }

}