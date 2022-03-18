package Applications.Google.Steps.AfterLife;

import Utility.readExcelFile;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Targets.targets.searchbar;
import static org.openqa.selenium.Keys.ENTER;

public class getFullCast {

    readExcelFile reading= new readExcelFile();
    public WebDriver search_movie(WebDriver driver) throws IOException {
        readExcelFile reading= new readExcelFile();
        System.out.println("started");
        String URl = reading.Retrievedata(0,0, 1);
        driver.get(URl);
        driver.findElement(searchbar).click();
        String MovieName = reading.Retrievedata(0,1, 1);
        driver.findElement(searchbar).sendKeys(MovieName + ENTER);
        return driver;
    }

}
