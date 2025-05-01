package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CompareProductPUI;

public class CompareProductPO extends BasePage {
    WebDriver driver;

    public CompareProductPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHeadingDisplayed() {
        waitForElementVisible(driver, CompareProductPUI.COMPARE_PRODUCT_WINDOW_HEADING);
        return isElementDisplayed(driver,CompareProductPUI.COMPARE_PRODUCT_WINDOW_HEADING);
    }

    public boolean isProductNameDisplayed(String productName) {
        waitForElementVisible(driver, CompareProductPUI.COMPARE_PRODUCT_NAME,productName);
        return isElementDisplayed(driver, CompareProductPUI.COMPARE_PRODUCT_NAME,productName);
    }

    public boolean isProductPriceDisplayed(String productName, String productPrice) {
        waitForElementVisible(driver, CompareProductPUI.COMPARE_PRODUCT_PRICE,productName,productPrice);
        return isElementDisplayed(driver, CompareProductPUI.COMPARE_PRODUCT_PRICE,productName,productPrice);
    }

    public boolean isProductImageDisplayed(String productName, String productImage) {
        waitForElementVisible(driver, CompareProductPUI.COMPARE_PRODUCT_IMAGE,productName,productImage);
        return isElementDisplayed(driver, CompareProductPUI.COMPARE_PRODUCT_IMAGE,productName,productImage);
    }

    public boolean isProductSKUDisplayed(String productName, String productSKU) {
        waitForElementVisible(driver, CompareProductPUI.COMPARE_PRODUCT_SKU,productName,productSKU);
        return isElementDisplayed(driver, CompareProductPUI.COMPARE_PRODUCT_SKU,productName,productSKU);
    }

    public void clickToCloseWindowButton() {
        waitForElementClickable(driver, CompareProductPUI.COMPARE_PRODUCT_CLOSE_WINDOW_BTN);
        clickToElement(driver,CompareProductPUI.COMPARE_PRODUCT_CLOSE_WINDOW_BTN);
    }
}
