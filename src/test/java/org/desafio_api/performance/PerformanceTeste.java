package org.desafio_api.performance;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.desafio_api.baseTeste.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PerformanceTeste extends BaseTest {

    @Feature("Tempo de resposta CEP")
    @Description("Teste de tempo de resposta para CEP válido")
    @Test
    @DisplayName("Tempo CEP")
    public void deveResponderRapidamenteParaCepValido() {
        String cepValido = "92440094";

        given()
            .when()
                .get(cepValido + "/json")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(3000L));
    }

}