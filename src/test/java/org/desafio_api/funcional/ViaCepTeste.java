package org.desafio_api.funcional;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.desafio_api.baseTeste.BaseTest;
import org.desafio_api.dto.ViaCepDTO;
import org.desafio_api.stubs.ViaCepStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViaCepTeste extends BaseTest {

    @Feature("Consulta de CEP na PUCRS")
    @Description("O usuário insere um CEP válido")
    @Test
    @DisplayName("Validar CEP")
    public void deveRetornar200ValidarCEP_PUC() {
        String cepPUC = "90619-900";

        given()
            .when()
                .get(cepPUC + "/json")
            .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/validarCEPJsonSchemas.json"))
                .body("cep", equalTo("90619-900"),
                        "complemento", equalTo("6681"),
                        "logradouro", equalTo("Avenida Ipiranga"))
        ;
    }

    @Feature("Consulta de CEP endereço")
    @Description("O usuario insere UF, cidade e logradouro")
    @Test
    @DisplayName("Verifica UF, cidade e logradouro")
    public void deverVerificarEnderecoPorCEP() {

        String uf = "RS";
        String cidade = "Canoas";
        String logradouro = "Guajuviras";

        given()
        .when()
            .get(uf + "/" + cidade + "/" + logradouro + "/json")
        .then()
            .log().body()
            .statusCode(HttpStatus.SC_OK)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/verificadoCEPLogradouroJsonSchemas.json"))
            .body("[0].bairro", equalTo("Guajuviras"),
                    "localidade[0]", equalTo("Canoas"),
                    "[0].uf", equalTo("RS"))
        ;
    }

    @Feature("Consulta de CEP endereço")
    @Description("O usuário não insere a UF, apenas a cidade e o logradouro")
    @Test
    @DisplayName("Verifica sem informação UF e com informação cidade e logradouro")
    public void deveVerificarEnderecoPorCEPComUFVazio() {

        String uf = "";
        String cidade = "Canoas";
        String logradouro = "Guajuviras";

        given()
            .when()
                .get(uf + "/" + cidade + "/" + logradouro + "/json")
            .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("ViaCEP 400"),
                        containsString("Http 400"),
                        containsString("{Bad Request}"))
        ;
    }

    @Feature("Consulta de CEP endereço")
    @Description("O usuário não insere a cidade, apenas a UF e o logradouro")
    @Test
    @DisplayName("Verifica sem informação cidade e com informação UF e logradouro")
    public void deveVerificarEnderecoPorCEPComCidadeVazio() {

        String uf = "RS";
        String cidade = "";
        String logradouro = "Guajuviras";

        given()
            .when()
                .get(uf + "/" + cidade + "/" + logradouro + "/json")
            .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("ViaCEP 400"),
                        containsString("Http 400"),
                        containsString("{Bad Request}"))
        ;
    }

    @Feature("Consulta de CEP endereço")
    @Description("O usuário não insere o logradouro, apenas a UF e a cidade")
    @Test
    @DisplayName("Verifica sem informação logradouro e com informação UF e cidade")
    public void deveVerificarEnderecoPorCEPComLogradouroVazio() {

        String uf = "RS";
        String cidade = "Canoas";
        String logradouro = "";

        given()
            .when()
                .get(uf + "/" + cidade + "/" + logradouro + "/json")
            .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("ViaCEP 400"),
                        containsString("Http 400"),
                        containsString("{Bad Request}"))
        ;
    }

    @Feature("Consulta de CEP com Stub")
    @Description("Teste para verificar a criação de um stub de ViaCepDTO e seus valores")
    @Test
    @DisplayName("Teste de CEP valido com Stub")
    public void deveRetornar200QuandoCepForValidoComStub() {
        String cep = "92440-094";

        ViaCepDTO response = given()
                                .when()
                                    .get(cep + "/json")
                                .then()
                                    .statusCode(HttpStatus.SC_OK)
                                    .extract()
                                    .as(ViaCepDTO.class);


        assertEquals(response.getCep(), ViaCepStub.ViaCepStub().getCep());
        assertEquals(response.getLogradouro(), ViaCepStub.ViaCepStub().getLogradouro());
        assertEquals(response.getComplemento(), ViaCepStub.ViaCepStub().getComplemento());
        assertEquals(response.getUnidade(), ViaCepStub.ViaCepStub().getUnidade());
        assertEquals(response.getBairro(), ViaCepStub.ViaCepStub().getBairro());
        assertEquals(response.getLocalidade(), ViaCepStub.ViaCepStub().getLocalidade());
        assertEquals(response.getUf(), ViaCepStub.ViaCepStub().getUf());
        assertEquals(response.getIbge(), ViaCepStub.ViaCepStub().getIbge());
        assertEquals(response.getGia(), ViaCepStub.ViaCepStub().getGia());
        assertEquals(response.getDdd(), ViaCepStub.ViaCepStub().getDdd());
        assertEquals(response.getSiafi(), ViaCepStub.ViaCepStub().getSiafi());
    }

}