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


public class BaseTest {

    protected homePage Homepage;
    protected herokuBasePage herokuBasePage;
    private ChromeDriver driver;
    protected excelFileManipulation retrievingDataFromSheet = new excelFileManipulation();

    /*
    This line of code will be called before anything else. It sets up the Chrome browser, retrieves the URl given in the sheet,
    and opens it
    */
    @BeforeClass
    public void setUp() throws IOException {
        System.out.println("we have liftoff");
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        String URl = retrievingDataFromSheet.retrieveData(0, 0, 1);
        driver.get(URl);
        Homepage = new homePage(driver);
        herokuBasePage = new herokuBasePage(driver, "null"); //The string in the constructor is used to give a name to the
                                                                    // screenshot that will be taken later on. It also helps to debug
    }

    @AfterClass

    public void endNow()
    {
        driver.quit();
    }

    @Test
    public void experiment () throws IOException {
        driver.get("https://www.imdb.com/title/tt8398600/fullcredits/?ref_=tt_ql_cl");
        List<WebElement> tableRow= driver.findElements(By.xpath("//table[@class='cast_list']//tr"));
        int row=2;
        for (WebElement sample: tableRow)
        {
            if (sample.getText().isBlank()==false)
            {
            String[] initialPartialSplit = sample.getText().toString().split(" ...  ");
            String actualName = initialPartialSplit[0];
            String remainingStuff= initialPartialSplit[1];
            String[] Rest= remainingStuff.split("\n");
                retrievingDataFromSheet.makeSheet(4, row, 0, actualName);
                retrievingDataFromSheet.makeSheet(4, row, 1, Rest[0]);
                retrievingDataFromSheet.makeSheet(4, row, 2, Rest[1]);
                row++;
               //System.out.println("The name is " + actualName+ ", the screen name " + Rest[0]+ ", And the rest " +Rest[1]);
            }

        }

    }

}

