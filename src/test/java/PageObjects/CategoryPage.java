package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
    private final WebDriver driver;

    @FindBy(id = "subcategories")
    private WebElement subCategories;

    @FindBy(xpath = "//a[@class='product-name'][contains(text(),'Blouse')]")
    private WebElement blouseListing;

    public void clickOnListing() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(blouseListing));
        blouseListing.click();
    }

    public void pageIsLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(subCategories));
    }


    public CategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
