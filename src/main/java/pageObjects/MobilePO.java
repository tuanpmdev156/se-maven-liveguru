package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import pageUIs.MobileDetailPUI;
import pageUIs.MobilePUI;

public class MobilePO extends BasePage {
    WebDriver driver;

    public MobilePO(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceByProductName(String productName) {
        waitForElementVisible(driver, MobilePUI.PRODUCT_PRICE,productName);
        return getElementText(driver, MobilePUI.PRODUCT_PRICE,productName);
    }

    public MobileDetailPO openProductDetailByName(String productName) {
        waitForElementClickable(driver,MobilePUI.PRODUCT_NAME,productName);
        clickToElement(driver,MobilePUI.PRODUCT_NAME,productName);
        return PageGenerator.getMobileDetailPage(driver);
    }

    public CheckoutPO addToCartByProductName(String productName) {
        waitForElementClickable(driver,MobilePUI.ADD_TO_CART_BUTTON,productName);
        clickToElement(driver,MobilePUI.ADD_TO_CART_BUTTON,productName);
        return PageGenerator.getCheckoutPage(driver);
    }

    public void addToCompareByProductName(String productName) {
        waitForElementClickable(driver, MobilePUI.ADD_TO_COMPARE_BUTTON,productName);
        clickToElement(driver,MobilePUI.ADD_TO_COMPARE_BUTTON,productName);
    }

    public String getAddToCompareSuccessMessage() {
        waitForElementVisible(driver, MobilePUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
        return getElementText(driver,MobilePUI.ADD_TO_COMPARE_SUCCESS_MESSAGE);
    }

    public void clickToCompareButton() {
        waitForElementClickable(driver, MobileDetailPUI.COMPARE_PRODUCT_BTN);
        clickToElement(driver, MobileDetailPUI.COMPARE_PRODUCT_BTN);
    }
}
