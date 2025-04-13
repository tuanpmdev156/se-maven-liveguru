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
}
