package Base;

import Pages.ReadExcelFile;
import Pages.homepage;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {

    protected homepage Homepage;
    private ChromeDriver driver;
    ReadExcelFile reading = new ReadExcelFile();

    @BeforeClass
    public void setUp() throws IOException {
        System.out.println("we have liftoff");
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        String URl = reading.Retrievedata(0, 0, 1);
        driver.get(URl);
        Homepage = new homepage(driver);
    }

    /*@AfterClass
    public void endNow() {}*/

    @AfterMethod

    public void endNow() {
        List<String> newBrowserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(newBrowserTabs.get(2));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(1));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(0));
        driver.close();
    }
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
    /*public void startingPoint() throws InterruptedException, IOException {


        //open doc and extract info
        //String URl = reading.Retrievedata(0,0, 1);
        //driver.get(URl);
        WebElement search = driver.findElement(By.name("q"));
        search.click();
        String MovieName = reading.Retrievedata(0,1, 1);
        search.sendKeys(MovieName + Keys.ENTER);

        //search imbd page

        WebElement imdbLink = driver.findElement(By.xpath("//a[contains(.,'After Life (TV Series 2019–2022) - IMDb')]"));

        //open imdb page

        String keyString = Keys.COMMAND + Keys.SHIFT.toString() + Keys.ENTER;
        imdbLink.sendKeys(keyString);
        List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        //open all cast page
        Thread.sleep(5000);
        WebElement castPage = driver.findElement(By.xpath("//a[contains (.,'All cast & crew')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", castPage);
        castPage.click();
        Thread.sleep(5000);

        // setup workbook


        //extract Information from all cast page
        //names
        int row = 2;
        System.out.println("Starting excell sheet input");
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

    }
    public void MidDrift() throws InterruptedException, IOException {
        //herokuapp stuff
        String a = "window.open('https://emumba-test.herokuapp.com/','_blank');";
        ((JavascriptExecutor)driver).executeScript(a);
        List<String> newBrowserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(newBrowserTabs.get(2));

        //signing up and in

        WebElement Login= driver.findElement(By.xpath("//button[contains(.,'Login')]"));
        Login.click();
        Thread.sleep(3000);
        WebElement notAUserYetButton =driver.findElement(By.xpath("//a[contains(., 'a')]"));
        notAUserYetButton.click();
        Thread.sleep(2000);

        ReadExcelFile reading= new ReadExcelFile();
        String FirstName=reading.Retrievedata(3,6,0);
        WebElement first_name=driver.findElement(By.name("first_name"));
        first_name.sendKeys(FirstName);
        String LastName=reading.Retrievedata(3,6,1);
        WebElement last_name=driver.findElement(By.name("last_name"));
        last_name.sendKeys(LastName);
        String Email =reading.Retrievedata(0,3,1);
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys(Email);
        String Password=reading.Retrievedata(0,4,1);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys(Password);
        WebElement confirm_password=driver.findElement(By.name("confirm_password"));
        confirm_password.sendKeys(Password);
        Thread.sleep(2000);
        WebElement SignUp =driver.findElement(By.xpath("//button[contains(., 'i')]"));
        SignUp.click();
        Thread.sleep(2000);
        WebElement emailSignedIn=driver.findElement(By.name("email"));
        emailSignedIn.sendKeys(Email);
        WebElement passwordSignedIn=driver.findElement(By.name("password"));
        passwordSignedIn.sendKeys(Password);
        WebElement SignIn =driver.findElement(By.xpath("//button[contains(., 'i')]"));
        SignIn.click();
        Thread.sleep(3000);

        //creating a flyer
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

        Tags.sendKeys(Tag[0] + Keys.ENTER + Tag[1] + Keys.ENTER + Tag[2] + Keys.ENTER);
        Thread.sleep(2000);

        WebElement postingButton = driver.findElement(By.xpath("//button[contains(.,'Post Flyer')]"));

        postingButton.click();

        Thread.sleep(2000);

        WebElement homeButton = driver.findElement(By.xpath("//a[contains(., 'Go back Home')]"));
        homeButton.click();

        //Take Screenshot
        WebDriverWait wait = new WebDriverWait(driver, 10);
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[2]")));
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("/Users/emumba/Desktop/From old PC/Automation Assignment/attemptOne/" + title +".png");
        FileUtils.copyFile(scr, dest);
        System.out.println("Screenshot is saved and can be viewed by the name: "+title);
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(1));
        driver.close();
        driver.switchTo().window(newBrowserTabs.get(0));
        driver.close();
        }
    @AfterClass
    public void endNow()
    {
        driver.quit();
    }

    public static void main(String args[]) throws InterruptedException, IOException
    { BaseTest test= new BaseTest();
        test.setUp();
        test.startingPoint();
        test.MidDrift();
    }
    } Remove  curly bracket before main */

