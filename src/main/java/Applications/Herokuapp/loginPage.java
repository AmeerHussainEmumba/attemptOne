package Applications.Herokuapp;

import Applications.Herokuapp.signupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Targets.targets.*;
import static Targets.targets.SignIn;

public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver=driver;
    }


    public signupPage signUp() throws InterruptedException {
        driver.findElement(LoginButton).click();
        driver.findElement(notAUserYetButton).click();
        Thread.sleep(2000);
        return new signupPage(driver);
    }

    public void loggingIn (String Email, String Password) throws InterruptedException {
        driver.findElement(LoginButton).click();
        driver.findElement(email).sendKeys(Email);
        driver.findElement(password).sendKeys(Password);
        Thread.sleep(2000);

        driver.findElement(SignIn).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[2]")));
        driver.findElement(Logout).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[2]")));
    }
}
