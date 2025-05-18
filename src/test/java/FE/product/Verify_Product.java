package FE.product;

import common.Product_Data_Test;
import common.StepLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Verify_Product extends StepLogger {
    private WebDriver driver;
    private HomePO homePage;
    private ProductCategoryPO productCategoryPage;
    private CheckoutPO checkoutPage;
    private ProductDetailPO productDetailPage;
    private ProductReviewPO productReviewPage;
    private CompareProductPO compareProductPage;
    private MyWishlistPO myWishlistPage;
    private ShareWishlistPO shareWishlistPage;
    private AdvancedSearchPO advancedSearchPage;
    private AdvancedSearchDetailPO advancedSearchDetailPage;



    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        logStep("Before Class","Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
        logStep("Before Class","Set cookie and reload page");
        setCookieAndReloadPage();
    }

    @Test
    public void TC_04_Verify_Detail_Product_Price() {
        writeLog("Verify_Product_Price - Step 03: Click to Mobile link");
        productCategoryPage = homePage.clickToMobileLink();
        writeLog("Verify_Product_Price - Step 04: Get product price");
        String productPrice = productCategoryPage.getPriceByProductName(Product_Data_Test.PRODUCT_NAME);
        writeLog("Verify_Product_Price - Step 05: Open product in detail");
        productDetailPage = productCategoryPage.openDetailProductByName(Product_Data_Test.PRODUCT_NAME);
        writeLog("Verify_Product_Price - Step 06: Get product price in detail");
        String productDetailPrice = productDetailPage.getDetailPrice();
        writeLog("Verify_Product_Price - Step 07: Verify product price in detail");
        verifyEquals(productPrice,productDetailPrice);
    }

    @Test
    public void TC_05_Verify_Discount_Coupon() {
        writeLog("Verify_Discount_Coupon - Step 01: Click to Mobile link");
        productCategoryPage = homePage.clickToMobileLink();
        writeLog("Verify_Discount_Coupon - Step 02: Add product to cart");
        checkoutPage = productCategoryPage.addToCartByProductName(Product_Data_Test.PRODUCT_NAME);
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
        productCategoryPage = homePage.clickToMobileLink();
        writeLog("Compare_Two_Product - Step 02: Add product to compare");
        productCategoryPage.addToCompareByProductName("Sony Xperia");
        writeLog("Compare_Two_Product - Step 03: Verify product has been added to comparison list");
        verifyEquals(productCategoryPage.getAddToCompareSuccessMessage(), "The product Sony Xperia has been added to comparison list.");
        productCategoryPage.addToCompareByProductName("IPhone");
        verifyEquals(productCategoryPage.getAddToCompareSuccessMessage(), "The product IPhone has been added to comparison list.");
        writeLog("Compare_Two_Product - Step 04: Click to Compare button");
        productCategoryPage.clickToCompareButton();
        writeLog("Compare_Two_Product - Step 05: Switch to compare product window");
        productCategoryPage.switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
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
        productCategoryPage = PageGenerator.getMobilePage(driver);
        writeLog("Compare_Two_Product - Step 13: Verify switched to Mobile window success");
        verifyEquals(productCategoryPage.getPageTitle(driver),"Mobile");
    }
    @Test
    public void TC_08_Verify_Sharing_Wishlist() {
        writeLog("Verify_Sharing_Wishlist - Step 01: Click to TV link");
        productCategoryPage = homePage.clickToTVLink();
        writeLog("Verify_Sharing_Wishlist - Step 02: Add product to wishlist");
        productCategoryPage.addToWishlistByProductName("LG LCD");
        myWishlistPage = PageGenerator.getMyWishlistPage(driver);
        writeLog("Verify_Sharing_Wishlist - Step 03: Verify product is added to wishlist");
        verifyEquals(myWishlistPage.getAddToWishlistSuccessMsg(),"LG LCD has been added to your wishlist. Click here to continue shopping.");
        writeLog("Verify_Sharing_Wishlist - Step 04: Click to share wishlist button");
        myWishlistPage.clickToShareWishlistBtn();
        myWishlistPage.acceptAlert(driver);
        shareWishlistPage = PageGenerator.getShareWishlistPage(driver);
        writeLog("Verify_Sharing_Wishlist - Step 05: Enter to share email textbox");
        shareWishlistPage.enterToShareEmailTextbox("abc@gmail.com");
        writeLog("Verify_Sharing_Wishlist - Step 06: Enter to share message textbox");
        shareWishlistPage.enterToShareMessageTextbox("abc@gmail.com");
        writeLog("Verify_Sharing_Wishlist - Step 07: Click to share wishlist button");
        shareWishlistPage.clickToShareWishlistBtn();
        shareWishlistPage.acceptAlert(driver);
        myWishlistPage = PageGenerator.getMyWishlistPage(driver);
        writeLog("Verify_Sharing_Wishlist - Step 08: Verify sharing success message");
        verifyEquals(myWishlistPage.getSharingSuccessMsg(),"Your Wishlist has been shared.");
        writeLog("Verify_Sharing_Wishlist - Step 09: Verify wishlist has product LG LCD");
        verifyTrue(myWishlistPage.isProductDisplayedInWishlist("LG LCD"));
    }

    @Test
    public void TC_09_Verify_Review_Product() {
        StepLogger.reset();
        logStep("Verify_Review_Product","Click to TV link");
        productCategoryPage = homePage.clickToTVLink();

        logStep("Verify_Review_Product","Open detail page of product 'LG LCD'");
        productCategoryPage.openDetailProductByName("LG LCD");
        productDetailPage = PageGenerator.getProductDetailPage(driver);

        logStep("Verify_Review_Product","Click to 'Add Your Review' link");
        productDetailPage.clickToAddYourReviewLink();
        productReviewPage = PageGenerator.getProductReviewPage(driver);

        // Submit review with empty data
        logStep("Verify_Review_Product","Clear review field");
        productReviewPage.clearReviewField();
        logStep("Verify_Review_Product","Clear summary review field");
        productReviewPage.clearSummaryReviewField();
        logStep("Verify_Review_Product","Click to submit review button");
        productReviewPage.clickToSubmitReviewBtn();

        // Verify require messages
        logStep("Verify_Review_Product","Verify quality rating message is displayed");
        verifyTrue(productReviewPage.isQualityRatingRequiredMsgDisplayed("Please select one of each of the ratings above"));

        logStep("Verify_Review_Product","Verify review message is displayed");
        verifyTrue(productReviewPage.isReviewRequiredMsgDisplayed("This is a required field."));

        logStep("Verify_Review_Product","Verify summary review message is displayed");
        verifyTrue(productReviewPage.isSummaryReviewRequiredMsgDisplayed("This is a required field."));

        // Submit review with data
        logStep("Verify_Review_Product","Select quality rating");
        productReviewPage.selectQualityRatingRadioBtn(Product_Data_Test.QUALITY_RATING);

        logStep("Verify_Review_Product","Clear review field");
        productReviewPage.clearReviewField();
        logStep("Verify_Review_Product","Enter value to review field : " + Product_Data_Test.YOUR_THOUGHT);
        productReviewPage.enterToReviewField(Product_Data_Test.YOUR_THOUGHT);

        logStep("Verify_Review_Product","Clear summary review field");
        productReviewPage.clearSummaryReviewField();
        logStep("Verify_Review_Product","Enter value to summary review field : " + Product_Data_Test.SUMMARY_REVIEW_DATA);
        productReviewPage.enterToSummaryReviewField(Product_Data_Test.SUMMARY_REVIEW_DATA);

        logStep("Verify_Review_Product","Click to submit review button");
        productReviewPage.clickToSubmitReviewBtn();
        logStep("Verify_Review_Product","Accept alert");
        productReviewPage.acceptAlert(driver);
        logStep("Verify_Review_Product","Navigate to home page");
        homePage = PageGenerator.getHomePage(driver);
        logStep("Verify_Review_Product","Verify review success message");
        verifyTrue(homePage.isReviewSuccessMsgDisplayed("Your review has been accepted for moderation."));
    }

    @Test
    public void TC_10_Verify_Purchase_Product(){
        // Skip, cannot execute manual test
    }

    @Test
    public void TC_11_Verify_Search_Functionality(){
        logStep("TC_11_Verify_Search_Functionality","Click to Advanced Search link");
        homePage.clickToAdvancedSearchLink();
        logStep("TC_11_Verify_Search_Functionality","Get Advanced Search page");
        advancedSearchPage = PageGenerator.getAdvancedSearchPage(driver);
        logStep("TC_11_Verify_Search_Functionality","Enter to Price range textbox with value: " + Product_Data_Test.SEARCH_PRICE_FROM);
        advancedSearchPage.enterToSearchPriceFromTextbox(Product_Data_Test.SEARCH_PRICE_FROM);
        logStep("TC_11_Verify_Search_Functionality","Enter to Price range textbox with value: " + Product_Data_Test.SEARCH_PRICE_TO);
        advancedSearchPage.enterToSearchPriceToTextbox(Product_Data_Test.SEARCH_PRICE_TO);
        logStep("TC_11_Verify_Search_Functionality","Click to Search button");
        advancedSearchPage.clickToSearchButton();
        logStep("TC_11_Verify_Search_Functionality","Accept Alert");
        advancedSearchPage.acceptAlert(driver);
        logStep("TC_11_Verify_Search_Functionality","Get Advanced Search Detail page");
        advancedSearchDetailPage = PageGenerator.getAdvancedSearchDetailPage(driver);
        logStep("TC_11_Verify_Search_Functionality","Verify search price range is displayed");
        verifyTrue(advancedSearchDetailPage.isSearchPriceRangeDisplayed(Product_Data_Test.SEARCH_PRICE_FROM,Product_Data_Test.SEARCH_PRICE_TO));
        logStep("TC_11_Verify_Search_Functionality","Verify products are displayed in search range");
        verifyTrue(advancedSearchDetailPage.areProductsDisplayedInSearchRange(Product_Data_Test.SEARCH_PRICE_FROM,Product_Data_Test.SEARCH_PRICE_TO));
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
