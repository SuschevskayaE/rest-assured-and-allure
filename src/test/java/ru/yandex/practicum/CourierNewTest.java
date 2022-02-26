package ru.yandex.practicum;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.yandex.practicum.scooter.api.CourierClient;
import ru.yandex.practicum.scooter.api.model.Courier;
import ru.yandex.practicum.scooter.api.model.CourierCredentials;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourierNewTest {

    private CourierClient courierClient;
    private int courierId;

    @BeforeAll
    public void setUp() {
        courierClient = new CourierClient();
    }

    @AfterAll
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @Test
    public void courierCanBeCreatedWithValidData() {
        Courier courier = Courier.getRandom();

        boolean isCourierCreated = courierClient.create(courier);
        courierId = courierClient.login(CourierCredentials.from(courier));

        assertTrue(isCourierCreated, "Courier is not created");
        assertThat("Courier id is incorrect", courierId, is(not(0)));
    }

}
