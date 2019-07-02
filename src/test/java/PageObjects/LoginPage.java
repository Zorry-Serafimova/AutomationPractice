package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(id="email")
    WebElement emailLoggin;

    @FindBy(id="passwd")
    WebElement passwdLoggin;

    @FindBy(id="SubmitLogin")
    WebElement loggInButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        emailLoggin.sendKeys(email);
        passwdLoggin.sendKeys(password);
        loggInButton.click();
    }
}
