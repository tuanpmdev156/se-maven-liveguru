package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MobileDetailPUI;

public class MobileDetailPO extends BasePage {
    WebDriver driver;

    public MobileDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getDetailPrice() {
        waitForElementVisible(driver, MobileDetailPUI.PRODUCT_PRICE);
        return getElementText(driver, MobileDetailPUI.PRODUCT_PRICE);
    }
}
