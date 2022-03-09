package Applications.Google;

import Applications.Google.castPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Targets.targets.CastsPage;

public class imdbPage {
    private WebDriver driver;
    public imdbPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public castPage resultpage() throws InterruptedException {    Thread.sleep(5000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(CastsPage));
        driver.findElement(CastsPage).click();
        Thread.sleep(5000);
        return new castPage(driver);
    }
}
