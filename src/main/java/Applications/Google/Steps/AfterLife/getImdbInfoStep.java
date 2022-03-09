package Applications.Google.Steps.AfterLife;

import Applications.excelSheetData.readExcelFile;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class getImdbInfoStep {
    WebDriver driver;

    public WebDriver setUpGoogle() throws IOException {
        readExcelFile reading = new readExcelFile();
        String URl = reading.Retrievedata(0, 0, 1);
        driver.get(URl);
        return driver;
    }
}
