package RestAssured;

import Utility.excelFileManipulation;
import io.restassured.RestAssured;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class restAssuredTest {
    excelFileManipulation reading = new excelFileManipulation();

    public void getResponce() throws IOException {

        String urlForGetCall = reading.retrieveData(1, 2, 0);
        System.out.println(urlForGetCall);
        given().get(urlForGetCall).then().statusCode(201);
    }
    public void postFirstResponce() throws IOException {
        String urlForFirstPostCall = reading.retrieveData(1, 3, 0);
        System.out.println(urlForFirstPostCall);
        String bodyOfFirstPostCall = reading.retrieveData(1, 3, 2);
        System.out.println(bodyOfFirstPostCall);
        RestAssured.given().body(bodyOfFirstPostCall).post().then().statusCode(200);
    }
    public void postSecondResponce() throws IOException {
            String urlForSecondPostCall = reading.retrieveData(1, 4, 0);
            System.out.println(urlForSecondPostCall);
            String bodyOfSecondPostCall = reading.retrieveData(1, 4, 2);
            System.out.println(bodyOfSecondPostCall);
            RestAssured.given().body(bodyOfSecondPostCall).post().then().statusCode(200);
        }
    }
