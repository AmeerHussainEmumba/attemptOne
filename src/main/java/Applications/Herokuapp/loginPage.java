package Applications.Herokuapp;

import Applications.Herokuapp.signupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Targets.targets.notAUserYetButton;

public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver=driver;
    }
    public signupPage signup() throws InterruptedException {   WebElement Login= driver.findElement(By.xpath("//button[contains(.,'Login')]"));
        Login.click();
        Thread.sleep(3000);
        driver.findElement(notAUserYetButton).click();
        Thread.sleep(2000);
        return new signupPage(driver);
    }
}
