package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_ProductDetailPUI;

public class FE_ProductDetailPO extends BasePage {
    WebDriver driver;

    public FE_ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getDetailPrice() {
        waitForElementVisible(driver, FE_ProductDetailPUI.PRODUCT_PRICE);
        return getElementText(driver, FE_ProductDetailPUI.PRODUCT_PRICE);
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, FE_ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, FE_ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
    }
}
