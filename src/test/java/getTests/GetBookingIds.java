package test.java.getTests;

import io.restassured.response.Response;
import main.java.base.Assertions;
import main.java.base.BaseTest;
import main.java.base.RESTCalls;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GetBookingIds extends BaseTest {

    String bookingId;

    private static Logger log = LogManager.getLogger(GetBookingIds.class.getName());

    @BeforeMethod
    public void setUp() throws IOException {
        bookingId = createBooking();
    }

    @Test
    public void verifyGetBookingIdsWithoutFilter() {

        Response response;
        log.info("Starting test: Get Booking Id Numbers" );

        String endpointURI = URL.getEndpoint("/booking");

        response = RESTCalls.GETRequest(endpointURI);

        Assertions.verifyStatusCode(response, 200);

        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assertions.verifyFalse(bookingIds.isEmpty());

    }

    @Test
    public void verifyGetBookingIdsWithFilter() {

        Response response;
        log.info("Starting test: Get Booking Id Numbers" );

        String endpointURI = URL.getEndpoint("/booking");

        response = RESTCalls.GETRequestWithQueryParam(endpointURI);

        Assertions.verifyStatusCode(response, 200);

        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assertions.verifyFalse(bookingIds.isEmpty());
    }

}

