package org.desafio_api.supports;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Fakers {

    private Faker faker = new Faker(new Locale("pt-BR"));
    private String code;

    public String getCode() {
        code = faker.address().zipCode();
        System.out.println("CEP: " + code);
        return code;
    }

}
