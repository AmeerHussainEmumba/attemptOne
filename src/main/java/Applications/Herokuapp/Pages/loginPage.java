package Applications.Herokuapp.Pages;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Applications.Herokuapp.Targets.forSignUpAndInPages.*;


public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver=driver;
    }


    public signupPage signUp() throws InterruptedException {
        driver.findElement(loginButton).click();
        driver.findElement(notAUserYetButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingOfSignUpPage));
        return new signupPage(driver);
    }

    public void loggingIn (String Email, String Password) throws InterruptedException {
        driver.findElement(loginButton).click();
        driver.findElement(email).sendKeys(Email);
        driver.findElement(password).sendKeys(Password);


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SignUpOrIn));
        driver.findElement(SignUpOrIn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyOfPage));
        driver.findElement(Logout).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyOfPage));
    }
}
