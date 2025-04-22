package pageUIs;

public class MobilePUI {
    public static final String PRODUCT_PRICE = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//span[@class='price']";
    public static final String PRODUCT_NAME = "xpath=//a[text()='%s']";
    public static final String ADD_TO_CART_BUTTON = "xpath=//a[text()='%s']/parent::h2/following-sibling::div/button[@title='Add to Cart']";
}
