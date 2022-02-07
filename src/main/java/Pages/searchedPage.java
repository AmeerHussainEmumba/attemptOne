package Pages;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class searchedPage {
    private WebDriver driver;
    public searchedPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public imdb scanResults()
    {
        WebElement imdbLink = driver.findElement(By.xpath("//a[contains(.,'After Life (TV Series 2019–2022) - IMDb')]"));
        String keyString = Keys.COMMAND + Keys.SHIFT.toString() + ENTER;
        imdbLink.sendKeys(keyString);
        List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        return new imdb(driver);
    }


}
