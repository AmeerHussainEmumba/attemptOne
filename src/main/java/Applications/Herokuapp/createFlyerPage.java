package Applications.Herokuapp;

import Applications.excelSheetData.readExcelFile;
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

    public herokuBasePage createflyer() throws IOException, InterruptedException { readExcelFile reading= new readExcelFile();

        driver.findElement(createAFlyer).click();
        String title= driver.findElement(nameOfTitle).getText();

        driver.findElement(Title).sendKeys(title);

        String[] points = new String[5];
        for (int li = 1,count=0; li <= 5; li++,count++) {
            String pointers = driver.findElement(By.xpath("//li["+li+"]")).getText();
            points[count] = pointers;
        }


        for (int n=0;n<=4;n++) {
            driver.findElement(Details).sendKeys(points[n] + "\n");
        }

        String Phone=reading.Retrievedata(0,5, 1);
        driver.findElement(PhoneNumb).sendKeys(Phone);
        String address=reading.Retrievedata(0,6, 1);
        driver.findElement(Address).sendKeys(address);
        driver.findElement(City).sendKeys("There is no check here");
        driver.findElement(Country).sendKeys("There is no check here either");

        String[] Tag = new String[3];
        for (int count = 0,RowNumber=7; count <= 2; count++, RowNumber++) {
            String ExtractedTags = reading.Retrievedata(0,RowNumber,1);
            Tag[count] = ExtractedTags;
        }

        driver.findElement(Tags).sendKeys(Tag[0] + ENTER + Tag[1] + ENTER + Tag[2] + ENTER);
        Thread.sleep(2000);
        driver.findElement(postingButton).click();
        Thread.sleep(2000);
        driver.findElement(homeButton).click();
        return new herokuBasePage(driver,title);
    }


}
