package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyWishlistPUI;

public class MyWishlistPO extends BasePage {
    WebDriver driver;

    public MyWishlistPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getAddToWishlistSuccessMsg() {
        waitForElementVisible(driver, MyWishlistPUI.ADDED_TO_WISHLIST_SUCCESS_MSG);
        return getElementText(driver, MyWishlistPUI.ADDED_TO_WISHLIST_SUCCESS_MSG);
    }

    public void clickToShareWishlistBtn() {
        waitForElementClickable(driver, MyWishlistPUI.SHARE_WISHLIST_BTN);
        clickToElement(driver, MyWishlistPUI.SHARE_WISHLIST_BTN);
    }

    public String getSharingSuccessMsg() {
        waitForElementVisible(driver, MyWishlistPUI.SHARED_SUCCESS_MSG);
        return getElementText(driver, MyWishlistPUI.SHARED_SUCCESS_MSG);
    }

    public boolean isProductDisplayedInWishlist(String productName) {
        waitForElementVisible(driver, MyWishlistPUI.PRODUCT_NAME_IN_WISHLIST,productName);
        return isElementDisplayed(driver, MyWishlistPUI.PRODUCT_NAME_IN_WISHLIST,productName);
    }
}
