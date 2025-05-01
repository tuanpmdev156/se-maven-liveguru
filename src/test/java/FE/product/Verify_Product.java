package FE.product;

import common.BaseTest;
import common.Product_Data_Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Verify_Product extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private MobilePO mobilePage;
    private CheckoutPO checkoutPage;
    private MobileDetailPO mobileDetailPage;
    private CompareProductPO compareProductPage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        writeLog("Verify_Discount_Coupon - Step 01: Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
        writeLog("Verify_Discount_Coupon - Step 02: Set cookie and reload page");
        setCookieAndReloadPage();
    }

    @Test
    public void TC_04_Verify_Detail_Product_Price() {
        writeLog("Verify_Product_Price - Step 03: Click to Mobile link");
        mobilePage = homePage.clickToMobileLink();
        writeLog("Verify_Product_Price - Step 04: Get product price");
        String productPrice = mobilePage.getPriceByProductName(Product_Data_Test.PRODUCT_NAME);
        writeLog("Verify_Product_Price - Step 05: Open product in detail");
        mobileDetailPage = mobilePage.openProductDetailByName(Product_Data_Test.PRODUCT_NAME);
        writeLog("Verify_Product_Price - Step 06: Get product price in detail");
        String productDetailPrice = mobileDetailPage.getDetailPrice();
        writeLog("Verify_Product_Price - Step 07: Verify product price in detail");
        verifyEquals(productPrice,productDetailPrice);
    }

    @Test
    public void TC_05_Verify_Discount_Coupon() {
        writeLog("Verify_Discount_Coupon - Step 01: Click to Mobile link");
        mobilePage = homePage.clickToMobileLink();
        writeLog("Verify_Discount_Coupon - Step 02: Add product to cart");
        checkoutPage = mobilePage.addToCartByProductName(Product_Data_Test.PRODUCT_NAME);
        writeLog("Verify_Discount_Coupon - Step 03: Verify product is added to cart");
        verifyEquals(checkoutPage.getAddToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");
        writeLog("Verify_Discount_Coupon - Step 04: Enter discount code");
        checkoutPage.enterToDiscountCodeTextbox(Product_Data_Test.COUPLE_CODE);
        writeLog("Verify_Discount_Coupon - Step 05: Click apply link");
        checkoutPage.clickToApplyLink();
        checkoutPage.acceptAlert(driver);
        writeLog("Verify_Discount_Coupon - Step 06: Verify coupon is applied");
        verifyEquals(checkoutPage.getAppliedCouponCodeSuccessMessage(), "Coupon code \"GURU50\" was applied.");
        writeLog("Verify_Discount_Coupon - Step 07: Verify discount value");
        verifyEquals(checkoutPage.getDiscountValue(Product_Data_Test.COUPLE_CODE),"-$5.00");
        writeLog("Verify_Discount_Coupon - Step 08: Verify grand total value");
        // Bug here
        verifyEquals(checkoutPage.getGrandTotalValue(),"$95.00");
    }

    @Test
    public void TC_06_Verify_Product_In_Cart() {
        writeLog("Verify_Product_In_Cart - Step 01: Update quantity");
        checkoutPage.enterToQuantityTextbox(Product_Data_Test.PRODUCT_NAME,Product_Data_Test.PRODUCT_QUANTITY);
        writeLog("Verify_Product_In_Cart - Step 02: Click to update button");
        checkoutPage.clickToUpdateQuantityButton(Product_Data_Test.PRODUCT_NAME);
        checkoutPage.acceptAlert(driver);
        writeLog("Verify_Product_In_Cart - Step 03: Verify shopping cart error message is displayed");
        verifyTrue(checkoutPage.isCartErrorMessageDisplayed());
        writeLog("Verify_Product_In_Cart - Step 04: Verify quantity error message is displayed");
        verifyTrue(checkoutPage.isQuantityErrorMessageDisplayed());
        writeLog("Verify_Product_In_Cart - Step 05: Click to Empty Cart");
        checkoutPage.clickToEmptyCartLink();
        checkoutPage.acceptAlert(driver);
        writeLog("Verify_Product_In_Cart - Step 06: Verify cart is empty");
        verifyEquals(checkoutPage.getCartEmptyMessage(),"SHOPPING CART IS EMPTY");
    }

    @Test
    public void TC_07_Compare_Two_Product() {
        writeLog("Compare_Two_Product - Step 01: Click to Mobile link");
        mobilePage = homePage.clickToMobileLink();
        writeLog("Compare_Two_Product - Step 02: Add product to compare");
        mobilePage.addToCompareByProductName("Sony Xperia");
        writeLog("Compare_Two_Product - Step 03: Verify product has been added to comparison list");
        verifyEquals(mobilePage.getAddToCompareSuccessMessage(), "The product Sony Xperia has been added to comparison list.");
        mobilePage.addToCompareByProductName("IPhone");
        verifyEquals(mobilePage.getAddToCompareSuccessMessage(), "The product IPhone has been added to comparison list.");
        writeLog("Compare_Two_Product - Step 04: Click to Compare button");
        mobilePage.clickToCompareButton();
        writeLog("Compare_Two_Product - Step 05: Switch to compare product window");
        mobilePage.switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
        compareProductPage = PageGenerator.getCompareProductPage(driver);
        writeLog("Compare_Two_Product - Step 06: Verify compare window heading");
        verifyTrue(compareProductPage.isHeadingDisplayed());
        writeLog("Compare_Two_Product - Step 07: Verify product name ");
        verifyTrue(compareProductPage.isProductNameDisplayed("Sony Xperia"));
        verifyTrue(compareProductPage.isProductNameDisplayed("IPhone"));
        writeLog("Compare_Two_Product - Step 08: Verify product price ");
        verifyTrue(compareProductPage.isProductPriceDisplayed("Sony Xperia","$100.00"));
        verifyTrue(compareProductPage.isProductPriceDisplayed("IPhone", "$500.00"));
        writeLog("Compare_Two_Product - Step 09: Verify product image");
        verifyTrue(compareProductPage.isProductImageDisplayed("Sony Xperia","xperia.jpg"));
        verifyTrue(compareProductPage.isProductImageDisplayed("IPhone", "iphone.png"));
        writeLog("Compare_Two_Product - Step 10: Verify product SKU");
        verifyTrue(compareProductPage.isProductSKUDisplayed("Sony Xperia","MOB001"));
        verifyTrue(compareProductPage.isProductSKUDisplayed("IPhone", "MOB0002"));
        writeLog("Compare_Two_Product - Step 11: Close compare window");
        compareProductPage.clickToCloseWindowButton();
        writeLog("Compare_Two_Product - Step 12: Switch to Mobile window");
        compareProductPage.switchToWindowByTitle(driver,"Mobile");
        mobilePage = PageGenerator.getMobilePage(driver);
        writeLog("Compare_Two_Product - Step 13: Verify switched to Mobile window success");
        verifyEquals(mobilePage.getPageTitle(driver),"Mobile");
    }



    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
