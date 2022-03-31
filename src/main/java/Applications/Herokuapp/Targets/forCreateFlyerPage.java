package Applications.Herokuapp.Targets;

import org.openqa.selenium.By;

public class forCreateFlyerPage {
    public static final By createAFlyer = By.xpath("//button[contains(., 'Create Flyer')]");
    public static final By nameOfTitle = By.xpath("//h6[contains(., 'P')]");
    public static final By Title= (By.name("title"));
    public static final By Details= (By.name("details"));
    public static final By PhoneNumb= (By.name("phone"));
    public static final By Address= (By.name("address"));
    public static final By City= (By.name("city"));
    public static final By Country= (By.name("country"));
    public static final By Tags = (By.xpath(".//*[@placeholder='Tags (optional)']"));
    public static final By postingButton = (By.xpath("//button[contains(.,'Post Flyer')]"));
    public static final By homeButton = (By.xpath("//a[contains(., 'Go back Home')]"));
}
