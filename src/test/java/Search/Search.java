package Search;

import Base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;
import Pages.searchedPage;
public class Search extends BaseTest{

    @Test
    public void Search() throws IOException, InterruptedException {
        searchedPage searchedpage= Homepage.searching();
       /*var imdb = searchedPage.scanResults();
       var castPage = imdb.resultpage();
       var HerokuApp=castPage.closingImdb();
       var loginPage=HerokuApp.click();
       var signupPage=loginPage.signup();
       var createFlyer=signupPage.singUpandIn();
       var HerokuAppNew=createFlyer.createflyer();
       var Final=createFlyer.createflyer();*/


    }
}
