package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PageObjects.HelperClass.isElementClickable;

public class ConfirmOrderPage {
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;

    public ConfirmOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickConfirmOrderBtn(WebDriver driver) {
        isElementClickable(driver, 5, confirmOrderBtn);
        confirmOrderBtn.click();
    }

}
