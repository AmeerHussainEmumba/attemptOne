package Pages;

import com.google.common.collect.Lists;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HerokuApp {
    private WebDriver driver;
    public HerokuApp(WebDriver driver) {this.driver=driver;}

    public loginPage click()
    {

        String a = "window.open('https://emumba-test.herokuapp.com/','_blank');";
        ((JavascriptExecutor) driver).executeScript(a);
        List<String> newBrowserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(newBrowserTabs.get(2));
        return new loginPage(driver);
    }
}
