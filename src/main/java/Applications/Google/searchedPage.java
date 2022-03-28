package Applications.Google;

import com.google.common.collect.Lists;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static Targets.targets.imdbLink;
import static org.openqa.selenium.Keys.ENTER;

public class searchedPage {
    private WebDriver driver;
    public searchedPage(WebDriver driver) {this.driver=driver;}
    public imdbPage scanResults()
    {
        /*
        This line of code keeps save a chain of command into a string which will allow us to open a link into a new tab, using keyboard shortcuts
        */
        String keyString = Keys.COMMAND + Keys.SHIFT.toString() + ENTER;
        driver.findElement(imdbLink).sendKeys(keyString);
        /*
        It then gets the number of windows currently open and shifts to the second one, i.e. the latest one opened, (the index begins at 0)
        */
        List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        return new imdbPage(driver);
    }
}
