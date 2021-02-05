package test.java.pingTests;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import main.java.base.Assertions;
import main.java.base.BaseTest;
import main.java.base.RESTCalls;
import main.java.utils.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class HealthCheck extends BaseTest {

    private static Logger log = LogManager.getLogger(HealthCheck.class.getName());

    @Test
    public void healthCheck() {

        Response response;
        log.info("Starting test: Health Check" );

        String endpointURI = URL.getEndpoint("/ping");

        response = RESTCalls.GETRequest(endpointURI);

        Assertions.verifyStatusCode(response, 201);

    }

    @Test
    public void getHeadersAndCookies() {

        Response response;
        log.info("Starting test: Get Headers and Cookies" );

        String endpointURI = URL.getEndpoint("/ping");
        response = RESTCalls.GETRequest(endpointURI);

        Headers headers = response.getHeaders();
        System.out.println("Headers: " + headers);

        Cookies cookies = response.getDetailedCookies();
        System.out.println("Cookies: " + cookies);

        String serverHeader = response.getHeader("Server");
        System.out.println("Server: " + serverHeader);

    }

}
