package StepDefinitions;

import Base.BaseUtils;
import PageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        myAccountPage.WelcomeMessageIsVisible();
        Assert.assertEquals(base.driver.getTitle(), "My account - My Store");
    }

    @Given("^Women Category exists on page$")
    public void womenCategoryExistsOnPage() {
        MyAccountPage myAccountPage = new MyAccountPage(base.driver);
        myAccountPage.WomenOptionExists();
    }

    @When("^User clicks on Women category$")
    public void userClicksOnWomenCategory() {
        MyAccountPage myAccountPage = new MyAccountPage(base.driver);
        myAccountPage.clickOnWomenCategory();
    }

    @And("^Women Category page is loaded$")
    public void womenCategoryPageIsLoaded() {
        CategoryPage categoryPage = new CategoryPage(base.driver);
        categoryPage.pageIsLoaded();
        Assert.assertEquals(base.driver.getTitle(), "Women - My Store");
    }


    @And("^User is on the Women's category page$")
    public void userIsOnTheWomenSCategoryPage() {
        CategoryPage categoryPage = new CategoryPage(base.driver);
        //check page
        if (!base.driver.getTitle().equals("Women - My Store")) {
            MyAccountPage myAccountPage = new MyAccountPage(base.driver);
            myAccountPage.clickOnWomenCategory();
        }
    }

    @And("^User clicks on a listing$")
    public void userClicksOnAListing() {
        CategoryPage categoryPage = new CategoryPage(base.driver);
        categoryPage.clickOnListing();
    }

    @And("^Listing page is loaded$")
    public void listingPageIsLoaded() throws InterruptedException {
        ItemDetailPage itemDetailPage = getItemDetailPage();
        itemDetailPage.confirmAddToCartContainer();
        Thread.sleep(3000);
        System.out.println(base.driver.getTitle());
        Assert.assertEquals(base.driver.getTitle(), "Blouse - My Store");
    }

    @And("^User adds listing to Cart$")
    public void userAddsListingToCart() {
        ItemDetailPage itemDetailPage = getItemDetailPage();
        itemDetailPage.addToCartClick();

    }

    @Then("^Listing is added to cart$")
    public void listingIsAddedToCart() {
        ItemDetailPage itemDetailPage = getItemDetailPage();
        itemDetailPage.proceedToCheckoutButtonClick();
    }

    private ItemDetailPage getItemDetailPage() {
        return new ItemDetailPage(base.driver);
    }
    private CheckoutProcessAlertPage getcheckoutProcess() {
        return new CheckoutProcessAlertPage(base.driver);
    }
    private VerifyAddressPage getVerVerifyAddress(){
        return new VerifyAddressPage(base.driver);
    }
    private ChangeAddressPage getChangeAddress(){
        return new ChangeAddressPage(base.driver);
    }

    @And("^User clicks on proceed to checkout button$")
    public void userClicksOnProceedToCheckoutButton() throws InterruptedException {
        base.checkoutProcess = getcheckoutProcess();
        base.checkoutProcess.getCheckoutContainer(base.driver);
        base.checkoutProcess.clickProceedToCheckoutClick(base.driver);
        Thread.sleep(4000);
    }


    @And("^User changes delivery address$")
    public void userChangesDeliveryAddress() {
        base.verifyAddress = getVerVerifyAddress();
        base.verifyAddress.clickUpdatebtn(base.driver);
        base.changeAddress = getChangeAddress();
        base.changeAddress.clearDeliveryAddressFieldsFirst(base.driver);
        base.changeAddress.enterNewDeliveryAddress();
        System.out.println();
    }
}
