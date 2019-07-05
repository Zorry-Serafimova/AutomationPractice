package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static PageObjects.HelperClass.waitUntilElementVisible;


public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailLoggin;

    @FindBy(id = "passwd")
    private WebElement passwdLoggin;

    @FindBy(id = "SubmitLogin")
    private WebElement loggInButton;

    @FindBy(id = "login_form")
    private WebElement loginForm;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        emailLoggin.sendKeys(email);
        passwdLoggin.sendKeys(password);
        loggInButton.click();
    }

    public void getLoginInputForm(WebDriver driver){
        waitUntilElementVisible(driver, 5, loginForm);
    }
}
