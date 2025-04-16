package pageObjects;

import common.BasePage;
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

    public void clickToAccountInformationLink() {
        waitForElementClickable(driver, MyAccountPUI.ACCOUNT_INFO_LINK);
        clickToElement(driver,MyAccountPUI.ACCOUNT_INFO_LINK);
    }

    public String getUserFistName() {
        waitForElementVisible(driver, MyAccountPUI.FIRST_NAME_TEXT_INPUT);
        return getElementAttribute(driver, MyAccountPUI.FIRST_NAME_TEXT_INPUT,"value");
    }

    public String getUserLastName() {
        waitForElementVisible(driver, MyAccountPUI.LAST_NAME_TEXT_INPUT);
        return getElementAttribute(driver, MyAccountPUI.LAST_NAME_TEXT_INPUT,"value");
    }

    public String getUserEmailAddress() {
        waitForElementVisible(driver, MyAccountPUI.EMAIL_ADDRESS_TEXT_INPUT);
        return getElementAttribute(driver, MyAccountPUI.EMAIL_ADDRESS_TEXT_INPUT,"value");
    }


}
