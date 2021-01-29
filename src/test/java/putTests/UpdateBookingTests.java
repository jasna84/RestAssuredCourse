/*package test.java.putTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.base.BaseTest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class UpdateBookingTests extends BaseTest {

    @Test
    public void updateBookingTest() {

        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        int bookingid = responseCreate.jsonPath().getInt("bookingid");

        JSONObject body = new JSONObject();
        body.put("firstname", "Jasmina");
        body.put("lastname", "Muuurs");
        body.put("totalprice", 777);
        body.put("depositpaid", true);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2020-04-30");
        bookingdates.put("checkout", "2020-05-30");

        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "Diner");

        Response responseUpdate = RestAssured.given(spec).auth().preemptive().
                basic("admin", "password123").
                contentType(ContentType.JSON).body(body.toString()).
                put("/booking/" + bookingid);

        responseUpdate.prettyPrint();

        Assert.assertEquals(responseUpdate.getStatusCode(), 200,
                "Code should be 200 but it isn't ");

        SoftAssert softAssert = new SoftAssert();

        String actualFirstName = responseUpdate.jsonPath().getString("firstname");
        softAssert.assertEquals(actualFirstName, "Jasmina",
                "First name in response is not expected");

        String actualLastName = responseUpdate.jsonPath().getString("lastname");
        softAssert.assertEquals(actualLastName, "Muuurs",
                "Last name in response is not expected");

        int actualTotalPrice = responseUpdate.jsonPath().getInt("totalprice");
        softAssert.assertEquals(actualTotalPrice, 777,
                "Total price in response is not expected");

        boolean actualDepositPaid = responseUpdate.jsonPath().getBoolean("depositpaid");
        softAssert.assertEquals(actualDepositPaid, true,
                "Deposit paid value in response is not expected");

        String actualCheckin = responseUpdate.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2020-04-30",
                "Check in in response is not expected");

        String actualCheckout = responseUpdate.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2020-05-30",
                "Check out in response is not expected");

        String actualNeeds = responseUpdate.jsonPath().getString("additionalneeds");
        softAssert.assertEquals(actualNeeds, "Diner",
                "Additional needs in response is not expected");

        softAssert.assertAll();
    }
}*/
