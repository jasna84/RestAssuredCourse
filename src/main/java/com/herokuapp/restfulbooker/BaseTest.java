package main.java.com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp() {

        spec = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").build();

    }

    protected Response createBooking() {

        JSONObject body = new JSONObject();
        body.put("firstname", "Jasna");
        body.put("lastname", "Mrs");
        body.put("totalprice", 666);
        body.put("depositpaid", false);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-04-30");
        bookingdates.put("checkout", "2021-05-30");

        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "goo");

        Response response = RestAssured.given(spec).contentType(ContentType.JSON).body(body.toString()).
                post("/booking");

        return response;

    }

}
