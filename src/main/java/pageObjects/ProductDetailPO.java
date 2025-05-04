package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailPUI;

public class ProductDetailPO extends BasePage {
    WebDriver driver;

    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getDetailPrice() {
        waitForElementVisible(driver, ProductDetailPUI.PRODUCT_PRICE);
        return getElementText(driver, ProductDetailPUI.PRODUCT_PRICE);
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
    }
}
