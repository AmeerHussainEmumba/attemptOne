package Applications.AfterLife.Pages;

import Applications.AfterLife.Steps.getFullCast;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class homePage {
    private WebDriver driver;
   public getFullCast Getfullcast=new getFullCast();

    public homePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public searchedPage searching() throws IOException {
        driver=Getfullcast.search_movie(driver);
        return new searchedPage(driver);
    }
}
