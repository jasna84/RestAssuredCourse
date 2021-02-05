package test.java.getTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import main.java.base.Assertions;
import main.java.base.BaseTest;
import main.java.base.RESTCalls;
import main.java.utils.TestUtils;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetBooking extends BaseTest {

    String bookingId;

    private static final Logger log = LogManager.getLogger(GetBooking.class.getName());

    @BeforeMethod
    public void setUp() throws IOException {
        bookingId = createBooking();
    }

    @Test
    public void getBooking() {

        Response response;
        log.info("Starting test: Get Booking");

        String endpointURI = URL.getEndpoint("/booking/" + bookingId);

        response = RESTCalls.GETRequest(endpointURI);

        String strResponse = TestUtils.getJSONResponseString(response);
        JsonPath jsonRes = TestUtils.jSONParser(strResponse);

        String bookingID = jsonRes.getString("bookingid");
        int statusCode = response.getStatusCode();

        log.info("Returned booking id is " + bookingID);
        log.info("Returned status code is " + statusCode);

        Assertions.verifyStatusCode(response, 200);
        Assertions.verifyEqualName(response, "Jim");
        Assertions.verifyEqualLastName(response, "Brown");
        Assertions.verifyEqualTotalPrice(response, 111);
        Assertions.verifyEqualDepositPaid(response, true);
        Assertions.verifyEqualCheckin(response, "2018-01-01");
        Assertions.verifyEqualCheckout(response, "2019-01-01");
        Assertions.verifyEqualAdditionalNeeds(response, "Breakfast");
    }

}
