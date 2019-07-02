package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    private final WebDriver driver;

    @FindBy(xpath = "//p[@class='info-account']")
    private WebElement welcomeMessage;
    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    private WebElement emptyCart;
    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    private WebElement womenOption;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver; PageFactory.initElements(driver, this);
    }

    public void clickOnWomenCategory() {
        womenOption.click();
    }

    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    public WebElement getWomenOption() {
        return womenOption;
    }

    public void WomenOptionExists() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(womenOption));
    }

    public void WelcomeMessageIsVisible(){
        HelperClass.waitUntilElementVisible(driver, 5, womenOption);
    }
}
