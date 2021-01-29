/*
package test.java.getTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.java.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetBookingIdsTests extends BaseTest {

    @Test
    public void getBookingIdsWithoutFilterTest() {

       Response response = RestAssured.given(spec).get("/booking");
       response.prettyPrint();
       Assert.assertEquals(response.getStatusCode(), 200,
               "Status code should be 200 but it is not");
       List<Integer> bookingIds = response.jsonPath().getList("bookingid");
       Assert.assertFalse(bookingIds.isEmpty(), "List of ids is empty but it should not be");
    }

    @Test
    public void getBookingIdsWithFilterTest() {

        spec.queryParam("firstname", "Jasna");
        spec.queryParam("lastname", "Mrs");
        Response response = RestAssured.given(spec).get("/booking");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code should be 200 but it is not");
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");
        Assert.assertFalse(bookingIds.isEmpty(), "List of ids is empty but it should not be");
    }



}
*/