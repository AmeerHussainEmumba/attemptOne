package Pages;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HerokuApp {
    private WebDriver driver;
    private String newTitle;

    public HerokuApp(WebDriver driver, String Status) {
        this.driver = driver;
        newTitle=Status;
    }

    public loginPage click() {

        String a = "window.open('https://emumba-test.herokuapp.com/','_blank');";
        ((JavascriptExecutor) driver).executeScript(a);
        List<String> newBrowserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(newBrowserTabs.get(2));
        return new loginPage(driver);
    }

    public String Screenshot() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[2]")));
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("/Users/emumba/Desktop/From old PC/Automation Assignment/attemptOne/" + newTitle + ".png");
        FileUtils.copyFile(scr, dest);
        System.out.println(newTitle);
        return "and done";
    }
}
