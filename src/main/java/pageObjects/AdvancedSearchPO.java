package pageObjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AdvancedSearchPUI;

public class AdvancedSearchPO extends BasePage {
    WebDriver driver;

    public AdvancedSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToSearchPriceFromTextbox(String priceFrom) {
        waitForElementVisible(driver, AdvancedSearchPUI.SEARCH_PRICE_FROM_TEXTBOX);
        sendKeyToElement(driver, AdvancedSearchPUI.SEARCH_PRICE_FROM_TEXTBOX,priceFrom);
    }

    public void enterToSearchPriceToTextbox(String priceTo) {
        waitForElementVisible(driver, AdvancedSearchPUI.SEARCH_PRICE_TO_TEXTBOX);
        sendKeyToElement(driver, AdvancedSearchPUI.SEARCH_PRICE_TO_TEXTBOX,priceTo);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver,AdvancedSearchPUI.SEARCH_BUTTON);
        clickToElement(driver,AdvancedSearchPUI.SEARCH_BUTTON);
    }
}
