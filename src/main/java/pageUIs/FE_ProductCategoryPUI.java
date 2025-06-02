package pageUIs;

public class FE_ProductCategoryPUI {
    public static final String PRODUCT_PRICE = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//span[@class='price']";
    public static final String PRODUCT_NAME = "xpath=//a[text()='%s']";
    public static final String ADD_TO_CART_BUTTON = "xpath=//a[text()='%s']/parent::h2/following-sibling::div/button[@title='Add to Cart']";
    public static final String ADD_TO_COMPARE_LINK = "xpath=//a[text()='%s']/parent::h2/parent::div//div[@class='actions']//a[text()='Add to Compare']";
    public static final String ADD_TO_COMPARE_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
    public static final String ADD_TO_WISHLIST_LINK = "xpath=//a[text()='%s']/parent::h2/parent::div//div[@class='actions']//a[text()='Add to Wishlist']";
}
