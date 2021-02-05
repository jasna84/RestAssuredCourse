package test.java.putTests;

import io.restassured.response.Response;
import main.java.base.Assertions;
import main.java.base.BaseTest;
import main.java.base.RESTCalls;
import main.java.utils.PayloadConverter;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PartialUpdateBooking extends BaseTest {

    String bookingId;

    private static final Logger log = LogManager.getLogger(PartialUpdateBooking.class.getName());

    @BeforeMethod
    public void setUp() throws IOException {
        bookingId = createBooking();
    }

    @Test
    public void partialUpdateBooking() throws IOException {

        Response response;
        Response responseGetUpdatedResource;
        log.info("Starting test: Partial Update Booking");

        String partialUpdateBookingPayload = PayloadConverter.generateString("PartialUpdateBooking.json");
        String endpointURI = URL.getEndpoint("/booking/" + bookingId);

        response = RESTCalls.PATCHRequestWithAuth(endpointURI, partialUpdateBookingPayload);

        Assertions.verifyStatusCode(response, 200);

        responseGetUpdatedResource = RESTCalls.GETRequest(endpointURI);

        Assertions.verifyStatusCode(responseGetUpdatedResource, 200);
        Assertions.verifyEqualName(responseGetUpdatedResource, "Jack");
        Assertions.verifyEqualLastName(responseGetUpdatedResource, "Brown");
        Assertions.verifyEqualTotalPrice(responseGetUpdatedResource, 111);
        Assertions.verifyEqualDepositPaid(responseGetUpdatedResource, true);
        Assertions.verifyEqualCheckin(responseGetUpdatedResource, "2018-01-01");
        Assertions.verifyEqualCheckout(responseGetUpdatedResource, "2019-01-01");
        Assertions.verifyEqualAdditionalNeeds(responseGetUpdatedResource, "Dinner");

    }
}

