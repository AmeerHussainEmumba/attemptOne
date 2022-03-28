package Base;

import Applications.Herokuapp.herokuBasePage;
import Utility.excelFileManipulation;
import Applications.Google.homePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

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

}
