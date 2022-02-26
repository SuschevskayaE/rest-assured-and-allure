package ru.yandex.practicum.scooter.api;

import io.qameta.allure.Step;
import ru.yandex.practicum.scooter.api.model.Courier;
import ru.yandex.practicum.scooter.api.model.CourierCredentials;

import static io.restassured.RestAssured.given;

public class CourierClient extends ScooterRestClient {

    public final String PATH = BASE_URL + "courier/";

    @Step("Create courier {courier}")
    public boolean create(Courier courier) {
        return given()
                .spec(getBaseReqSpec())
                .body(courier)
                .when()
                .post(PATH)
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");
    }

    @Step("Login as {courierCredentials}")
    public int login(CourierCredentials courierCredentials) {
        return given()
                .spec(getBaseReqSpec())
                .body(courierCredentials)
                .when()
                .post(PATH + "login/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    @Step("Delete courier {courierId}")
    public boolean delete(int courierId) {
        return given()
                .spec(getBaseReqSpec())
                .when()
                .delete(PATH + courierId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");
    }

}