package Applications.AfterLife.Steps;

import Utility.excelFileManipulation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


import static Applications.AfterLife.Targets.forHomePage.searchbar;
import static org.openqa.selenium.Keys.ENTER;

public class getFullCast {

    excelFileManipulation reading= new excelFileManipulation();
    public WebDriver search_movie(WebDriver driver) throws IOException {
        excelFileManipulation reading= new excelFileManipulation();
        System.out.println("started");
        String URl = reading.retrieveData(0,0, 1);
        driver.get(URl);
        driver.findElement(searchbar).click();
        String MovieName = reading.retrieveData(0,1, 1);
        driver.findElement(searchbar).sendKeys(MovieName + ENTER);
        return driver;
    }

}
