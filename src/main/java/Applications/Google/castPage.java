package Applications.Google;

import Utility.excelFileManipulation;
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


    public String closingImdb() throws IOException {
            /*
            The following code creates a new object of the "excelFileManipulation" class, which is used to append existing sheets, or create a new one.
            For the following code, the "qaautimation" sheet is used, which can be seen in the "testData" folder.
            */

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));

        excelFileManipulation appendingDataInSheet= new excelFileManipulation();

        /*
        This following code appends data in the sheet. First takes in the actual names of the cast members and adds them to the first column
        of the sheet
        */
        int row = 2;
        System.out.println("Adding Names to sheet");
        for (WebElement placeHolderNames : driver.findElements(actualNames)) {
            String name = placeHolderNames.getText();
            appendingDataInSheet.makeSheet(3, row, 0, name);
            row = row + 1;
        }
        row = 2;
        /*
        Then takes the screen name and puts them into the second column of the sheet.
        */

        for (WebElement placeHolderDates : driver.findElements(playNames)) {
            String screenName = placeHolderDates.getText();
            appendingDataInSheet.makeSheet(3, row, 1, screenName);
            row = row + 1;
        }
        row = 2;
        /*
        It then finally takes the appearances of the performers and puts them into hte third column of the sheet
        */

        for (WebElement placeHolderDates : driver.findElements(appearancesAndDates)) {
            String appearancesDates = placeHolderDates.getText();
            appendingDataInSheet.makeSheet(3, row, 2, appearancesDates);
            row = row + 1;
        }
        System.out.println("finally here");
        return "and done";
    }


}
