package org.desafio_api.baseTeste;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setup() {

        RestAssured.baseURI = "https://viacep.com.br/ws/";

    }

}