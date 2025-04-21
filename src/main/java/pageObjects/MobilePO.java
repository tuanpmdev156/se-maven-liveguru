package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
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
}
