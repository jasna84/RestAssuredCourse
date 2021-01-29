/*
package test.java.putTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.base.BaseTest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PartialUpdateBookingTests extends BaseTest {

    @Test
    public void partialUpdateBookingTest() {

        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        int bookingid = responseCreate.jsonPath().getInt("bookingid");

        JSONObject body = new JSONObject();
        body.put("firstname", "Gospodjetina");
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "1666-04-30");
        bookingdates.put("checkout", "1666-05-30");
        body.put("bookingdates", bookingdates);

        Response responseUpdate = RestAssured.given(spec).auth().preemptive().
                basic("admin", "password123").
                contentType(ContentType.JSON).body(body.toString()).
                patch("/booking/" + bookingid);

        responseUpdate.prettyPrint();

        Assert.assertEquals(responseUpdate.getStatusCode(), 200,
                "Code should be 200 but it isn't ");

        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = responseUpdate.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Gospodjetina",
                "First name in response is not expected");

        String actualLastName = responseUpdate.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName, "Mrs",
                "Last name in response is not expected");

        int actualTotalPrice = responseUpdate.jsonPath().getInt("totalprice");
        softAssert.assertEquals(actualTotalPrice, 666,
                "Total price in response is not expected");

        boolean actualDepositPaid = responseUpdate.jsonPath().getBoolean("depositpaid");
        softAssert.assertEquals(actualDepositPaid, false,
                "Deposit paid value in response is not expected");

        String actualCheckin = responseUpdate.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "1666-04-30",
                "Check in in response is not expected");

        String actualCheckout = responseUpdate.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "1666-05-30",
                "Check out in response is not expected");

        String actualNeeds = responseUpdate.jsonPath().getString("additionalneeds");
        softAssert.assertEquals(actualNeeds, "Breakfast",
                "Additional needs in response is not expected");

        softAssert.assertAll();
    }
}
*/
