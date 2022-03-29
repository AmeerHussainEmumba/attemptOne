package Targets;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class targets {

    //Homepage
    public static final By searchbar = By.name("q");

    //searchedPage
    public static final By imdbLink = By.xpath("//a[contains(.,'After Life (TV Series 2019–2022) - IMDb')]");

    //imdbPage
    public static final By CastsPage = By.xpath("//a[contains (.,'All cast & crew')]");

    //castPage
//    public static final By actualNames =  By.xpath("//*[@id='fullcredits_content']/table[3]/tbody/tr/td[2]");
//    public static final By playNames = By.xpath("//*[@id='fullcredits_content']/table[3]/tbody/tr/td[4]/a[1]");
//    public static final By appearancesAndDates = By.xpath("//*[@id='fullcredits_content']/table[3]/tbody/tr/td[4]/a[2]");

    //Here
    public static final By actualNames= By.xpath("//table[@class='cast_list']//a[not(.//img) and @href[contains(.,'name')]]");
    public static final By playNames= By.xpath("//table[@class='cast_list']//a[not(.//img) and @href[contains(.,'title')]]");
    public static final By appearancesAndDates= By.xpath("//table[@class='cast_list']//a[not(.//img) and @href[contains(.,'#')]]");




    public static final By LoginButton= By.xpath("//button[contains(.,'Login')]");

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

    public static final By notAUserYetButton =(By.xpath("//a[contains(., 'a')]"));
    public static final By first_name=(By.name("first_name"));
    public static final By last_name=(By.name("last_name"));
    public static final By email=(By.name("email"));
    public static final By password=(By.name("password"));
    public static final By confirm_password=(By.name("confirm_password"));
    public static final By SignUp =(By.xpath("//button[contains(., 'i')]"));
    //public static final By emailSignedIn=(By.name("email"));
    //public static final By passwordSignedIn=(By.name("password"));
    public static final By SignIn =(By.xpath("//button[contains(., 'i')]"));

    public static final By Logout= By.xpath("//button[contains(.,'Logout')]");




}



