package ru.yandex.practicum;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourierTest {

    @Test
    public void courierTest() {
        String login = "ivan07";
        String password = "ivan07";
        String firstName = "ivan07";
        String body = "{\"login\":\"" + login + "\","
                + "\"password\":\"" + password + "\","
                + "\"firstName\":\"" + firstName + "\"}";

        boolean ok = given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier/")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");

        String bodyLogin = "{\"login\":\"" + login + "\","
                + "\"password\":\"" + password + "\"}";

        int id = given()
                .header("Content-type", "application/json")
                .body(bodyLogin)
                .when()
                .post("https://qa-scooter.praktikum-services.ru/api/v1/courier/login/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");

        assertTrue(ok);
    }

}