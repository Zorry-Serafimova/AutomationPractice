package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PageObjects.HelperClass.isElementClickable;

public class BackToOrdersPage {
    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement message;

    public BackToOrdersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public String getMessage() {
        return message.getText();
    }

    @FindBy(xpath = "//a[@class='button-exclusive btn btn-default']")
    private WebElement backToOrders;

    public void clickBackToOrders(WebDriver driver) {
        isElementClickable(driver, 5, backToOrders);
        backToOrders.click();
    }
}
