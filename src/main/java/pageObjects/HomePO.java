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
}
