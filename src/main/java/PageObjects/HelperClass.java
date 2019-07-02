package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class HelperClass {
    private static WebDriverWait wait;

    static void isElementClickable(WebDriver driver, int timeout, WebElement element) {
        wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println(element + " is not found");
        }
    }

    static void waitUntilElementVisible(WebDriver driver, int timeout, WebElement element) {
        wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println(element + " is not visible");
            String currentURL = driver.getCurrentUrl();
            driver.get(currentURL);
        }
    }
}
