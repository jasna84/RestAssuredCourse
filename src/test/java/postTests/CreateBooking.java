package test.java.postTests;

import main.java.base.Assertions;
import main.java.base.RESTCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import main.java.base.BaseTest;
import main.java.utils.PayloadConverter;
import main.java.utils.TestUtils;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateBooking extends BaseTest {

    private static final Logger log = LogManager.getLogger(CreateBooking.class.getName());

    @Test
    public void verifyCreateBooking() throws IOException {

        Response response;
        log.info("Starting test: Create Booking");

        String createBookingPayload = PayloadConverter.generateString("CreateBooking.json");
        String endpointURI = URL.getEndpoint("/booking");

        response = RESTCalls.POSTRequest(endpointURI, createBookingPayload);

        String strResponse = TestUtils.getJSONResponseString(response);
        JsonPath jsonRes = TestUtils.jSONParser(strResponse);

        String bookingID = jsonRes.getString("bookingid");
        int statusCode = response.getStatusCode();

        log.info("Created booking id is " + bookingID);
        log.info("Returned status code is " + statusCode);

        Assertions.verifyStatusCode(response, 200);
        Assertions.verifyEqualBookingName(response, "Jim");
        Assertions.verifyEqualBookingLastName(response, "Brown");
        Assertions.verifyEqualBookingTotalPrice(response, 111);
        Assertions.verifyEqualBookingDepositPaid(response, true);
        Assertions.verifyEqualBookingCheckin(response, "2018-01-01");
        Assertions.verifyEqualBookingCheckout(response, "2019-01-01");
        Assertions.verifyEqualBookingAdditionalNeeds(response, "Breakfast");
    }

}
