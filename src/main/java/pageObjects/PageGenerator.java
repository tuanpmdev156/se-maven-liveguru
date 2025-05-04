package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static RegisterPO getRegisterPage(WebDriver driver) {
        return new RegisterPO(driver);
    }
    public static HomePO getHomePage(WebDriver driver) {
        return new HomePO(driver);
    }
    public static MyAccountPO getMyAccountPage(WebDriver driver) {
        return new MyAccountPO(driver);
    }
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }
    public static ProductCategoryPO getMobilePage(WebDriver driver) {
        return new ProductCategoryPO(driver);
    }
    public static ProductDetailPO getProductDetailPage(WebDriver driver) {
        return new ProductDetailPO(driver);
    }
    public static CheckoutPO getCheckoutPage(WebDriver driver) {
        return new CheckoutPO(driver);
    }
    public static CompareProductPO getCompareProductPage(WebDriver driver) {
        return new CompareProductPO(driver);
    }
    public static MyWishlistPO getMyWishlistPage(WebDriver driver) {
        return new MyWishlistPO(driver);
    }
    public static ShareWishlistPO getShareWishlistPage(WebDriver driver) {
        return new ShareWishlistPO(driver);
    }

    public static ProductReviewPO getProductReviewPage(WebDriver driver) {
        return new ProductReviewPO(driver);
    }
}
