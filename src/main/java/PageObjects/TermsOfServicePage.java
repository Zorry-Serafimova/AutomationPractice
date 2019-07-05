package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PageObjects.HelperClass.isElementClickable;

public class TermsOfServicePage {

    @FindBy(id = "cgv")
    private WebElement termsofService;
    @FindBy(id = "form")
    private WebElement form;
    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement checkoutBtn;

    public TermsOfServicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickTOS(WebDriver driver) {
        isElementClickable(driver, 3, form);
        termsofService.click();
    }

    public void clickCheckoutBtn(WebDriver driver) {
        isElementClickable(driver, 3, checkoutBtn);
        checkoutBtn.click();
    }
}
