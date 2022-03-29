package Targets;


import org.openqa.selenium.By;


import java.util.List;

public class targets {

    //Homepage
    public static final By searchbar = By.name("q");

    //searchedPage
    public static final By imdbLink = By.xpath("//a[contains(.,'After Life (TV Series 2019–2022) - IMDb')]");

    //imdbPage
    public static final By CastsPage = By.xpath("//a[contains (.,'All cast & crew')]");

    //castPage

    public static final By tableRow= By.xpath("//table[@class='cast_list']//tr");

    public static final By loginButton = By.xpath("//button[contains(.,'Login')]");
    public static final By headingOfSignUpPage= By.xpath("//h5[contains(.,'Savers / Sign Up')]");
    public static final By headingOfSignInPage= By.xpath("//h5[contains(.,'Savers / Sign In')]");
    public static final By bodyOfPage= By.xpath("//p[2]");

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

    public static final By notAUserYetButton =(By.linkText("Not a user yet?"));
    public static final By first_name=(By.name("first_name"));
    public static final By last_name=(By.name("last_name"));
    public static final By email=(By.name("email"));
    public static final By password=(By.name("password"));
    public static final By confirm_password=(By.name("confirm_password"));
    public static final By SignUpOrIn =(By.xpath("//button[@type='submit']"));

    public static final By Logout= By.xpath("//button[contains(.,'Logout')]");




}



