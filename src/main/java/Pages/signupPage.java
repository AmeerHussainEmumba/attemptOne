package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class signupPage {
    private WebDriver driver;
    public signupPage(WebDriver driver) {
        this.driver = driver;
    }
    public createFlyer singUpandIn() throws IOException, InterruptedException {
        ReadExcelFile reading= new ReadExcelFile();
        String FirstName=reading.Retrievedata(3,6,0);
        WebElement first_name=driver.findElement(By.name("first_name"));
        first_name.sendKeys(FirstName);
        String LastName=reading.Retrievedata(3,6,1);
        WebElement last_name=driver.findElement(By.name("last_name"));
        last_name.sendKeys(LastName);
        String Email =reading.Retrievedata(0,3,1);
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys(Email);
        String Password=reading.Retrievedata(0,4,1);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys(Password);
        WebElement confirm_password=driver.findElement(By.name("confirm_password"));
        confirm_password.sendKeys(Password);
        Thread.sleep(2000);
        WebElement SignUp =driver.findElement(By.xpath("//button[contains(., 'i')]"));
        SignUp.click();
        Thread.sleep(2000);
        WebElement emailSignedIn=driver.findElement(By.name("email"));
        emailSignedIn.sendKeys(Email);
        WebElement passwordSignedIn=driver.findElement(By.name("password"));
        passwordSignedIn.sendKeys(Password);
        WebElement SignIn =driver.findElement(By.xpath("//button[contains(., 'i')]"));
        SignIn.click();
        Thread.sleep(3000);
        return new createFlyer(driver);
    }
}
