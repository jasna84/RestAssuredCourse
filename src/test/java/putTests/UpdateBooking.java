package test.java.putTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import main.java.base.Assertions;
import main.java.base.BaseTest;
import main.java.base.RESTCalls;
import main.java.utils.PayloadConverter;
import main.java.utils.TestUtils;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.java.getTests.GetBooking;

import java.io.IOException;


public class UpdateBooking extends BaseTest {

    String bookingId;

    private static final Logger log = LogManager.getLogger(UpdateBooking.class.getName());

    @BeforeMethod
    public void setUp() throws IOException {
        bookingId = createBooking();
    }

    @Test
    public void updateBooking() throws IOException {

        Response response;
        Response responseGetUpdatedResource;
        log.info("Starting test: Update Booking");

        String updateBookingPayload = PayloadConverter.generateString("UpdateBooking.json");
        String endpointURI = URL.getEndpoint("/booking/" + bookingId);

        response = RESTCalls.PUTRequestWithAuth(endpointURI, updateBookingPayload);

        Assertions.verifyStatusCode(response, 200);

        responseGetUpdatedResource = RESTCalls.GETRequest(endpointURI);

        Assertions.verifyStatusCode(responseGetUpdatedResource, 200);
        Assertions.verifyEqualName(responseGetUpdatedResource, "Jack");
        Assertions.verifyEqualLastName(responseGetUpdatedResource, "Smith");
        Assertions.verifyEqualTotalPrice(responseGetUpdatedResource, 123);
        Assertions.verifyEqualDepositPaid(responseGetUpdatedResource, false);
        Assertions.verifyEqualCheckin(responseGetUpdatedResource, "2018-02-01");
        Assertions.verifyEqualCheckout(responseGetUpdatedResource, "2019-02-01");
        Assertions.verifyEqualAdditionalNeeds(responseGetUpdatedResource, "Dinner");

    }
}
