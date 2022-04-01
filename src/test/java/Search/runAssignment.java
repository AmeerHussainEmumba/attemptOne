package Search;

import Applications.AfterLife.Pages.castPage;
import Applications.AfterLife.Pages.imdbPage;
import Applications.Herokuapp.Pages.loginPage;
import Applications.AfterLife.Pages.searchedPage;
import Applications.Herokuapp.Pages.createFlyerPage;
import Applications.Herokuapp.Pages.signupPage;
import Base.BaseTest;
import RestAssured.restAssuredTest;
import Utility.dataProvider;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;

import static Applications.Herokuapp.Targets.forSignUpAndInPages.bodyOfPage;


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
        loginPage loginPageObj= herokuBasePage.setUpHerokuApp();
        signupPage signupPageObj=loginPageObj.signUp();
        createFlyerPage createFlyerObj=signupPageObj.singUpAndIn();
        herokuBasePage =createFlyerObj.createFlyer();
        String Final= herokuBasePage.screenshot();
        System.out.println(Final);
    }

    @Test(dataProvider = "LoginTestData", dataProviderClass = dataProvider.class)
    public void testLogins(String email, String password) throws InterruptedException {
        loginPage loginPageObj= herokuBasePage.setUpHerokuApp();
        loginPageObj.loggingIn(email,password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyOfPage));
    }

    @Test
    public void API() throws IOException {
        restAssuredTest test=new restAssuredTest();
        test.getResponce();
        test.postFirstResponce();
        test.postSecondResponce();
    }
}
