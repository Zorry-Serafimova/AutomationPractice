package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PageObjects.HelperClass.waitUntilElementVisible;

public class OrderHistoryPage {
    @FindBy(xpath = "//tr[contains(@class,'first_item')]")
    private WebElement first_item;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement price;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//table[@id='order-list']")
    private WebElement orderTable;

    @FindBy(xpath = "//tr[contains(@class,'first_item')]//td[@class='history_price']")
    private WebElement txtPrice;

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void orderHistoryTable(WebDriver driver){
        waitUntilElementVisible(driver, 5, orderTable);

    }
    public boolean getFirstItem(WebDriver driver){
        waitUntilElementVisible(driver, 3, first_item);
       return first_item.isDisplayed();
    }
    public String getPrice(){
        return txtPrice.getText();
    }
    public void logout(WebDriver driver) {
        waitUntilElementVisible(driver, 3, logoutButton);
        logoutButton.click();
    }
}
