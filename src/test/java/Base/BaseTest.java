package Base;

import Applications.excelSheetData.readExcelFile;
import Applications.Google.homePage;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {

    protected homePage Homepage;
    private ChromeDriver driver;
    readExcelFile reading = new readExcelFile();

    @BeforeClass
    public void setUp() throws IOException {
        System.out.println("we have liftoff");
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        String URl = reading.Retrievedata(0, 0, 1);
        driver.get(URl);
        Homepage = new homePage(driver);
    }


    @AfterMethod

    public void endNow() {
        driver.quit();
        /* List<String> newBrowserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(newBrowserTabs.get(2));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(1));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(0));
        driver.close();*/
    }
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
