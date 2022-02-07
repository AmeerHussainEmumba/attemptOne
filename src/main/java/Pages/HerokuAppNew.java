package Pages;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class HerokuAppNew {
    private WebDriver driver;
    private String newTitle;
    public HerokuAppNew(WebDriver driver, String title)
    {
        this.driver=driver;
        newTitle=title;
    }

    public void Screenshot() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[2]")));
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("/Users/emumba/Desktop/From old PC/Automation Assignment/attemptOne/" + newTitle +".png");
        FileUtils.copyFile(scr, dest);
        System.out.println(newTitle);
        driver.close();
        List<String> newBrowserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(newBrowserTabs.get(1));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(0));
        driver.close();
    }
}
