package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPUI;

public class RegisterPO extends BasePage {
    WebDriver driver;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPUI.FIRST_NAME_TEXTBOX,firstName);
    }
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPUI.LAST_NAME_TEXTBOX,lastName);

    }
    public void enterToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver,RegisterPUI.EMAIL_ADDRESS_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,RegisterPUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPUI.REGISTER_BUTTON);
    }

    public MyAccountPO clickContinueInAlertPopup() {
        acceptAlert(driver);
        return PageGenerator.getMyAccountPage(driver);
    }
}
