package pageUIs;

public class CheckoutPUI {
    public static final String QUANTITY_TEXT_BOX = "xpath=//a[text()='%s']/parent::h2/parent::td/following-sibling::td[@class='product-cart-actions']/input";
    public static final String CART_ERROR_MESSAGE = "xpath=//li[@class='error-msg']//span";
    public static final String PRODUCT_QUANTITY_ERROR_MESSAGE = "xpath=//p[@class='item-msg error']";
    public static final String EMPTY_CART_LINK = "id=empty_cart_button";
    public static final String CART_EMPTY_MESSAGE = "xpath=//div[@class='page-title']/h1";
    public static final String UPDATE_QUANTITY_BUTTON = "xpath=//a[text()='%s']/parent::h2/parent::td/following-sibling::td[@class='product-cart-actions']/button";
    public static final String ADD_TO_CART_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
    public static final String DISCOUNT_CODE_TEXT_BOX = "id=coupon_code";
    public static final String APPLY_DISCOUNT_CODE_LINK = "xpath=//button[@title='Apply']";
    public static final String APPLY_COUPON_CODE_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
    public static final String DISCOUNT_VALUE = "xpath=//table[@id='shopping-cart-totals-table']//td[contains(text(),'Discount (%s)')]/following-sibling::td/span";
    public static final String GRAND_TOTAL_VALUE = "xpath=//strong[text()='Grand Total']/parent::td/following-sibling::td//span";
}
