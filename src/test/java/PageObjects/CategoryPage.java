package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[@class='cat-name']")
    private WebElement titleCategory;

    @FindBy(xpath = "//a[@class='product-name'][contains(text(),'Blouse')]")
    private WebElement blouseListing;

    public String getCategoryPageTitle() {
        return driver.getTitle();
    }

    public void clickOnListing() {
        blouseListing.click();
    }

    public WebElement getTitleCategory(){
        return titleCategory;
    }

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
