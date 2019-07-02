package PageObjects;

import Base.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
    private static WebDriverWait wait;

    public static void isElementClickable(WebDriver driver, int timeout, WebElement element) {
        wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Element is not found");
        }
    }

    public static void waitUntilElementVisible(WebDriver driver, int timeout, WebElement element) {
        wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element not visible");
            String currentURL = driver.getCurrentUrl();
            driver.get(currentURL);
        }
    }
}
