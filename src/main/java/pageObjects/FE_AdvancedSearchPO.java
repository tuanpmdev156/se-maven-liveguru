package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.FE_AdvancedSearchPUI;

public class FE_AdvancedSearchPO extends BasePage {
    WebDriver driver;

    public FE_AdvancedSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToSearchPriceFromTextbox(String priceFrom) {
        waitForElementVisible(driver, FE_AdvancedSearchPUI.SEARCH_PRICE_FROM_TEXTBOX);
        sendKeyToElement(driver, FE_AdvancedSearchPUI.SEARCH_PRICE_FROM_TEXTBOX,priceFrom);
    }

    public void enterToSearchPriceToTextbox(String priceTo) {
        waitForElementVisible(driver, FE_AdvancedSearchPUI.SEARCH_PRICE_TO_TEXTBOX);
        sendKeyToElement(driver, FE_AdvancedSearchPUI.SEARCH_PRICE_TO_TEXTBOX,priceTo);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, FE_AdvancedSearchPUI.SEARCH_BUTTON);
        clickToElement(driver, FE_AdvancedSearchPUI.SEARCH_BUTTON);
    }
}
