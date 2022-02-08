package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver=driver;
    }
    public signupPage signup() throws InterruptedException {   WebElement Login= driver.findElement(By.xpath("//button[contains(.,'Login')]"));
        Login.click();
        Thread.sleep(3000);
        WebElement notAUserYetButton =driver.findElement(By.xpath("//a[contains(., 'a')]"));
        notAUserYetButton.click();
        Thread.sleep(2000);
        return new signupPage(driver);
    }
}
