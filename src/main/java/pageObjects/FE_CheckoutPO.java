package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_CheckoutPUI;

public class FE_CheckoutPO extends BasePage {
    WebDriver driver;

    public FE_CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToQuantityTextbox(String productName, String quantity) {
        clearElementText(driver, FE_CheckoutPUI.QUANTITY_TEXT_BOX,productName);
        waitForElementClickable(driver, FE_CheckoutPUI.QUANTITY_TEXT_BOX,productName);
        sendKeyToElement(driver, FE_CheckoutPUI.QUANTITY_TEXT_BOX,quantity,productName);
    }

    public void clickToUpdateQuantityButton(String productName) {
        waitForElementClickable(driver, FE_CheckoutPUI.UPDATE_QUANTITY_BUTTON,productName);
        clickToElement(driver, FE_CheckoutPUI.UPDATE_QUANTITY_BUTTON,productName);
    }

    public boolean isCartErrorMessageDisplayed() {
        waitForElementVisible(driver, FE_CheckoutPUI.CART_ERROR_MESSAGE);
        return isElementDisplayed(driver, FE_CheckoutPUI.CART_ERROR_MESSAGE);
    }

    public boolean isQuantityErrorMessageDisplayed() {
        waitForElementVisible(driver, FE_CheckoutPUI.PRODUCT_QUANTITY_ERROR_MESSAGE);
        return isElementDisplayed(driver, FE_CheckoutPUI.PRODUCT_QUANTITY_ERROR_MESSAGE);
    }

    public void clickToEmptyCartLink() {
        waitForElementClickable(driver, FE_CheckoutPUI.EMPTY_CART_LINK);
        clickToElement(driver, FE_CheckoutPUI.EMPTY_CART_LINK);
    }

    public String getCartEmptyMessage() {
        waitForElementVisible(driver, FE_CheckoutPUI.CART_EMPTY_MESSAGE);
        return getElementText(driver, FE_CheckoutPUI.CART_EMPTY_MESSAGE).toUpperCase();
    }


    public String getAddToCartSuccessMessage() {
        waitForElementVisible(driver, FE_CheckoutPUI.ADD_TO_CART_SUCCESS_MESSAGE);
        return getElementText(driver, FE_CheckoutPUI.ADD_TO_CART_SUCCESS_MESSAGE);
    }

    public void enterToDiscountCodeTextbox(String discountCode) {
        clearElementText(driver, FE_CheckoutPUI.DISCOUNT_CODE_TEXT_BOX);
        waitForElementClickable(driver, FE_CheckoutPUI.DISCOUNT_CODE_TEXT_BOX);
        sendKeyToElement(driver, FE_CheckoutPUI.DISCOUNT_CODE_TEXT_BOX,discountCode);
    }

    public void clickToApplyLink() {
        waitForElementClickable(driver, FE_CheckoutPUI.APPLY_DISCOUNT_CODE_LINK);
        clickToElement(driver, FE_CheckoutPUI.APPLY_DISCOUNT_CODE_LINK);
    }

    public String getAppliedCouponCodeSuccessMessage() {
        sleepInSeconds(2);
        waitForElementVisible(driver, FE_CheckoutPUI.APPLY_COUPON_CODE_SUCCESS_MESSAGE);
        return getElementText(driver, FE_CheckoutPUI.APPLY_COUPON_CODE_SUCCESS_MESSAGE);
    }

    public String getDiscountValue(String discountCode) {
        waitForElementVisible(driver, FE_CheckoutPUI.DISCOUNT_VALUE,discountCode);
        return getElementText(driver, FE_CheckoutPUI.DISCOUNT_VALUE,discountCode);
    }

    public String getGrandTotalValue() {
        waitForElementVisible(driver, FE_CheckoutPUI.GRAND_TOTAL_VALUE);
        return getElementText(driver, FE_CheckoutPUI.GRAND_TOTAL_VALUE  );
    }
}
