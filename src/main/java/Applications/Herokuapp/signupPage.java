package Applications.Herokuapp;

import Applications.excelSheetData.readExcelFile;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Targets.targets.*;

public class signupPage {
    private WebDriver driver;
    public signupPage(WebDriver driver) {
        this.driver = driver;
    }
    public createFlyerPage singUpandIn() throws IOException, InterruptedException {
        readExcelFile reading= new readExcelFile();
        String FirstName=reading.Retrievedata(3,6,0);
        driver.findElement(first_name).sendKeys(FirstName);
        String LastName=reading.Retrievedata(3,6,1);
        driver.findElement(last_name).sendKeys(LastName);
        String Email =reading.Retrievedata(0,3,1);
        driver.findElement(email).sendKeys(Email);
        String Password=reading.Retrievedata(0,4,1);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(confirm_password).sendKeys(Password);
        Thread.sleep(2000);
        driver.findElement(SignUp).click();
        Thread.sleep(2000);
        driver.findElement(emailSignedIn).sendKeys(Email);
        driver.findElement(passwordSignedIn).sendKeys(Password);
        driver.findElement(SignIn).click();
        Thread.sleep(3000);
        return new createFlyerPage(driver);
    }
}
