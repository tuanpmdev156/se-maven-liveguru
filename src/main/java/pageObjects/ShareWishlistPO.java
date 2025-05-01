package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ShareWishListPUI;

public class ShareWishlistPO extends BasePage {
    WebDriver driver;

    public ShareWishlistPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToShareEmailTextbox(String emailAddress) {
        waitForElementClickable(driver, ShareWishListPUI.SHARE_EMAIL_TEXTBOX,emailAddress);
        sendKeyToElement(driver, ShareWishListPUI.SHARE_EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToShareMessageTextbox(String message) {
        waitForElementClickable(driver, ShareWishListPUI.SHARE_MESSAGE_TEXTBOX,message);
        sendKeyToElement(driver, ShareWishListPUI.SHARE_MESSAGE_TEXTBOX,message);
    }

    public void clickToShareWishlistBtn() {
        waitForElementClickable(driver, ShareWishListPUI.SHARE_WISHLIST_BTN);
        clickToElement(driver, ShareWishListPUI.SHARE_WISHLIST_BTN);
    }
}
