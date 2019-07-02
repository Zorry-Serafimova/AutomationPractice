package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;
    @FindBy(id = "login_form")
    private WebElement loginInputForm;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginInputForm() {
        System.out.println("logininputform");
        return this.loginInputForm;
    }

    public String getLogInPageTitle() {
        return this.driver.getTitle();
    }

    public void login(String email, String password) {
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }

}
