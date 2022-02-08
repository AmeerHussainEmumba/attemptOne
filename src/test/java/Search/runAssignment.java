package Search;

import Base.BaseTest;
import Pages.*;
import RestAssured.restAssuredTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class runAssignment extends BaseTest{

    @Test
    public void Search() throws IOException, InterruptedException {
        searchedPage searchedpageobj= Homepage.searching();
       imdb IMDBobj= searchedpageobj.scanResults();
       castPage castPageobj = IMDBobj.resultpage();
       HerokuApp HerokuAppobj=castPageobj.closingImdb();
       loginPage loginPageObj=HerokuAppobj.click();
       signupPage signupPageObj=loginPageObj.signup();
       createFlyer createFlyerObj=signupPageObj.singUpandIn();
       HerokuAppobj=createFlyerObj.createflyer();
       String Final=HerokuAppobj.Screenshot();
       System.out.println(Final);
    }

    @Test
    public void API() throws IOException {
        restAssuredTest test=new restAssuredTest();
        test.getResponce();
        test.postResponce();
    }
}
