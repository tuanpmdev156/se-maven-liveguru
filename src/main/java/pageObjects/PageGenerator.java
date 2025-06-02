package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static FE_RegisterPO getRegisterPage(WebDriver driver) {
        return new FE_RegisterPO(driver);
    }
    public static FE_HomePO getHomePage(WebDriver driver) {
        return new FE_HomePO(driver);
    }
    public static FE_MyAccountPO getMyAccountPage(WebDriver driver) {
        return new FE_MyAccountPO(driver);
    }
    public static FE_LoginPO getLoginPage(WebDriver driver) {
        return new FE_LoginPO(driver);
    }
    public static FE_ProductCategoryPO getMobilePage(WebDriver driver) {
        return new FE_ProductCategoryPO(driver);
    }
    public static FE_ProductDetailPO getProductDetailPage(WebDriver driver) {
        return new FE_ProductDetailPO(driver);
    }
    public static FE_CheckoutPO getCheckoutPage(WebDriver driver) {
        return new FE_CheckoutPO(driver);
    }
    public static FE_CompareProductPO getCompareProductPage(WebDriver driver) {
        return new FE_CompareProductPO(driver);
    }
    public static FE_MyWishlistPO getMyWishlistPage(WebDriver driver) {
        return new FE_MyWishlistPO(driver);
    }
    public static FE_ShareWishlistPO getShareWishlistPage(WebDriver driver) {
        return new FE_ShareWishlistPO(driver);
    }
    public static FE_ProductReviewPO getProductReviewPage(WebDriver driver) {
        return new FE_ProductReviewPO(driver);
    }
    public static FE_AdvancedSearchPO getAdvancedSearchPage(WebDriver driver) {
        return new FE_AdvancedSearchPO(driver);
    }
    public static FE_AdvancedSearchDetailPO getAdvancedSearchDetailPage(WebDriver driver) {
        return new FE_AdvancedSearchDetailPO(driver);
    }

}
