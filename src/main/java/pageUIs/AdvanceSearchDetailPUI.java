package pageUIs;

public class AdvanceSearchDetailPUI {
    public static final String SEARCH_PRODUCT_PRICE_RANGE = "xpath=//div[@class='advanced-search-summary']//li[contains(text(),'%s') and contains(text(),'%s')]";
    public static final String SEARCH_PRODUCT_PRICE_LIST = "xpath=//span[@class='price' and not(contains(@id,'old-price'))]";
}
