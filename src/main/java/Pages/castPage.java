package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class castPage {
        private WebDriver driver;
        public castPage(WebDriver driver)
        {
            this.driver=driver;
        }


    public HerokuApp closingImdb() throws InterruptedException, IOException {
            Thread.sleep(5000);
        ReadExcelFile reading= new ReadExcelFile();
        int row = 2;
        System.out.println(row);
        List<WebElement> actualNames = (List<WebElement>) driver.findElements(By.xpath("//*[@id='fullcredits_content']/table[3]/tbody/tr/td[2]"));
        for (WebElement placeHolderNames : actualNames) {
            String name = placeHolderNames.getText();
            reading.MakeSheet(3, row, 0, name);
            row = row + 1;
        }
        row = 2;
        //Screen name
        List<WebElement> playNames = (List<WebElement>) driver.findElements(By.xpath("//*[@id='fullcredits_content']/table[3]/tbody/tr/td[4]/a[1]"));
        //System.out.println(playNamesAndDates.size());
        for (WebElement placeHolderDates : playNames) {
            String screenName = placeHolderDates.getText();
            reading.MakeSheet(3, row, 1, screenName);
            row = row + 1;
        }
        row = 2;
        //Appearances and date
        List<WebElement> appearancesAndDates = (List<WebElement>) driver.findElements(By.xpath("//*[@id='fullcredits_content']/table[3]/tbody/tr/td[4]/a[2]"));
        for (WebElement placeHolderDates : appearancesAndDates) {
            String appearancesDates = placeHolderDates.getText();
            reading.MakeSheet(3, row, 2, appearancesDates);
            row = row + 1;
        }
        System.out.println("finally here");
        return new HerokuApp(driver, "finally here");
    }


}
