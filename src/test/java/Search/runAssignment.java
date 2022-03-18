package Search;

import Applications.Google.castPage;
import Applications.Google.imdbPage;
import Applications.Herokuapp.loginPage;
import Applications.Google.searchedPage;
import Applications.Herokuapp.createFlyerPage;
import Applications.Herokuapp.signupPage;
import Base.BaseTest;
import RestAssured.restAssuredTest;
import Utility.TestNgData;
import Utility.dataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class runAssignment extends BaseTest{

    @Test
    public void Movie_Search() throws IOException, InterruptedException {
        searchedPage searchedpageobj= Homepage.searching();
       imdbPage IMDBobj= searchedpageobj.scanResults();
       castPage castPageobj = IMDBobj.resultpage();
        System.out.println(castPageobj.closingImdb());
    }
    @Test
    public void Herokuapp() throws IOException, InterruptedException {
        //herokuBasePage HerokuAppobj=castPageobj.closingImdb();
        loginPage loginPageObj=HerokuBasePage.click();
        signupPage signupPageObj=loginPageObj.signup();
        createFlyerPage createFlyerObj=signupPageObj.singUpandIn();
        HerokuBasePage=createFlyerObj.createflyer();
        String Final=HerokuBasePage.Screenshot();
        System.out.println(Final);
    }

    @Test(dataProvider = "LoginTestData", dataProviderClass = dataProvider.class)
    public void testLogins(String email, String password) throws InterruptedException, IOException {
        loginPage loginPageObj=HerokuBasePage.click();
        loginPageObj.loggingIn(email,password);
        Thread.sleep(2000);
    }

    @Test
    public void API() throws IOException {
        restAssuredTest test=new restAssuredTest();
        test.getResponce();
        test.postResponce1();
        test.postResponce2();
    }
}
