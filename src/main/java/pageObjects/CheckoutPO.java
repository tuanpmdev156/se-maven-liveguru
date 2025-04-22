package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CheckoutPUI;

public class CheckoutPO extends BasePage {
    WebDriver driver;

    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToQuantityTextbox(String productName, String quantity) {
        waitForElementVisible(driver, CheckoutPUI.QUANTITY_TEXT_BOX,productName);
        sendKeyToElement(driver, CheckoutPUI.QUANTITY_TEXT_BOX,quantity,productName);
    }

    public void clickToUpdateQuantityButton(String productName) {
        waitForElementClickable(driver, CheckoutPUI.UPDATE_QUANTITY_BUTTON,productName);
        clickToElement(driver, CheckoutPUI.UPDATE_QUANTITY_BUTTON,productName);
    }

    public boolean isCartErrorMessageDisplayed() {
        waitForElementVisible(driver, CheckoutPUI.CART_ERROR_MESSAGE);
        return isElementDisplayed(driver, CheckoutPUI.CART_ERROR_MESSAGE);
    }

    public boolean isQuantityErrorMessageDisplayed() {
        waitForElementVisible(driver, CheckoutPUI.PRODUCT_QUANTITY_ERROR_MESSAGE);
        return isElementDisplayed(driver, CheckoutPUI.PRODUCT_QUANTITY_ERROR_MESSAGE);
    }

    public void clickToEmptyCartLink() {
        waitForElementClickable(driver, CheckoutPUI.EMPTY_CART_LINK);
        clickToElement(driver, CheckoutPUI.EMPTY_CART_LINK);
    }

    public String getCartEmptyMessage() {
        waitForElementVisible(driver, CheckoutPUI.CART_EMPTY_MESSAGE);
        return getElementText(driver, CheckoutPUI.CART_EMPTY_MESSAGE).toUpperCase();
    }


}
