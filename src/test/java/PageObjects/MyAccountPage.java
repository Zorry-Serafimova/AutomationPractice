package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage{

    @FindBy(xpath = "//p[@class='info-account']")
    private WebElement welcomeMessage;
    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    private WebElement emptyCart;
    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    private WebElement womenOption;


    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnWomenCategory() {
        womenOption.click();
    }

    public WebElement getWelcomeMessage(){
        return welcomeMessage;
    }

    public WebElement getWomenOption(){
        return womenOption;
    }
}
