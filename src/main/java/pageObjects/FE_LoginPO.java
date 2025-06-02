package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_LoginPUI;

public class FE_LoginPO extends BasePage {
    WebDriver driver;

    public FE_LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String emailAddress) {
        waitForElementVisible(driver, FE_LoginPUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, FE_LoginPUI.EMAIL_ADDRESS_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, FE_LoginPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, FE_LoginPUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, FE_LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, FE_LoginPUI.LOGIN_BUTTON);
    }

    public FE_MyAccountPO confirmAlertPopup() {
        acceptAlert(driver);
        return PageGenerator.getMyAccountPage(driver);
    }
}
