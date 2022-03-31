package Applications.Herokuapp.Targets;

import org.openqa.selenium.By;

public class forSignUpAndInPages {
    public static final By loginButton = By.xpath("//button[contains(.,'Login')]");
    public static final By headingOfSignUpPage= By.xpath("//h5[contains(.,'Savers / Sign Up')]");
    public static final By headingOfSignInPage= By.xpath("//h5[contains(.,'Savers / Sign In')]");
    public static final By notAUserYetButton =(By.linkText("Not a user yet?"));
    public static final By first_name=(By.name("first_name"));
    public static final By last_name=(By.name("last_name"));
    public static final By email=(By.name("email"));
    public static final By password=(By.name("password"));
    public static final By confirm_password=(By.name("confirm_password"));
    public static final By SignUpOrIn =(By.xpath("//button[@type='submit']"));

    public static final By Logout= By.xpath("//button[contains(.,'Logout')]");
    public static final By bodyOfPage= By.xpath("//p[2]");

}
