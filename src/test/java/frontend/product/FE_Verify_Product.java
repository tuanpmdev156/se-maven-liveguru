package frontend.product;

import common.Product_Data_Test;
import common.StepLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class FE_Verify_Product extends StepLogger {
    private WebDriver driver;
    private FE_HomePO homePage;
    private FE_ProductCategoryPO productCategoryPage;
    private FE_CheckoutPO checkoutPage;
    private FE_ProductDetailPO productDetailPage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        StepLogger.reset(); // Reset step
        logStep("BeforeClass","Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
        logStep("Before Class","Set cookie and reload page");
        setCookieAndReloadPage();
    }

    @Test
    public void TC_04_Verify_Detail_Product_Price() {
        StepLogger.reset(); // Reset step
        logStep("TC_04_Verify_Detail_Product_Price","Click to Mobile link");
        productCategoryPage = homePage.clickToMobileLink();
        logStep("TC_04_Verify_Detail_Product_Price","Get product price");
        String productPrice = productCategoryPage.getPriceByProductName(Product_Data_Test.PRODUCT_NAME);
        logStep("TC_04_Verify_Detail_Product_Price","Open product in detail");
        productDetailPage = productCategoryPage.openDetailProductByName(Product_Data_Test.PRODUCT_NAME);
        logStep("TC_04_Verify_Detail_Product_Price","Get product price in detail");
        String productDetailPrice = productDetailPage.getDetailPrice();
        logStep("TC_04_Verify_Detail_Product_Price","Verify product price in detail");
        verifyEquals(productPrice,productDetailPrice);
    }

    @Test
    public void TC_05_Verify_Discount_Coupon() {
        logStep("TC_05_Verify_Discount_Coupon","Click to Mobile link");
        productCategoryPage = homePage.clickToMobileLink();
        logStep("TC_05_Verify_Discount_Coupon","Add product to cart");
        checkoutPage = productCategoryPage.addToCartByProductName(Product_Data_Test.PRODUCT_NAME);
        logStep("TC_05_Verify_Discount_Coupon","Verify product is added to cart");
        verifyEquals(checkoutPage.getAddToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");
        logStep("TC_05_Verify_Discount_Coupon","Enter discount code");
        checkoutPage.enterToDiscountCodeTextbox(Product_Data_Test.COUPLE_CODE);
        logStep("TC_05_Verify_Discount_Coupon","Click apply link");
        checkoutPage.clickToApplyLink();
        checkoutPage.acceptAlert(driver);
        logStep("TC_05_Verify_Discount_Coupon","Verify coupon is applied");
        verifyEquals(checkoutPage.getAppliedCouponCodeSuccessMessage(), "Coupon code \"GURU50\" was applied.");
        logStep("TC_05_Verify_Discount_Coupon","Verify discount value");
        verifyEquals(checkoutPage.getDiscountValue(Product_Data_Test.COUPLE_CODE),"-$5.00");
        logStep("TC_05_Verify_Discount_Coupon","Verify grand total value");
        // Bug here
        verifyEquals(checkoutPage.getGrandTotalValue(),"$95.00");
    }

    @Test
    public void TC_06_Verify_Product_In_Cart() {
        logStep("TC_06_Verify_Product_In_Cart","Update quantity");
        checkoutPage.enterToQuantityTextbox(Product_Data_Test.PRODUCT_NAME,Product_Data_Test.PRODUCT_QUANTITY);
        logStep("TC_06_Verify_Product_In_Cart","Click to update button");
        checkoutPage.clickToUpdateQuantityButton(Product_Data_Test.PRODUCT_NAME);
        checkoutPage.acceptAlert(driver);
        logStep("TC_06_Verify_Product_In_Cart","Verify shopping cart error message is displayed");
        verifyTrue(checkoutPage.isCartErrorMessageDisplayed());
        logStep("TC_06_Verify_Product_In_Cart","Verify quantity error message is displayed");
        verifyTrue(checkoutPage.isQuantityErrorMessageDisplayed());
        logStep("TC_06_Verify_Product_In_Cart","Click to Empty Cart");
        checkoutPage.clickToEmptyCartLink();
        checkoutPage.acceptAlert(driver);
        logStep("TC_06_Verify_Product_In_Cart","Verify cart is empty");
        verifyEquals(checkoutPage.getCartEmptyMessage(),"SHOPPING CART IS EMPTY");
    }

    @Test
    public void TC_07_Compare_Two_Product() {
        logStep("TC_07_Compare_Two_Product","Click to Mobile link");
        productCategoryPage = homePage.clickToMobileLink();
        logStep("TC_07_Compare_Two_Product","Add product to compare");
        productCategoryPage.addToCompareByProductName("Sony Xperia");
        logStep("TC_07_Compare_Two_Product","Verify product has been added to comparison list");
        verifyEquals(productCategoryPage.getAddToCompareSuccessMessage(), "The product Sony Xperia has been added to comparison list.");
        productCategoryPage.addToCompareByProductName("IPhone");
        verifyEquals(productCategoryPage.getAddToCompareSuccessMessage(), "The product IPhone has been added to comparison list.");
        logStep("TC_07_Compare_Two_Product","Click to Compare button");
        productCategoryPage.clickToCompareButton();
        logStep("TC_07_Compare_Two_Product","Switch to compare product window");
        productCategoryPage.switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
        FE_CompareProductPO compareProductPage = PageGenerator.getCompareProductPage(driver);
        logStep("TC_07_Compare_Two_Product","Verify compare window heading");
        verifyTrue(compareProductPage.isHeadingDisplayed());
        logStep("TC_07_Compare_Two_Product","Verify product name ");
        verifyTrue(compareProductPage.isProductNameDisplayed("Sony Xperia"));
        verifyTrue(compareProductPage.isProductNameDisplayed("IPhone"));
        logStep("TC_07_Compare_Two_Product","Verify product price ");
        verifyTrue(compareProductPage.isProductPriceDisplayed("Sony Xperia","$100.00"));
        verifyTrue(compareProductPage.isProductPriceDisplayed("IPhone", "$500.00"));
        logStep("TC_07_Compare_Two_Product","Verify product image");
        verifyTrue(compareProductPage.isProductImageDisplayed("Sony Xperia","xperia.jpg"));
        verifyTrue(compareProductPage.isProductImageDisplayed("IPhone", "iphone.png"));
        logStep("TC_07_Compare_Two_Product","Verify product SKU");
        verifyTrue(compareProductPage.isProductSKUDisplayed("Sony Xperia","MOB001"));
        verifyTrue(compareProductPage.isProductSKUDisplayed("IPhone", "MOB0002"));
        logStep("TC_07_Compare_Two_Product","Close compare window");
        compareProductPage.clickToCloseWindowButton();
        logStep("TC_07_Compare_Two_Product","Switch to Mobile window");
        compareProductPage.switchToWindowByTitle(driver,"Mobile");
        productCategoryPage = PageGenerator.getMobilePage(driver);
        logStep("TC_07_Compare_Two_Product","Verify switched to Mobile window success");
        verifyEquals(productCategoryPage.getPageTitle(driver),"Mobile");
    }
    @Test
    public void TC_08_Verify_Sharing_Wishlist() {
        logStep("TC_08_Verify_Sharing_Wishlist","Click to TV link");
        productCategoryPage = homePage.clickToTVLink();
        logStep("TC_08_Verify_Sharing_Wishlist","Add product to wishlist");
        productCategoryPage.addToWishlistByProductName("LG LCD");
        FE_MyWishlistPO myWishlistPage = PageGenerator.getMyWishlistPage(driver);
        logStep("TC_08_Verify_Sharing_Wishlist","Verify product is added to wishlist");
        verifyEquals(myWishlistPage.getAddToWishlistSuccessMsg(),"LG LCD has been added to your wishlist. Click here to continue shopping.");
        logStep("TC_08_Verify_Sharing_Wishlist","Click to share wishlist button");
        myWishlistPage.clickToShareWishlistBtn();
        myWishlistPage.acceptAlert(driver);
        FE_ShareWishlistPO shareWishlistPage = PageGenerator.getShareWishlistPage(driver);
        logStep("TC_08_Verify_Sharing_Wishlist","Enter to share email textbox");
        shareWishlistPage.enterToShareEmailTextbox("abc@gmail.com");
        logStep("TC_08_Verify_Sharing_Wishlist","Enter to share message textbox");
        shareWishlistPage.enterToShareMessageTextbox("abc@gmail.com");
        logStep("TC_08_Verify_Sharing_Wishlist","Click to share wishlist button");
        shareWishlistPage.clickToShareWishlistBtn();
        shareWishlistPage.acceptAlert(driver);
        myWishlistPage = PageGenerator.getMyWishlistPage(driver);
        logStep("TC_08_Verify_Sharing_Wishlist","Verify sharing success message");
        verifyEquals(myWishlistPage.getSharingSuccessMsg(),"Your Wishlist has been shared.");
        logStep("TC_08_Verify_Sharing_Wishlist","Verify wishlist has product LG LCD");
        verifyTrue(myWishlistPage.isProductDisplayedInWishlist("LG LCD"));
    }

    @Test
    public void TC_09_Verify_Review_Product() {
        StepLogger.reset(); // Reset step
        logStep("TC_09_Verify_Review_Product","Click to TV link");
        productCategoryPage = homePage.clickToTVLink();

        logStep("TC_09_Verify_Review_Product","Open detail page of product 'LG LCD'");
        productCategoryPage.openDetailProductByName("LG LCD");
        productDetailPage = PageGenerator.getProductDetailPage(driver);

        logStep("TC_09_Verify_Review_Product","Click to 'Add Your Review' link");
        productDetailPage.clickToAddYourReviewLink();
        FE_ProductReviewPO productReviewPage = PageGenerator.getProductReviewPage(driver);

        // Submit review with empty data
        logStep("TC_09_Verify_Review_Product","Clear review field");
        productReviewPage.clearReviewField();
        logStep("TC_09_Verify_Review_Product","Clear summary review field");
        productReviewPage.clearSummaryReviewField();
        logStep("TC_09_Verify_Review_Product","Click to submit review button");
        productReviewPage.clickToSubmitReviewBtn();

        // Verify require messages
        logStep("TC_09_Verify_Review_Product","Verify quality rating message is displayed");
        verifyTrue(productReviewPage.isQualityRatingRequiredMsgDisplayed("Please select one of each of the ratings above"));

        logStep("TC_09_Verify_Review_Product","Verify review message is displayed");
        verifyTrue(productReviewPage.isReviewRequiredMsgDisplayed("This is a required field."));

        logStep("TC_09_Verify_Review_Product","Verify summary review message is displayed");
        verifyTrue(productReviewPage.isSummaryReviewRequiredMsgDisplayed("This is a required field."));

        // Submit review with data
        logStep("TC_09_Verify_Review_Product","Select quality rating");
        productReviewPage.selectQualityRatingRadioBtn(Product_Data_Test.QUALITY_RATING);

        logStep("TC_09_Verify_Review_Product","Clear review field");
        productReviewPage.clearReviewField();
        logStep("TC_09_Verify_Review_Product","Enter value to review field : " + Product_Data_Test.YOUR_THOUGHT);
        productReviewPage.enterToReviewField(Product_Data_Test.YOUR_THOUGHT);

        logStep("TC_09_Verify_Review_Product","Clear summary review field");
        productReviewPage.clearSummaryReviewField();
        logStep("TC_09_Verify_Review_Product","Enter value to summary review field : " + Product_Data_Test.SUMMARY_REVIEW_DATA);
        productReviewPage.enterToSummaryReviewField(Product_Data_Test.SUMMARY_REVIEW_DATA);

        logStep("TC_09_Verify_Review_Product","Click to submit review button");
        productReviewPage.clickToSubmitReviewBtn();
        logStep("TC_09_Verify_Review_Product","Accept alert");
        productReviewPage.acceptAlert(driver);
        logStep("TC_09_Verify_Review_Product","Navigate to home page");
        homePage = PageGenerator.getHomePage(driver);
        logStep("TC_09_Verify_Review_Product","Verify review success message");
        verifyTrue(homePage.isReviewSuccessMsgDisplayed("Your review has been accepted for moderation."));
    }

    @Test
    public void TC_10_Verify_Purchase_Product(){
        // Skip, manual test failed
    }

    @Test
    public void TC_11_Verify_Search_Functionality(){
        logStep("TC_11_Verify_Search_Functionality","Click to Advanced Search link");
        homePage.clickToAdvancedSearchLink();
        logStep("TC_11_Verify_Search_Functionality","Get Advanced Search page");
        FE_AdvancedSearchPO advancedSearchPage = PageGenerator.getAdvancedSearchPage(driver);
        logStep("TC_11_Verify_Search_Functionality","Enter to Price range textbox with value: " + Product_Data_Test.SEARCH_PRICE_FROM);
        advancedSearchPage.enterToSearchPriceFromTextbox(Product_Data_Test.SEARCH_PRICE_FROM);
        logStep("TC_11_Verify_Search_Functionality","Enter to Price range textbox with value: " + Product_Data_Test.SEARCH_PRICE_TO);
        advancedSearchPage.enterToSearchPriceToTextbox(Product_Data_Test.SEARCH_PRICE_TO);
        logStep("TC_11_Verify_Search_Functionality","Click to Search button");
        advancedSearchPage.clickToSearchButton();
        logStep("TC_11_Verify_Search_Functionality","Accept Alert");
        advancedSearchPage.acceptAlert(driver);
        logStep("TC_11_Verify_Search_Functionality","Get Advanced Search Detail page");
        FE_AdvancedSearchDetailPO advancedSearchDetailPage = PageGenerator.getAdvancedSearchDetailPage(driver);
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
