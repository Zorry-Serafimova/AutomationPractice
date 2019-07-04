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
    @FindBy(xpath = "//h3[contains(text(),'Your delivery address')]")
    private WebElement headerInfo;
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][contains(text(),'123 Tester Ave')])")
    private WebElement delivery_street;
    @FindBy(xpath = "//h3[contains(text(),'Your billing address')]")
    private WebElement billing;
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][contains(text(),'123 Tester Ave')]")
    private WebElement billing_street;
    @FindBy(xpath = "//*[@id='address_delivery']")
    private WebElement deliveryAddressContainer;
    @FindBy(xpath = "//ul[@class='address item box']//span[contains(text(),'Update')]")
    private WebElement btnUpdate_deliveryAddress;


    @FindBy(xpath = "//ul[@id='address_delivery']//li")
    private WebElement deliveryAddress;

    public void clickUpdatebtn(WebDriver driver){
        isElementClickable(driver, 5, btnUpdate_deliveryAddress);
        btnUpdate_deliveryAddress.click();
    }

    public String getDeliveryAddress(WebDriver driver) {
        waitUntilElementVisible(driver, 3, deliveryAddressContainer);
        System.out.println(deliveryAddress.getText());
        return deliveryAddress.getText();
    }



    public String getHeaderInfo() {
        return headerInfo.getText();
    }

    public String getDeliveryStreet(WebDriver driver) {
        waitUntilElementVisible(driver, 3, delivery_street);
        System.out.println(delivery_street.getText());
        return delivery_street.getText();
    }

    public String getBillingHeader(WebDriver driver) {
        waitUntilElementVisible(driver, 3, billing);
        return billing.getText();
    }

    public String getBillingStreet(WebDriver driver) {
        waitUntilElementVisible(driver, 3, billing_street);
        return billing_street.getText();
    }

    public VerifyAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
