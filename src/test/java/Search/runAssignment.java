package Search;

import Applications.Google.castPage;
import Applications.Google.imdbPage;
import Applications.Herokuapp.loginPage;
import Applications.Google.searchedPage;
import Applications.Herokuapp.createFlyerPage;
import Applications.Herokuapp.signupPage;
import Base.BaseTest;
import RestAssured.restAssuredTest;
import Utility.dataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class runAssignment extends BaseTest{

    @Test
    public void afterLifeImdbFlow() throws IOException, InterruptedException {
        searchedPage searchedPageObj= Homepage.searching();
       imdbPage imdbPageObj= searchedPageObj.scanResults();
       castPage castPageObj = imdbPageObj.resultPage();
        System.out.println(castPageObj.closingImdb());
    }
    @Test
    public void herokuAppFlow() throws IOException, InterruptedException {
        loginPage loginPageObj= herokuBasePage.click();
        signupPage signupPageObj=loginPageObj.signUp();
        createFlyerPage createFlyerObj=signupPageObj.singUpandIn();
        herokuBasePage =createFlyerObj.createFlyer();
        String Final= herokuBasePage.screenshot();
        System.out.println(Final);
    }

    @Test(dataProvider = "LoginTestData", dataProviderClass = dataProvider.class)
    public void testLogins(String email, String password) throws InterruptedException, IOException {
        loginPage loginPageObj= herokuBasePage.click();
        loginPageObj.loggingIn(email,password);
        Thread.sleep(2000);
    }

    @Test
    public void API() throws IOException {
        restAssuredTest test=new restAssuredTest();
        test.getResponce();
        test.postFirstResponce();
        test.postSecondResponce();
    }
}
