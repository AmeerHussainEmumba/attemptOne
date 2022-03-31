package Applications.Herokuapp.Pages;

import Utility.excelFileManipulation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static Applications.Herokuapp.Targets.forSignUpAndInPages.*;


public class signupPage {
    private WebDriver driver;
    public signupPage(WebDriver driver) {
        this.driver = driver;
    }
    public createFlyerPage singUpandIn() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        excelFileManipulation reading= new excelFileManipulation();

        String FirstName=reading.retrieveData(3,6,0);
        driver.findElement(first_name).sendKeys(FirstName);
        String LastName=reading.retrieveData(3,6,1);
        driver.findElement(last_name).sendKeys(LastName);
        String Email =reading.retrieveData(0,3,1);
        driver.findElement(email).sendKeys(Email);
        String Password=reading.retrieveData(0,4,1);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(confirm_password).sendKeys(Password);


        wait.until(ExpectedConditions.elementToBeClickable(SignUpOrIn));

        driver.findElement(SignUpOrIn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingOfSignInPage));
        driver.findElement(email).sendKeys(Email);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(SignUpOrIn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyOfPage));
        return new createFlyerPage(driver);
    }
}
