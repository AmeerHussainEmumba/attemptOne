package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.openqa.selenium.Keys.ENTER;

public class homepage {
    private WebDriver driver;
    private By searchbar = By.name("q");
    public homepage(WebDriver driver)
    {
        this.driver=driver;
    }

    public searchedPage searching() throws IOException {
        ReadExcelFile reading= new ReadExcelFile();
        System.out.println("started");
        String URl = reading.Retrievedata(0,0, 1);
        driver.get(URl);
        WebElement Search= driver.findElement(searchbar);
        Search.click();
        String MovieName = reading.Retrievedata(0,1, 1);
        Search.sendKeys(MovieName + ENTER);
        return new searchedPage(driver);
    }
}
