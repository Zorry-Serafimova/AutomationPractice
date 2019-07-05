package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PageObjects.HelperClass.isElementClickable;

public class PayByCheckPage {
    private String price = "";

    @FindBy(xpath = "//a[@class='cheque']")
    private WebElement checkPayment;

    @FindBy(xpath = "//a[@class='cheque']")
    private WebElement payByCheckBox;

    @FindBy(id = "total_price_container")
    private WebElement txtTotalPrice;

    public PayByCheckPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnPayByCHeck(WebDriver driver) {
        isElementClickable(driver, 5, payByCheckBox);
        checkPayment.click();
    }
    public void getTotalPrice(){
       price = txtTotalPrice.getText();
    }

    public String returnPrice(){
        return price;
    }


}
