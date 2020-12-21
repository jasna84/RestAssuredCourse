package test.java.com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.java.com.herokuapp.restfulbooker.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetBookingTests extends BaseTest {

    @Test
    public void getBookingTest() {

        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        int bookingid = responseCreate.jsonPath().getInt("bookingid");

        spec.pathParam("bookingid", bookingid);

        Response response = RestAssured.given(spec).get("booking/{bookingid}");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200 but it is not");

        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = response.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Jasna",
                "First name in response is not expected");

        String actualLastName = response.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName, "Mrs",
                "Last name in response is not expected");

        int actualTotalPrice = response.jsonPath().getInt("totalprice");
        softAssert.assertEquals(actualTotalPrice, 666,
                "Total price in response is not expected");

        boolean actualDepositPaid = response.jsonPath().getBoolean("depositpaid");
        softAssert.assertEquals(actualDepositPaid, false,
                "Deposit paid value in response is not expected");

        String actualCheckin = response.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2021-04-30",
                "Check in in response is not expected");

        String actualCheckout = response.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2021-05-30",
                "Check out in response is not expected");

        String actualNeeds = response.jsonPath().getString("additionalneeds");
        softAssert.assertEquals(actualNeeds, "Breakfast",
                "Additional needs in response is not expected");

        softAssert.assertAll();
    }
}
