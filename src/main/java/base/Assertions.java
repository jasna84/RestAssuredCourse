package main.java.base;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import main.java.utils.TestUtils;

public class Assertions {

    private static Logger log = LogManager.getLogger(Assertions.class.getName());

    public static void verifyTrue(boolean flag) {
        Assert.assertTrue(flag);
    }

    public static void verifyFalse(boolean flag) {
        Assert.assertFalse(flag);
    }

    public static void verifyStatusCode(Response response, int status) {
        Assert.assertEquals(TestUtils.getStatusCode(response), status);
    }

    public static void verifyStatusMessage(Response response, String message) {
        Assert.assertEquals(TestUtils.getStatusMessage(response), message);
    }

    public static void verifyNotFound(Response response, String message) {
        Assert.assertEquals(TestUtils.getNotFoundMessage(response), message);
    }

    public static void verifyEqualName(Response response, String firstName) {
        Assert.assertEquals(TestUtils.getName(response), firstName);
    }

    public static void verifyEqualLastName(Response response, String lastName) {
        Assert.assertEquals(TestUtils.getLastName(response), lastName);
    }

    public static void verifyEqualTotalPrice(Response response, int totalPrice) {
        Assert.assertEquals(TestUtils.getTotalPrice(response), totalPrice);
    }

    public static void verifyEqualDepositPaid(Response response, boolean depositPaid) {
        Assert.assertEquals(TestUtils.getDepositPaid(response), depositPaid);
    }

    public static void verifyEqualCheckin(Response response, String checkin) {
        Assert.assertEquals(TestUtils.getCheckin(response), checkin);
    }

    public static void verifyEqualCheckout(Response response, String checkout) {
        Assert.assertEquals(TestUtils.getCheckout(response), checkout);
    }

    public static void verifyEqualAdditionalNeeds(Response response, String additionalNeeds) {
        Assert.assertEquals(TestUtils.getAdditionalNeeds(response), additionalNeeds);
    }

    public static void verifyEqualBookingId(Response response, String bookingId) {
        Assert.assertEquals(TestUtils.getBookingId(response), bookingId);
    }

    public static void verifyEqualBookingName(Response response, String firstName) {
        Assert.assertEquals(TestUtils.getBookingName(response), firstName);
    }

    public static void verifyEqualBookingLastName(Response response, String lastName) {
        Assert.assertEquals(TestUtils.getBookingLastName(response), lastName);
    }

    public static void verifyEqualBookingTotalPrice(Response response, int totalPrice) {
        Assert.assertEquals(TestUtils.getBookingTotalPrice(response), totalPrice);
    }

    public static void verifyEqualBookingDepositPaid(Response response, boolean depositPaid) {
        Assert.assertEquals(TestUtils.getBookingDepositPaid(response), depositPaid);
    }

    public static void verifyEqualBookingCheckin(Response response, String checkin) {
        Assert.assertEquals(TestUtils.getBookingCheckin(response), checkin);
    }

    public static void verifyEqualBookingCheckout(Response response, String checkout) {
        Assert.assertEquals(TestUtils.getBookingCheckout(response), checkout);
    }

    public static void verifyEqualBookingAdditionalNeeds(Response response, String additionalNeeds) {
        Assert.assertEquals(TestUtils.getBookingAdditionalNeeds(response), additionalNeeds);
    }

}
