package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static RegisterPO getRegisterPage(WebDriver driver) {
        return new RegisterPO(driver);
    }

    public static HomePO getHomePage(WebDriver driver) {
        return new HomePO(driver);
    }

    public static MyAccountPO getMyAccountPage(WebDriver driver) {
        return new MyAccountPO(driver);
    }
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static MobilePO getMobilePage(WebDriver driver) {
        return new MobilePO(driver);
    }
    public static MobileDetailPO getMobileDetailPage(WebDriver driver) {
        return new MobileDetailPO(driver);
    }
    public static CheckoutPO getCheckoutPage(WebDriver driver) {
        return new CheckoutPO(driver);
    }

}
