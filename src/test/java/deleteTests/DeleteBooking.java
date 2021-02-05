package test.java.deleteTests;

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

public class DeleteBooking extends BaseTest {

    String bookingId;

    private static final Logger log = LogManager.getLogger(DeleteBooking.class.getName());

    @BeforeMethod
    public void setUp() throws IOException {
        bookingId = createBooking();
    }

    @Test
    public void verifyDeleteBookingTest() throws IOException {

        Response response;
        Response responseGetDeletedBooking;
        log.info("Starting test: Delete Booking");

        String endpointURI = URL.getEndpoint("/booking/" + bookingId);

        response = RESTCalls.DELETERequest(endpointURI);

        int statusCode = response.getStatusCode();

        Assertions.verifyStatusCode(response, 201);

        responseGetDeletedBooking = RESTCalls.GETRequest(endpointURI);

        Assertions.verifyNotFound(responseGetDeletedBooking, "Not Found");

    }
}

