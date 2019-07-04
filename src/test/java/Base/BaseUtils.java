package Base;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtils {

    public WebDriverWait wait;
    public WebDriver driver;
    public String baseURL;

    public ItemDetailPage itemDetailPage;
    public CheckoutProcessAlertPage checkoutProcess;
    public VerifyAddressPage verifyAddress;
    public ChangeAddressPage changeAddress;


}
