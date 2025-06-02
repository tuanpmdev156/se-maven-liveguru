package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_MyWishlistPUI;

public class FE_MyWishlistPO extends BasePage {
    WebDriver driver;

    public FE_MyWishlistPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getAddToWishlistSuccessMsg() {
        waitForElementVisible(driver, FE_MyWishlistPUI.ADDED_TO_WISHLIST_SUCCESS_MSG);
        return getElementText(driver, FE_MyWishlistPUI.ADDED_TO_WISHLIST_SUCCESS_MSG);
    }

    public void clickToShareWishlistBtn() {
        waitForElementClickable(driver, FE_MyWishlistPUI.SHARE_WISHLIST_BTN);
        clickToElement(driver, FE_MyWishlistPUI.SHARE_WISHLIST_BTN);
    }

    public String getSharingSuccessMsg() {
        waitForElementVisible(driver, FE_MyWishlistPUI.SHARED_SUCCESS_MSG);
        return getElementText(driver, FE_MyWishlistPUI.SHARED_SUCCESS_MSG);
    }

    public boolean isProductDisplayedInWishlist(String productName) {
        waitForElementVisible(driver, FE_MyWishlistPUI.PRODUCT_NAME_IN_WISHLIST,productName);
        return isElementDisplayed(driver, FE_MyWishlistPUI.PRODUCT_NAME_IN_WISHLIST,productName);
    }
}
