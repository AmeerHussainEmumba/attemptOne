package Applications.Herokuapp;

import Utility.excelFileManipulation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Targets.targets.*;
import static org.openqa.selenium.Keys.ENTER;

public class createFlyerPage {
    private WebDriver driver;
    public createFlyerPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public herokuBasePage createFlyer() throws IOException, InterruptedException { excelFileManipulation reading= new excelFileManipulation();

        driver.findElement(createAFlyer).click();
        String title= driver.findElement(nameOfTitle).getText();

        driver.findElement(Title).sendKeys(title);

        /*This line of code takes in the instructions written on the page and saves them.*/

        String[] points = new String[5];
        for (int li = 1,count=0; li <= 5; li++,count++) {
            String pointers = driver.findElement(By.xpath("//li["+li+"]")).getText();
            points[count] = pointers;
        }

        /*
        This line of code saves all the instructions saved along with their order numbers, and inputs them as details of the poster page
        */
        for (int n=0;n<=4;n++) {
            driver.findElement(Details).sendKeys(points[n] + "\n");
        }

        String Phone=reading.retrieveData(0,5, 1);
        driver.findElement(PhoneNumb).sendKeys(Phone);
        String address=reading.retrieveData(0,6, 1);
        driver.findElement(Address).sendKeys(address);
        driver.findElement(City).sendKeys("There is no check here");
        driver.findElement(Country).sendKeys("There is no check here either");


        /*
        This line of code retrieves tags from the sheet, and saves them in an array of string.
        */
        String[] Tag = new String[3];
        for (int count = 0,RowNumber=7; count <= 2; count++, RowNumber++) {
            String ExtractedTags = reading.retrieveData(0,RowNumber,1);
            Tag[count] = ExtractedTags;
        }
        /*
        All tags saved are one by one written down in the Add tags section
        */
        driver.findElement(Tags).sendKeys(Tag[0] + ENTER + Tag[1] + ENTER + Tag[2] + ENTER);
        driver.findElement(postingButton).click();
        driver.findElement(homeButton).click();
        return new herokuBasePage(driver,title);
    }


}
