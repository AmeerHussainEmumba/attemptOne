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


    public signupPage signup() throws InterruptedException {
        driver.findElement(LoginButton).click();
        driver.findElement(notAUserYetButton).click();
        Thread.sleep(2000);
        return new signupPage(driver);
    }

    public void loggingIn (String email, String Password) throws InterruptedException {
        System.out.println("is here");
        driver.findElement(LoginButton).click();
        System.out.println("actually here");
        driver.findElement(emailSignedIn).sendKeys(email);
        driver.findElement(passwordSignedIn).sendKeys(Password);
        Thread.sleep(2000);


        try {driver.findElement(SignIn).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[2]")));
        driver.findElement(Logout).click();}
        catch (Exception e)
        {

        }

    }
}
