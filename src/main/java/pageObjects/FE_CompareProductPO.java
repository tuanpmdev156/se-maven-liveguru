package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_CompareProductPUI;

public class FE_CompareProductPO extends BasePage {
    WebDriver driver;

    public FE_CompareProductPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHeadingDisplayed() {
        waitForElementVisible(driver, FE_CompareProductPUI.COMPARE_PRODUCT_WINDOW_HEADING);
        return isElementDisplayed(driver, FE_CompareProductPUI.COMPARE_PRODUCT_WINDOW_HEADING);
    }

    public boolean isProductNameDisplayed(String productName) {
        waitForElementVisible(driver, FE_CompareProductPUI.COMPARE_PRODUCT_NAME,productName);
        return isElementDisplayed(driver, FE_CompareProductPUI.COMPARE_PRODUCT_NAME,productName);
    }

    public boolean isProductPriceDisplayed(String productName, String productPrice) {
        waitForElementVisible(driver, FE_CompareProductPUI.COMPARE_PRODUCT_PRICE,productName,productPrice);
        return isElementDisplayed(driver, FE_CompareProductPUI.COMPARE_PRODUCT_PRICE,productName,productPrice);
    }

    public boolean isProductImageDisplayed(String productName, String productImage) {
        waitForElementVisible(driver, FE_CompareProductPUI.COMPARE_PRODUCT_IMAGE,productName,productImage);
        return isElementDisplayed(driver, FE_CompareProductPUI.COMPARE_PRODUCT_IMAGE,productName,productImage);
    }

    public boolean isProductSKUDisplayed(String productName, String productSKU) {
        waitForElementVisible(driver, FE_CompareProductPUI.COMPARE_PRODUCT_SKU,productName,productSKU);
        return isElementDisplayed(driver, FE_CompareProductPUI.COMPARE_PRODUCT_SKU,productName,productSKU);
    }

    public void clickToCloseWindowButton() {
        waitForElementClickable(driver, FE_CompareProductPUI.COMPARE_PRODUCT_CLOSE_WINDOW_BTN);
        clickToElement(driver, FE_CompareProductPUI.COMPARE_PRODUCT_CLOSE_WINDOW_BTN);
    }
}
