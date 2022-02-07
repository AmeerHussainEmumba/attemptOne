package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class imdb {
    private WebDriver driver;
    public imdb(WebDriver driver)
    {
        this.driver=driver;
    }

    public castPage resultpage() throws InterruptedException {    Thread.sleep(5000);
        WebElement castPage = driver.findElement(By.xpath("//a[contains (.,'All cast & crew')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", castPage);
        castPage.click();
        Thread.sleep(5000);
        return new castPage(driver);
    }
}
