package Applications.AfterLife.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static Applications.AfterLife.Targets.forImdbPage.CastsPage;


public class imdbPage {
    private WebDriver driver;
    public imdbPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public castPage resultPage() throws InterruptedException {
        Thread.sleep(5000);
        /*
        This line of code scrolls till the Clickable text "Cast Page" is in sight. It uses javascript to run this functionality
        */
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CastsPage));
        driver.findElement(CastsPage).click();
        return new castPage(driver);
    }
}
