package test.java.com.herokuapp.restfulbooker;

import io.restassured.response.Response;
import main.java.com.herokuapp.restfulbooker.BaseTest;

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
}
