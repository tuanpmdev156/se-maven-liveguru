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
        clearElementText(driver, CheckoutPUI.QUANTITY_TEXT_BOX,productName);
        waitForElementClickable(driver, CheckoutPUI.QUANTITY_TEXT_BOX,productName);
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


    public String getAddToCartSuccessMessage() {
        waitForElementVisible(driver, CheckoutPUI.ADD_TO_CART_SUCCESS_MESSAGE);
        return getElementText(driver,CheckoutPUI.ADD_TO_CART_SUCCESS_MESSAGE);
    }

    public void enterToDiscountCodeTextbox(String discountCode) {
        clearElementText(driver,CheckoutPUI.DISCOUNT_CODE_TEXT_BOX);
        waitForElementClickable(driver,CheckoutPUI.DISCOUNT_CODE_TEXT_BOX);
        sendKeyToElement(driver,CheckoutPUI.DISCOUNT_CODE_TEXT_BOX,discountCode);
    }

    public void clickToApplyLink() {
        waitForElementClickable(driver,CheckoutPUI.APPLY_DISCOUNT_CODE_LINK);
        clickToElement(driver,CheckoutPUI.APPLY_DISCOUNT_CODE_LINK);
    }

    public String getAppliedCouponCodeSuccessMessage() {
        sleepInSeconds(2);
        waitForElementVisible(driver,CheckoutPUI.APPLY_COUPON_CODE_SUCCESS_MESSAGE);
        return getElementText(driver,CheckoutPUI.APPLY_COUPON_CODE_SUCCESS_MESSAGE);
    }

    public String getDiscountValue(String discountCode) {
        waitForElementVisible(driver,CheckoutPUI.DISCOUNT_VALUE,discountCode);
        return getElementText(driver,CheckoutPUI.DISCOUNT_VALUE,discountCode);
    }

    public String getGrandTotalValue() {
        waitForElementVisible(driver,CheckoutPUI.GRAND_TOTAL_VALUE);
        return getElementText(driver,CheckoutPUI.GRAND_TOTAL_VALUE  );
    }
}
