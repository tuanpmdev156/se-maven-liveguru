package pageUIs;

public class CheckoutPUI {
    public static final String QUANTITY_TEXT_BOX = "xpath=//a[text()='%s']/parent::h2/parent::td/following-sibling::td[@class='product-cart-actions']/input";
    public static final String CART_ERROR_MESSAGE = "xpath=//li[@class='error-msg']//span";
    public static final String PRODUCT_QUANTITY_ERROR_MESSAGE = "xpath=//p[@class='item-msg error']";
    public static final String EMPTY_CART_LINK = "id=empty_cart_button";
    public static final String CART_EMPTY_MESSAGE = "xpath=//div[@class='page-title']/h1";
    public static final String UPDATE_QUANTITY_BUTTON = "xpath=//a[text()='%s']/parent::h2/parent::td/following-sibling::td[@class='product-cart-actions']/button";
}
