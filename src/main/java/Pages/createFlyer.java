package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.openqa.selenium.Keys.ENTER;

public class createFlyer {
    private WebDriver driver;
    public createFlyer(WebDriver driver)
    {
        this.driver=driver;
    }

    public HerokuApp createflyer() throws IOException, InterruptedException { ReadExcelFile reading= new ReadExcelFile();
        WebElement createFlyer = driver.findElement(By.xpath("//button[contains(., 'Create Flyer')]"));
        createFlyer.click();
        String title=driver.findElement(By.xpath("//h6[contains(., 'P')]")).getText();
        WebElement Title=driver.findElement(By.name("title"));
        Title.sendKeys(title);

        String[] points = new String[5];
        for (int li = 1,count=0; li <= 5; li++,count++) {
            String pointers = driver.findElement(By.xpath("//li["+li+"]")).getText();
            points[count] = pointers;
        }

        WebElement Details=driver.findElement(By.name("details"));
        for (int n=0;n<=4;n++) {
            Details.sendKeys(points[n] + "\n");
        }

        String Phone=reading.Retrievedata(0,5, 1);
        WebElement PhoneNumb= driver.findElement(By.name("phone"));
        PhoneNumb.sendKeys(Phone);

        String address=reading.Retrievedata(0,6, 1);
        WebElement Address= driver.findElement(By.name("address"));
        Address.sendKeys(address);
        driver.findElement(By.name("city")).sendKeys("There is no check here");
        driver.findElement(By.name("country")).sendKeys("There is no check here either");

        WebElement Tags = driver.findElement(By.xpath(".//*[@placeholder='Tags (optional)']"));
        String[] Tag = new String[3];
        for (int count = 0,RowNumber=7; count <= 2; count++, RowNumber++) {
            String ExtractedTags = reading.Retrievedata(0,RowNumber,1);
            Tag[count] = ExtractedTags;
        }

        Tags.sendKeys(Tag[0] + ENTER + Tag[1] + ENTER + Tag[2] + ENTER);
        Thread.sleep(2000);

        WebElement postingButton = driver.findElement(By.xpath("//button[contains(.,'Post Flyer')]"));

        postingButton.click();

        Thread.sleep(2000);

        WebElement homeButton = driver.findElement(By.xpath("//a[contains(., 'Go back Home')]"));
        homeButton.click();

        return new HerokuApp(driver,title);
    }


}
