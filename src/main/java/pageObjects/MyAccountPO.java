package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPUI;

public class MyAccountPO extends BasePage {
    WebDriver driver;

    public MyAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(driver,MyAccountPUI.REGISTER_SUCCESS_MESSAGE);
    }
}
