package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.FE_AdvanceSearchDetailPUI;

import java.util.List;

public class FE_AdvancedSearchDetailPO extends BasePage {
    WebDriver driver;

    public FE_AdvancedSearchDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchPriceRangeDisplayed(String priceFrom, String priceTo) {
        waitForElementVisible(driver, FE_AdvanceSearchDetailPUI.SEARCH_PRODUCT_PRICE_RANGE,priceFrom,priceTo);
        return isElementDisplayed(driver, FE_AdvanceSearchDetailPUI.SEARCH_PRODUCT_PRICE_RANGE,priceFrom,priceTo);
    }

    public boolean areProductsDisplayedInSearchRange(String priceFrom, String priceTo) {
        List<WebElement> productPriceList = getListElement(driver, FE_AdvanceSearchDetailPUI.SEARCH_PRODUCT_PRICE_LIST);
        int from = Integer.parseInt(priceFrom);
        int to = Integer.parseInt(priceTo);

        for (WebElement productPrice : productPriceList) {
            String priceText = productPrice.getText().replace("$", "").replace(",", "").trim();
            int productPriceValue = (int) Double.parseDouble(priceText);
            // Return false if any product price does not match condition
            if (productPriceValue < from || productPriceValue > to) {
                return false;
            }
        }
        return true;
    }

}