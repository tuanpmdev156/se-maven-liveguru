package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPUI;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver,LoginPUI.EMAIL_ADDRESS_TEXTBOX,emailAddress);
    }

    public void enterToLastNameTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
    }

    public MyAccountPO confirmAlertPopup() {
        acceptAlert(driver);
        return PageGenerator.getMyAccountPage(driver);
    }
}
