package test.java.authTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import main.java.base.BaseTest;
import main.java.base.RESTCalls;
import main.java.utils.PayloadConverter;
import main.java.utils.TestUtils;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateToken extends BaseTest {

    private static Logger log = LogManager.getLogger(CreateToken.class.getName());

    @Test
    public void verifyCreateToken() throws IOException {

        Response response;
        log.info("Starting test: Create Token" );

        String authPayload = PayloadConverter.generateString("Authentication.json");
        String endpointURI = URL.getEndpoint("/auth ");

        response = RESTCalls.POSTRequest(endpointURI,authPayload);

        String strResponse = TestUtils.getJSONResponseString(response);
        JsonPath jsonRes = TestUtils.jSONParser(strResponse);

        String token = jsonRes.getString("token");
        System.out.println(token);
        log.info("Token value is: " + token);

    }
}
