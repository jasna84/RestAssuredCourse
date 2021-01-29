//package test.java.deleteTests;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import main.java.base.BaseTest;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class DeleteBooking extends BaseTest {
//
//    String bookingId;
//    Response response;
//
//    private static final Logger log = LogManager.getLogger(DeleteBooking.class.getName());
//
//    @BeforeMethod
//    public void setUp() throws IOException {
//        bookingId = createBooking();
//    }
//
//    @Test
//    public void deleteBookingTest() {
//
//        Response responseDelete = RestAssured.given(spec).auth().preemptive().
//                basic("admin", "password123").
//                delete("/booking/" + bookingid);
//
//        Assert.assertEquals(responseDelete.getStatusCode(), 201,
//                "Code should be 201 but it isn't ");
//
//        Response responseGet = RestAssured.get("https://restful-booker.herokuapp.com/booking/"
//                + bookingid);
//
//        Assert.assertEquals(responseGet.getBody().asString(),
//                "Not Found", "Body should be NOT FOUND but it isn't");
//    }
//}

