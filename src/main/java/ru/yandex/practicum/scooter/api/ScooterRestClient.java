package ru.yandex.practicum.scooter.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ScooterRestClient {

    public final String BASE_URL = "https://qa-scooter.praktikum-services.ru/api/v1/";

    protected RequestSpecification getBaseReqSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

}
