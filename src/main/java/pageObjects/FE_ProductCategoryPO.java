package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_ProductDetailPUI;
import pageUIs.FE_ProductCategoryPUI;

public class FE_ProductCategoryPO extends BasePage {
    WebDriver driver;

    public FE_ProductCategoryPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceByProductName(String productName) {
        waitForElementVisible(driver, FE_ProductCategoryPUI.PRODUCT_PRICE,productName);
        return getElementText(driver, FE_ProductCategoryPUI.PRODUCT_PRICE,productName);
    }

    public FE_ProductDetailPO openDetailProductByName(String productName) {
        waitForElementClickable(driver, FE_ProductCategoryPUI.PRODUCT_NAME,productName);
        clickToElement(driver, FE_ProductCategoryPUI.PRODUCT_NAME,productName);
        return PageGenerator.getProductDetailPage(driver);
    }

    public FE_CheckoutPO addToCartByProductName(String productName) {
        waitForElementClickable(driver, FE_ProductCategoryPUI.ADD_TO_CART_BUTTON,productName);
        clickToElement(driver, FE_ProductCategoryPUI.ADD_TO_CART_BUTTON,productName);
        return PageGenerator.getCheckoutPage(driver);
    }

    public void addToCompareByProductName(String productName) {
        waitForElementClickable(driver, FE_ProductCategoryPUI.ADD_TO_COMPARE_LINK,productName);
        clickToElement(driver, FE_ProductCategoryPUI.ADD_TO_COMPARE_LINK,productName);
    }

    public String getAddToCompareSuccessMessage() {
        waitForElementVisible(driver, FE_ProductCategoryPUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
        return getElementText(driver, FE_ProductCategoryPUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
    }

    public void clickToCompareButton() {
        waitForElementClickable(driver, FE_ProductDetailPUI.COMPARE_PRODUCT_BTN);
        clickToElement(driver, FE_ProductDetailPUI.COMPARE_PRODUCT_BTN);
    }

    public void addToWishlistByProductName(String productName) {
        waitForElementClickable(driver, FE_ProductCategoryPUI.ADD_TO_WISHLIST_LINK,productName);
        clickToElement(driver, FE_ProductCategoryPUI.ADD_TO_WISHLIST_LINK,productName);
    }
}
