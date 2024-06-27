package org.desafio_api.supports;

import io.restassured.RestAssured;
import org.desafio_api.utils.ObjectsUtils;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = ObjectsUtils.getPropertiesData("endpoints", "BASE_URI");
    }

}