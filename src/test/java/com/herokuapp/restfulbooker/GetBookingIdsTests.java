package test.java.com.herokuapp.restfulbooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.java.com.herokuapp.restfulbooker.BaseTest;
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


}
