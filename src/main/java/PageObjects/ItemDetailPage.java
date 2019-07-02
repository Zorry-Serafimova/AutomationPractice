package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static PageObjects.HelperClass.isElementClickable;
import static PageObjects.HelperClass.waitUntilElementVisible;

public class ItemDetailPage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='box-info-product']")
    private WebElement addToCartContainer;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    public ItemDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCartClick() {
        isElementClickable(driver, 5, addToCartButton);
        addToCartButton.click();
    }
   /* public WebElement addToCartConfirmation() {
        return driver.findElement(By.cssSelector("#layer_cart"));
    }*/

    public void proceedToCheckoutButtonClick() {
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        isElementClickable(driver, 5, proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }

    public void confirmAddToCartContainer() {
        waitUntilElementVisible(driver, 3, addToCartContainer);
    }
}
