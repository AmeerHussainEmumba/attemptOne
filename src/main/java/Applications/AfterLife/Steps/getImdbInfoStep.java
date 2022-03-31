package Applications.AfterLife.Steps;


import Utility.excelFileManipulation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class getImdbInfoStep {
    WebDriver driver;

    public WebDriver setUpGoogle() throws IOException {
        excelFileManipulation reading= new excelFileManipulation();
        String URl = reading.retrieveData(0, 0, 1);
        driver.get(URl);
        return driver;
    }
}
