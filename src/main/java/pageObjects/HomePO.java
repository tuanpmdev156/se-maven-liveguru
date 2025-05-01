package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePUI;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAccountMenu() {
        waitForElementClickable(driver, HomePUI.ACCOUNT_MENU_BUTTON);
        clickToElement(driver,HomePUI.ACCOUNT_MENU_BUTTON);
    }

    public RegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, HomePUI.REGISTER_LINK);
        clickToElement(driver,HomePUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    public LoginPO clickToLoginLink() {
        waitForElementClickable(driver, HomePUI.LOGIN_LINK);
        clickToElement(driver,HomePUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }

    public ProductCategoryPO clickToMobileLink() {
        waitForElementClickable(driver, HomePUI.MOBILE_LINK);
        clickToElement(driver,HomePUI.MOBILE_LINK);
        return PageGenerator.getMobilePage(driver);
    }

    public ProductCategoryPO clickToTVLink() {
        waitForElementClickable(driver, HomePUI.TV_LINK);
        clickToElement(driver,HomePUI.TV_LINK);
        return PageGenerator.getMobilePage(driver);
    }
}
