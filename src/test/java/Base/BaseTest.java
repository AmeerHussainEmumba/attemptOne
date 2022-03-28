package Base;

import Applications.Herokuapp.herokuBasePage;
import Utility.excelFileManipulation;
import Applications.Google.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static Targets.targets.actualNames;

public class BaseTest {

    protected homePage Homepage;
    protected herokuBasePage herokuBasePage;
    private ChromeDriver driver;
    protected excelFileManipulation retrievingDataFromSheet = new excelFileManipulation();


    @BeforeClass
    public void setUp() throws IOException {
        System.out.println("we have liftoff");
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        String URl = retrievingDataFromSheet.retrieveData(0, 0, 1);
        driver.get(URl);
        Homepage = new homePage(driver);
        herokuBasePage = new herokuBasePage(driver, "null");
    }

    @AfterClass

    public void endNow()
    {
        driver.quit();
    }

    @Test
    public void main () throws IOException
    {
        driver.get("https://www.imdb.com/title/tt8398600/fullcredits/?ref_=tt_cl_sm");
        List<WebElement> actorNamesAndDates= driver.findElements(By.xpath("//table[@class='cast_list']//a[not(.//img)]"));

        for (int row=2; row<=(actorNamesAndDates.size()+2); row++)
        {
            for (WebElement placeHolderNames : actorNamesAndDates)
            {
                String imdbDataToBeSent = placeHolderNames.getText();
                System.out.println(imdbDataToBeSent);
                retrievingDataFromSheet.iterateTableDataIntoSheet(4, row, imdbDataToBeSent);
            }
        }
        //we are stuck here :)

    }

}

