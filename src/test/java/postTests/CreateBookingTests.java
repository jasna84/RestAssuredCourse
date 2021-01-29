/*
package test.java.postTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.base.BaseTest;

import main.java.Booking;
import main.java.BookingDates;
import main.java.BookingId;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CreateBookingTests extends BaseTest {

    @Test
    public void createBookingTest() {

        Response response = createBooking();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Code should be 200 but it isn't ");

        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "Jasna",
                "First name in response is not expected");

        String actualLastName = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastName, "Mrs",
                "Last name in response is not expected");

        int actualTotalPrice = response.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(actualTotalPrice, 666,
                "Total price in response is not expected");

        boolean actualDepositPaid = response.jsonPath().getBoolean("booking.depositpaid");
        softAssert.assertEquals(actualDepositPaid, false,
                "Deposit paid value in response is not expected");

        String actualCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2021-04-30",
                "Check in in response is not expected");

        String actualCheckout = response.jsonPath().getString("booking.bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2021-05-30",
                "Check out in response is not expected");

        String actualNeeds = response.jsonPath().getString("booking.additionalneeds");
        softAssert.assertEquals(actualNeeds, "Breakfast",
                "Additional needs in response is not expected");

        softAssert.assertAll();
    }

    @Test
    public void createBookingWithPOJOTest() {

        BookingDates bookingdates = new BookingDates("2021-04-30", "2021-05-30");
        Booking booking = new Booking("Jasna", "Mrs", 666, false,
                bookingdates, "Breakfast");

        Response response = RestAssured.given(spec).contentType(ContentType.JSON).body(booking).
                post("/booking");
        response.prettyPrint();

        BookingId bookingid = response.as(BookingId.class);

        Assert.assertEquals(response.getStatusCode(), 200,
                "Code should be 200 but it isn't ");

        System.out.println("Request booking: " + booking.toString());
        System.out.println("Request booking: " + bookingid.getBooking().toString());

        Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());

        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "Jasna",
                "First name in response is not expected");

        String actualLastName = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastName, "Mrs",
                "Last name in response is not expected");

        int actualTotalPrice = response.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(actualTotalPrice, 666,
                "Total price in response is not expected");

        boolean actualDepositPaid = response.jsonPath().getBoolean("booking.depositpaid");
        softAssert.assertEquals(actualDepositPaid, false,
                "Deposit paid value in response is not expected");

        String actualCheckin = response.jsonPath().getString("booking.bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2021-04-30",
                "Check in in response is not expected");

        String actualCheckout = response.jsonPath().getString("booking.bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2021-05-30",
                "Check out in response is not expected");

        String actualNeeds = response.jsonPath().getString("booking.additionalneeds");
        softAssert.assertEquals(actualNeeds, "Breakfast",
                "Additional needs in response is not expected");

        softAssert.assertAll();
    }
}
*/
