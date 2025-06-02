package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_HomePUI;

public class FE_HomePO extends BasePage {
    WebDriver driver;

    public FE_HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAccountMenu() {
        waitForElementClickable(driver, FE_HomePUI.ACCOUNT_MENU_BUTTON);
        clickToElement(driver, FE_HomePUI.ACCOUNT_MENU_BUTTON);
    }

    public FE_RegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, FE_HomePUI.REGISTER_LINK);
        clickToElement(driver, FE_HomePUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    public FE_LoginPO clickToLoginLink() {
        waitForElementClickable(driver, FE_HomePUI.LOGIN_LINK);
        clickToElement(driver, FE_HomePUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }

    public FE_ProductCategoryPO clickToMobileLink() {
        waitForElementClickable(driver, FE_HomePUI.MOBILE_LINK);
        clickToElement(driver, FE_HomePUI.MOBILE_LINK);
        return PageGenerator.getMobilePage(driver);
    }

    public FE_ProductCategoryPO clickToTVLink() {
        waitForElementClickable(driver, FE_HomePUI.TV_LINK);
        clickToElement(driver, FE_HomePUI.TV_LINK);
        return PageGenerator.getMobilePage(driver);
    }

    public boolean isReviewSuccessMsgDisplayed(String message) {
        waitForElementVisible(driver, FE_HomePUI.REVIEW_SUCCESS_MSG,message);
        return isElementDisplayed(driver, FE_HomePUI.REVIEW_SUCCESS_MSG,message);
    }

    public void clickToAdvancedSearchLink() {
        waitForElementClickable(driver, FE_HomePUI.ADVANCED_SEARCH_LINK);
        clickToElement(driver, FE_HomePUI.ADVANCED_SEARCH_LINK);
    }
}
