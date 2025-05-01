package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailPUI;
import pageUIs.ProductCategoryPUI;

public class ProductCategoryPO extends BasePage {
    WebDriver driver;

    public ProductCategoryPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceByProductName(String productName) {
        waitForElementVisible(driver, ProductCategoryPUI.PRODUCT_PRICE,productName);
        return getElementText(driver, ProductCategoryPUI.PRODUCT_PRICE,productName);
    }

    public ProductDetailPO openProductDetailByName(String productName) {
        waitForElementClickable(driver, ProductCategoryPUI.PRODUCT_NAME,productName);
        clickToElement(driver, ProductCategoryPUI.PRODUCT_NAME,productName);
        return PageGenerator.getMobileDetailPage(driver);
    }

    public CheckoutPO addToCartByProductName(String productName) {
        waitForElementClickable(driver, ProductCategoryPUI.ADD_TO_CART_BUTTON,productName);
        clickToElement(driver, ProductCategoryPUI.ADD_TO_CART_BUTTON,productName);
        return PageGenerator.getCheckoutPage(driver);
    }

    public void addToCompareByProductName(String productName) {
        waitForElementClickable(driver, ProductCategoryPUI.ADD_TO_COMPARE_LINK,productName);
        clickToElement(driver, ProductCategoryPUI.ADD_TO_COMPARE_LINK,productName);
    }

    public String getAddToCompareSuccessMessage() {
        waitForElementVisible(driver, ProductCategoryPUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
        return getElementText(driver, ProductCategoryPUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
    }

    public void clickToCompareButton() {
        waitForElementClickable(driver, ProductDetailPUI.COMPARE_PRODUCT_BTN);
        clickToElement(driver, ProductDetailPUI.COMPARE_PRODUCT_BTN);
    }

    public void addToWishlistByProductName(String productName) {
        waitForElementClickable(driver, ProductCategoryPUI.ADD_TO_WISHLIST_LINK,productName);
        clickToElement(driver, ProductCategoryPUI.ADD_TO_WISHLIST_LINK,productName);
    }
}
