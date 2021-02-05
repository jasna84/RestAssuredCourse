package main.java.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {

    private static Logger log = LogManager.getLogger(TestUtils.class.getName());

    public static String getJSONResponseString(Response response) {
        log.info("Converting json response to string");
        String stringResponse = response.getBody().asString();
        System.out.println(stringResponse);
        log.debug(stringResponse);
        return stringResponse;
    }

    public static JsonPath jSONParser(String response) {
        log.info("Parsing response to json");
        JsonPath jsonResponse = new JsonPath(response);
        log.debug(jsonResponse);
        return jsonResponse;
    }

    public static XmlPath xmlParser(String response) {
        log.info("Parsing response response to xml");
        XmlPath xmlResponse = new XmlPath(response);
        log.debug(xmlResponse);
        return xmlResponse;
    }

    public static int getStatusCode(Response response) {
        log.info("Getting status code");
        int statusCode = response.getStatusCode();
        log.debug(statusCode);
        return statusCode;
    }

    public static String getStatusMessage(Response response) {
        log.info("Getting status message");
        String statusMessage = response.getStatusLine();
        log.debug(statusMessage);
        return statusMessage;
    }

    public static String getBookingId(Response response) {
        log.info("Getting booking id");
        String bookingId = response.jsonPath().getString("bookingid");
        log.debug(bookingId);
        return bookingId;
    }

    public static String getNotFoundMessage(Response response) {
        log.info("Getting not found message");
        String message = response.getBody().asString();
        log.debug(message);
        return message;
    }


    public static String getBookingName(Response response) {
        log.info("Getting booking name");
        String name = response.jsonPath().getString("booking.firstname");
        log.debug(name);
        return name;
    }

    public static String getBookingLastName(Response response) {
        log.info("Getting booking last name");
        String lastName = response.jsonPath().getString("booking.lastname");
        log.debug(lastName);
        return lastName;
    }

    public static int getBookingTotalPrice(Response response) {
        log.info("Getting booking total price");
        int totalPrice = response.jsonPath().getInt("booking.totalprice");
        log.debug(totalPrice);
        return totalPrice;
    }

    public static boolean getBookingDepositPaid(Response response) {
        log.info("Getting deposit paid value");
        boolean depositPaid = response.jsonPath().getBoolean("booking.depositpaid");
        log.debug(depositPaid);
        return depositPaid;
    }

    public static String getBookingCheckin(Response response) {
        log.info("Getting checkin date");
        String checkin = response.jsonPath().getString("booking.bookingdates.checkin");
        log.debug(checkin);
        return checkin;
    }

    public static String getBookingCheckout(Response response) {
        log.info("Getting checkout date");
        String checkout = response.jsonPath().getString("booking.bookingdates.checkout");
        log.debug(checkout);
        return checkout;
    }

    public static String getBookingAdditionalNeeds(Response response) {
        log.info("Getting additional needs value");
        String additionalNeeds = response.jsonPath().getString("booking.additionalneeds");
        log.debug(additionalNeeds);
        return additionalNeeds;
    }


    public static String getName(Response response) {
        log.info("Getting name");
        String name = response.jsonPath().getString("firstname");
        log.debug(name);
        return name;
    }

    public static String getLastName(Response response) {
        log.info("Getting last name");
        String lastName = response.jsonPath().getString("lastname");
        log.debug(lastName);
        return lastName;
    }

    public static int getTotalPrice(Response response) {
        log.info("Getting total price");
        int totalPrice = response.jsonPath().getInt("totalprice");
        log.debug(totalPrice);
        return totalPrice;
    }

    public static boolean getDepositPaid(Response response) {
        log.info("Getting paid value");
        boolean depositPaid = response.jsonPath().getBoolean("depositpaid");
        log.debug(depositPaid);
        return depositPaid;
    }

    public static String getCheckin(Response response) {
        log.info("Getting checkin date");
        String checkin = response.jsonPath().getString("bookingdates.checkin");
        log.debug(checkin);
        return checkin;
    }

    public static String getCheckout(Response response) {
        log.info("Getting checkout date");
        String checkout = response.jsonPath().getString("bookingdates.checkout");
        log.debug(checkout);
        return checkout;
    }

    public static String getAdditionalNeeds(Response response) {
        log.info("Getting additional needs value");
        String additionalNeeds = response.jsonPath().getString("additionalneeds");
        log.debug(additionalNeeds);
        return additionalNeeds;
    }
}
