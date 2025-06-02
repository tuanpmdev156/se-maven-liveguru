package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_RegisterPUI;

public class FE_RegisterPO extends BasePage {
    WebDriver driver;

    public FE_RegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, FE_RegisterPUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, FE_RegisterPUI.FIRST_NAME_TEXTBOX,firstName);
    }
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, FE_RegisterPUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, FE_RegisterPUI.LAST_NAME_TEXTBOX,lastName);

    }
    public void enterToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, FE_RegisterPUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, FE_RegisterPUI.EMAIL_ADDRESS_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, FE_RegisterPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, FE_RegisterPUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, FE_RegisterPUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, FE_RegisterPUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, FE_RegisterPUI.REGISTER_BUTTON);
        clickToElement(driver, FE_RegisterPUI.REGISTER_BUTTON);
    }

    public FE_MyAccountPO confirmAlertPopup() {
        acceptAlert(driver);
        return PageGenerator.getMyAccountPage(driver);
    }
}
