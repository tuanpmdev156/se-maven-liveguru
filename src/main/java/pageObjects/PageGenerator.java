package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }
}
