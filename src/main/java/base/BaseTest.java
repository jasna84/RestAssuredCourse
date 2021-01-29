package main.java.base;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import main.java.utils.PayloadConverter;
import main.java.utils.TestUtils;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseTest {

    private static Logger log = LogManager.getLogger(BaseTest.class.getName());

    @Test
    public String createBooking() throws IOException {

        Response response;
        log.info("Starting test: createBooking");

        String createBookingPayload = PayloadConverter.generateString("CreateBooking.json");
        String endpointURI = URL.getEndpoint("/booking");

        response = RESTCalls.POSTRequest(endpointURI, createBookingPayload);

        String strResponse = TestUtils.getJSONResponseString(response);
        JsonPath jsonRes = TestUtils.jSONParser(strResponse);

        String bookingID = jsonRes.getString("bookingid");
        log.info("Created booking id is " + bookingID);

        return bookingID;

    }
}
