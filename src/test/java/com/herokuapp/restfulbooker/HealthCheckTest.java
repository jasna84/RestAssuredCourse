package test.java.com.herokuapp.restfulbooker;

import main.java.com.herokuapp.restfulbooker.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HealthCheckTest extends BaseTest {

    @Test
    public void healthCheckTest() {

        given().
                spec(spec).
        when().
            get("/ping").
        then().
            assertThat().
            statusCode(201);
    }
}
