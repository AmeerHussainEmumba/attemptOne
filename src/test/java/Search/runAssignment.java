package Search;

import Applications.Google.castPage;
import Applications.Google.imdbPage;
import Applications.Herokuapp.loginPage;
import Applications.Google.searchedPage;
import Applications.Herokuapp.herokuBasePage;
import Applications.Herokuapp.createFlyerPage;
import Applications.Herokuapp.signupPage;
import Base.BaseTest;
import RestAssured.restAssuredTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class runAssignment extends BaseTest{

    @Test
    public void Search() throws IOException, InterruptedException {
        searchedPage searchedpageobj= Homepage.searching();
       imdbPage IMDBobj= searchedpageobj.scanResults();
       castPage castPageobj = IMDBobj.resultpage();
       herokuBasePage HerokuAppobj=castPageobj.closingImdb();
       loginPage loginPageObj=HerokuAppobj.click();
       signupPage signupPageObj=loginPageObj.signup();
       createFlyerPage createFlyerObj=signupPageObj.singUpandIn();
       HerokuAppobj=createFlyerObj.createflyer();
       String Final=HerokuAppobj.Screenshot();
       System.out.println(Final);
    }

    @Test
    public void API() throws IOException {
        restAssuredTest test=new restAssuredTest();
        test.getResponce();
        test.postResponce1();
        test.postResponce2();
    }
}
