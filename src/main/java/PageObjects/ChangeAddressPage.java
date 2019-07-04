package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PageObjects.HelperClass.waitUntilElementVisible;

public class ChangeAddressPage {

    @FindBy(id = "address1")
    private WebElement txtAddress1;
    @FindBy(id = "address2")
   private WebElement txtAddress2;
    @FindBy(id = "city")
    private WebElement txtCity;
    @FindBy(id = "postcode")
    private WebElement txtPostalCode;
    @FindBy(id = "other")
    private WebElement txtAddlInfo;
    @FindBy(id = "alias")
    private WebElement txtAlias;
    @FindBy(id = "submitAddress")
    private WebElement btnSave;
    @FindBy(id = "add_address")
    private WebElement addressBox;

    public ChangeAddressPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clearDeliveryAddressFieldsFirst(WebDriver driver){
        waitUntilElementVisible(driver, 3, addressBox);
        txtAddress1.clear();
        txtAddress2.clear();
        txtCity.clear();
        txtPostalCode.clear();
        txtAddlInfo.clear();
        txtAlias.clear();
    }

    public void enterNewDeliveryAddress(){
        txtAddress1.sendKeys("222 N Main Street");
        txtAddress2.sendKeys("Suite 2300");
        txtCity.sendKeys("Logan Square");
        txtPostalCode.sendKeys("60620");
        txtAddlInfo.sendKeys("Change via automation");
        txtAlias.sendKeys("Home");
        btnSave.click();

    }
}
