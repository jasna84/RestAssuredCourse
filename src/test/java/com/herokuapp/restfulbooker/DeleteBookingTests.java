package test.java.com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.com.herokuapp.restfulbooker.BaseTest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class DeleteBookingTests extends BaseTest {

    @Test
    public void deleteBookingTest() {

        Response responseCreate = createBooking();
        responseCreate.prettyPrint();

        int bookingid = responseCreate.jsonPath().getInt("bookingid");

        Response responseDelete = RestAssured.given(spec).auth().preemptive().
                basic("admin", "password123").
                delete("/booking/" + bookingid);

        responseDelete.prettyPrint();

        Assert.assertEquals(responseDelete.getStatusCode(), 201,
                "Code should be 201 but it isn't ");

        Response responseGet = RestAssured.get("https://restful-booker.herokuapp.com/booking/"
                + bookingid);
        responseGet.prettyPrint();

        Assert.assertEquals(responseGet.getBody().asString(),
                "Not Found", "Body should be NOT FOUND but it isn't");
    }
}
