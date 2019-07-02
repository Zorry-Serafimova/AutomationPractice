package StepDefinitions;

import Base.BaseUtils;
import Base.HelperClass;
import PageObjects.CategoryPage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static Base.HelperClass.waitUntilElementVisible;

public class AutomationPracticeStepDefinitions extends BaseUtils {

    private BaseUtils base;

    public AutomationPracticeStepDefinitions(BaseUtils base) {
        this.base = base;
        login = new LoginPage(driver);
        myAccount = new MyAccountPage(driver);
        catPage = new CategoryPage(driver);
    }

    @Given("^User navigates to login page$")
    public void userNavigatesToLoginPage(){
        base.driver.get(base.baseURL);
    }

    @When("^Login form is present$")
    public void loginFormIsPresent() {
        waitUntilElementVisible(base.driver, 10, login.getLoginInputForm());
        Assert.assertEquals(login.getLogInPageTitle(), "Login - My Store");
    }

    @And("^User enters \"([^\"]*)\" in email field and \"([^\"]*)\" in password field$")
    public void userEntersInEmailFieldAndInPasswordField(String email, String password)  {
        login.login(email, password);
    }

    @Then("^User is On My Account page$")
    public void userIsOnMyAccountPage() {
        waitUntilElementVisible(driver, 5, myAccount.getWelcomeMessage());
        Assert.assertEquals(myAccount.getPageTitle(), "My account - My Store");
    }

    @Given("^Women Category exists on page$")
    public void womenCategoryExistsOnPage() {
        waitUntilElementVisible(driver, 5, myAccount.getWomenOption());
    }

    @When("^User clicks on Women category$")
    public void userClicksOnWomenCategory() {
        myAccount.clickOnWomenCategory();
    }

    @Then("^Women Category page is loaded$")
    public void womenCategoryPageIsLoaded() {
        waitUntilElementVisible(driver, 5, catPage.getTitleCategory());
        Assert.assertEquals(catPage.getCategoryPageTitle(), "Women - My Store");
    }
}
