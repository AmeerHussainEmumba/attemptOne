package RestAssured;

import Pages.ReadExcelFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class restAssuredTest {
    ReadExcelFile reading = new ReadExcelFile();
@Test
    /*public void getResponce() throws IOException {

        String APIURLget = reading.Retrievedata(1, 2, 0);
        System.out.println(APIURLget);
        //Response responseGet = RestAssured.get(APIURLget);
        given().get(APIURLget).then().statusCode(201);
    }*/
    public void postResponce() throws IOException {
        for (int i = 3; i <= 4; i++) {
            String APIURLpost = reading.Retrievedata(1, i, 0);
            System.out.println(APIURLpost);
            String Body = reading.Retrievedata(1, i, 2);
            RestAssured.given().body(Body).post().then().statusCode(200);
        }
    }
}