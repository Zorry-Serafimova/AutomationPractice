package PageObjects;

import gherkin.lexer.Fi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static PageObjects.HelperClass.isElementClickable;
import static PageObjects.HelperClass.waitUntilElementVisible;

public class VerifyAddressPage {

    @FindBy(xpath = "//*[@id='address_delivery']")
    private WebElement deliveryAddressContainer;
    @FindBy(xpath = "//ul[@class='address item box']//span[contains(text(),'Update')]")
    private WebElement btnUpdate_deliveryAddress;
    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement btnProceed;

    @FindBy(xpath = "//ul[@id='address_delivery']//li")
    private List<WebElement> deliveryAddress;
    @FindBy(xpath = "//ul[@class='address alternate_item box']//li")
    private List<WebElement> billingAddress;

    public VerifyAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickUpdatebtn(WebDriver driver) {
        isElementClickable(driver, 5, btnUpdate_deliveryAddress);
        btnUpdate_deliveryAddress.click();
    }

    public String getDeliveryAddress(WebDriver driver) {
        waitUntilElementVisible(driver, 3, deliveryAddressContainer);
        String txtDeliveryAddress = "";
        for (WebElement address : deliveryAddress) {
            if (address.getText().contains("222 N Main Street Suite 2300"))
                txtDeliveryAddress = address.getText();
        }
        return txtDeliveryAddress;
    }

    public String getBillingAddress() {
        String txtBillingAddress = "";
        for (int i = 0; i < billingAddress.size(); i++) {
            if(deliveryAddress.get(i).getText().contains("222 N Main Street Suite 2300"))
                txtBillingAddress = billingAddress.get(i).getText();
        }
        return txtBillingAddress;
    }

    public void clickProceedToCheckout(){
        btnProceed.click();
    }
}
