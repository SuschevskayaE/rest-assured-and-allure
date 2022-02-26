package ru.yandex.practicum.scooter.api.model;

public class CourierCredentials {

    public String login;
    public String password;

    public CourierCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CourierCredentials from(Courier courier) {
        return new CourierCredentials(courier.login, courier.password);
    }

    @Override
    public String toString() {
        return "CourierCredentials {" +
                "login:" + login + "," +
                "password:" + password + "}";
    }

}