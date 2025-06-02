package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_MyAccountPUI;

public class FE_MyAccountPO extends BasePage {
    WebDriver driver;

    public FE_MyAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(driver, FE_MyAccountPUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToAccountInformationLink() {
        waitForElementClickable(driver, FE_MyAccountPUI.ACCOUNT_INFO_LINK);
        clickToElement(driver, FE_MyAccountPUI.ACCOUNT_INFO_LINK);
    }

    public String getUserFistName() {
        waitForElementVisible(driver, FE_MyAccountPUI.FIRST_NAME_TEXT_INPUT);
        return getElementAttribute(driver, FE_MyAccountPUI.FIRST_NAME_TEXT_INPUT,"value");
    }

    public String getUserLastName() {
        waitForElementVisible(driver, FE_MyAccountPUI.LAST_NAME_TEXT_INPUT);
        return getElementAttribute(driver, FE_MyAccountPUI.LAST_NAME_TEXT_INPUT,"value");
    }

    public String getUserEmailAddress() {
        waitForElementVisible(driver, FE_MyAccountPUI.EMAIL_ADDRESS_TEXT_INPUT);
        return getElementAttribute(driver, FE_MyAccountPUI.EMAIL_ADDRESS_TEXT_INPUT,"value");
    }

    public String getDashboardWelcomeText() {
        waitForElementVisible(driver, FE_MyAccountPUI.DASHBOARD_WELCOME_TEXT);
        return getElementText(driver, FE_MyAccountPUI.DASHBOARD_WELCOME_TEXT);
    }
}
