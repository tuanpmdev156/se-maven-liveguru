package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.AdvanceSearchDetailPUI;

import java.util.List;

public class AdvancedSearchDetailPO extends BasePage {
    WebDriver driver;

    public AdvancedSearchDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchPriceRangeDisplayed(String priceFrom, String priceTo) {
        waitForElementVisible(driver,AdvanceSearchDetailPUI.SEARCH_PRODUCT_PRICE_RANGE,priceFrom,priceTo);
        return isElementDisplayed(driver,AdvanceSearchDetailPUI.SEARCH_PRODUCT_PRICE_RANGE,priceFrom,priceTo);
    }

//    public boolean areProductsDisplayedInSearchRange(String priceFrom, String priceTo){
//        // Get product price in search range
//        List<WebElement> productPriceList = getListElement(driver, AdvanceSearchDetailPUI.SEARCH_PRODUCT_PRICE_LIST);
//        for (WebElement productPrice: productPriceList){
//            System.out.println("productPrice.getText(): " + productPrice.getText());
//            int productPriceValue = (int) Double.parseDouble(productPrice.getText().replace("$", ""));
//            // Verify product price in search range
//            return Integer.parseInt(priceFrom) <= productPriceValue && productPriceValue <= Integer.parseInt(priceTo);
//        }
//        return false;
//    }

    public boolean areProductsDisplayedInSearchRange(String priceFrom, String priceTo) {
        List<WebElement> productPriceList = getListElement(driver, AdvanceSearchDetailPUI.SEARCH_PRODUCT_PRICE_LIST);
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