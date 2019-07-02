package StepDefinitions;

import Base.BaseUtils;
import PageObjects.CategoryPage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static PageObjects.HelperClass.waitUntilElementVisible;

public class AutomationPracticeStepDefinitions extends BaseUtils {

    private BaseUtils base;

    public AutomationPracticeStepDefinitions(BaseUtils base) {
        this.base = base;
    }

    @Given("^User navigates to login page$")
    public void userNavigatesToLoginPage() {
        base.driver.get(base.baseURL);
    }

    @When("^Login form is present$")
    public void loginFormIsPresent() {
        Assert.assertEquals(base.driver.getTitle(), "Login - My Store");
    }

    @And("^User enters \"([^\"]*)\" in email field and \"([^\"]*)\" in password field$")
    public void userEntersInEmailFieldAndInPasswordField(String email, String password) {
        LoginPage login = new LoginPage(base.driver);
        login.login(email, password);
    }

    @Then("^User is On My Account page$")
    public void userIsOnMyAccountPage() {
        MyAccountPage myAccountPage = new MyAccountPage(base.driver);
        waitUntilElementVisible(base.driver, 5, myAccountPage.getWelcomeMessage());
        /*base.wait = new WebDriverWait(base.driver, 5);
        try {
            wait.until(ExpectedConditions.titleIs("My account - My Store"));
            final WebElement until = wait.until(ExpectedConditions.visibilityOf(myAccountPage.getWelcomeMessage()));
        } catch (Exception e) {
            System.out.println("not visible");
        }*/
        Assert.assertEquals(base.driver.getTitle(), "My account - My Store");
    }

    @Given("^Women Category exists on page$")
    public void womenCategoryExistsOnPage() {
        MyAccountPage myAccountPage = new MyAccountPage(base.driver);

        waitUntilElementVisible(base.driver, 5, myAccountPage.getWomenOption());
    }

    @When("^User clicks on Women category$")
    public void userClicksOnWomenCategory() {
        MyAccountPage myAccountPage = new MyAccountPage(base.driver);
        myAccountPage.clickOnWomenCategory();
    }

    @Then("^Women Category page is loaded$")
    public void womenCategoryPageIsLoaded() {
        CategoryPage categoryPage = new CategoryPage(base.driver);
        categoryPage.pageIsLoaded();
        Assert.assertEquals(base.driver.getTitle(), "Women - My Store");
    }
}
