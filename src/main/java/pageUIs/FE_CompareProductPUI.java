package pageUIs;

public class FE_CompareProductPUI {
    public static final String COMPARE_PRODUCT_WINDOW_HEADING = "xpath=//h1[text()='Compare Products']";
    public static final String COMPARE_PRODUCT_NAME = "xpath=//h2[@class='product-name']/a[text()='%s']";
    public static final String COMPARE_PRODUCT_PRICE = "xpath=//h2[@class='product-name']/a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[text()='%s']";
    public static final String COMPARE_PRODUCT_IMAGE = "xpath=//h2[@class='product-name']/a[text()='%s']/parent::h2/preceding-sibling::a[@class='product-image']/img[contains(@src,'%s')]";
    public static final String COMPARE_PRODUCT_SKU = "xpath=//h2[@class='product-name']/a[text()='%s']/ancestor::table//div[contains(text(),'%s')]";
    public static final String COMPARE_PRODUCT_CLOSE_WINDOW_BTN = "xpath=//button[@title='Close Window']";
}
