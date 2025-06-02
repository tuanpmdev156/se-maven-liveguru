package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_ShareWishListPUI;

public class FE_ShareWishlistPO extends BasePage {
    WebDriver driver;

    public FE_ShareWishlistPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToShareEmailTextbox(String emailAddress) {
        waitForElementClickable(driver, FE_ShareWishListPUI.SHARE_EMAIL_TEXTBOX,emailAddress);
        sendKeyToElement(driver, FE_ShareWishListPUI.SHARE_EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToShareMessageTextbox(String message) {
        waitForElementClickable(driver, FE_ShareWishListPUI.SHARE_MESSAGE_TEXTBOX,message);
        sendKeyToElement(driver, FE_ShareWishListPUI.SHARE_MESSAGE_TEXTBOX,message);
    }

    public void clickToShareWishlistBtn() {
        waitForElementClickable(driver, FE_ShareWishListPUI.SHARE_WISHLIST_BTN);
        clickToElement(driver, FE_ShareWishListPUI.SHARE_WISHLIST_BTN);
    }
}
