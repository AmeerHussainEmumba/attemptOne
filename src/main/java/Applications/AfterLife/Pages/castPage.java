package Applications.AfterLife.Pages;

import Utility.excelFileManipulation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static Applications.AfterLife.Targets.forCastPage.tableRow;



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
        This following code appends data in the sheet. It first takes in the entire row of the table, and see if it isn't just null,
        if yes then it ignores that row, if not then it takes it and splits it to extract the actual name of the cast and the remaining
        portion. From the remaining portion it then extracts the ScreenName and the remaining part is the episodes and dates.
        */

        List<WebElement> tableData= driver.findElements(tableRow);
        int row=2;
        for (WebElement placeHolderForTableInformation : tableData)
        {
            if (placeHolderForTableInformation.getText().isBlank()==false)
            {
                String[] initialSplit = placeHolderForTableInformation.getText().toString().split(" ...  ");
                String actualName = initialSplit[0];
                String remainingSplit= initialSplit[1];
                String[] Rest= remainingSplit.split("\n");
                String screenName=Rest[0];
                String episodesAndDates=Rest[1];
                appendingDataInSheet.makeSheet(3, row, 0, actualName);
                appendingDataInSheet.makeSheet(3, row, 1, screenName);
                appendingDataInSheet.makeSheet(3, row, 2, episodesAndDates);
                row++;
            }
        }
        System.out.println("finally here");
        return "and done";
    }


}
