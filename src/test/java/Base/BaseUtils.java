package Base;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtils {

    public WebDriver driver;
    public String baseURL;

    public CheckoutProcessAlertPage checkoutProcess;
    public VerifyAddressPage verifyAddress;
    public ChangeAddressPage changeAddress;
    public TermsOfServicePage termsOfService;
    public PayByCheckPage payByCheck;
    public ConfirmOrderPage confirmOrder;
    public BackToOrdersPage backToOrders;
    public OrderHistoryPage orderHistory;

}
