package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObjects.HelperClass.isElementClickable;
import static PageObjects.HelperClass.waitUntilElementVisible;

public class CheckoutProcessAlertPage {


    //*[@id="center_column"]/p[2]/a[1]
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckoutBtnSummaryPage;

    @FindBy(xpath = "//div[@id='order-detail-content']")
    private WebElement checkoutContainer;

    public void clickProceedToCheckoutClick(WebDriver driver) {
        isElementClickable(driver, 5, proceedToCheckoutBtnSummaryPage);
        proceedToCheckoutBtnSummaryPage.click();
    }

    public void getCheckoutContainer(WebDriver driver){
        waitUntilElementVisible(driver, 5, checkoutContainer);
    }

    public CheckoutProcessAlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
