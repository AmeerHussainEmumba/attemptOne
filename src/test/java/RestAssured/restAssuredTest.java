package RestAssured;

import Utility.readExcelFile;
import io.restassured.RestAssured;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class restAssuredTest {
    readExcelFile reading = new readExcelFile();

    public void getResponce() throws IOException {

        String APIURLget = reading.Retrievedata(1, 2, 0);
        System.out.println(APIURLget);
        //Response responseGet = RestAssured.get(APIURLget);
        given().get(APIURLget).then().statusCode(201);
    }
    public void postResponce1() throws IOException {
        String APIURLpost = reading.Retrievedata(1, 3, 0);
        System.out.println(APIURLpost);
        String Body = reading.Retrievedata(1, 3, 2);
        System.out.println(Body);
        RestAssured.given().body(Body).post().then().statusCode(200);
    }
    public void postResponce2() throws IOException {
            String APIURLpost = reading.Retrievedata(1, 4, 0);
            System.out.println(APIURLpost);
            String Body = reading.Retrievedata(1, 4, 2);
            System.out.println(Body);
            RestAssured.given().body(Body).post().then().statusCode(200);
        }
    }
