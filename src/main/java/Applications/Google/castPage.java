package Applications.Google;

import Utility.readExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static Targets.targets.*;

public class castPage {
        private WebDriver driver;
        public castPage(WebDriver driver)
        {
            this.driver=driver;
        }


    public String closingImdb() throws InterruptedException, IOException {

            WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));
            //Thread.sleep(5000);
        readExcelFile reading= new readExcelFile();
        int row = 2;
        System.out.println("Adding Names to sheet");
        for (WebElement placeHolderNames : driver.findElements(actualNames)) {
            String name = placeHolderNames.getText();
            reading.MakeSheet(3, row, 0, name);
            row = row + 1;
        }
        row = 2;
        //Screen name

        for (WebElement placeHolderDates : driver.findElements(playNames)) {
            String screenName = placeHolderDates.getText();
            reading.MakeSheet(3, row, 1, screenName);
            row = row + 1;
        }
        row = 2;
        //Appearances and date

        for (WebElement placeHolderDates : driver.findElements(appearancesAndDates)) {
            String appearancesDates = placeHolderDates.getText();
            reading.MakeSheet(3, row, 2, appearancesDates);
            row = row + 1;
        }
        System.out.println("finally here");

        return "and done";
    }


}
