package product;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Verify_Product_In_Cart extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private MobilePO mobilePage;
    private CheckoutPO checkoutPage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        writeLog("Verify_Product_In_Cart - Step 01: Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
        writeLog("Verify_Product_In_Cart - Step 02: Set cookie and reload page");
        setCookieAndReloadPage();
    }

    @Test
    public void TC_06_Verify_Product_In_Cart() {
        writeLog("Verify_Product_In_Cart - Step 03: Click to Mobile link");
        mobilePage = homePage.clickToMobileLink();
        writeLog("Verify_Product_In_Cart - Step 04: Add product to cart");
        checkoutPage = mobilePage.addToCartByProductName("Sony Xperia");
        writeLog("Verify_Product_In_Cart - Step 05: Update quantity");
        checkoutPage.enterToQuantityTextbox("Sony Xperia","501");
        writeLog("Verify_Product_In_Cart - Step 06: Click to update button");
        checkoutPage.clickToUpdateQuantityButton("Sony Xperia");
        checkoutPage.acceptAlert(driver);
        writeLog("Verify_Product_In_Cart - Step 07: Verify shopping cart error message is displayed");
        verifyTrue(checkoutPage.isCartErrorMessageDisplayed());
        writeLog("Verify_Product_In_Cart - Step 08: Verify quantity error message is displayed");
        verifyTrue(checkoutPage.isQuantityErrorMessageDisplayed());
        writeLog("Verify_Product_In_Cart - Step 09: Click to Empty Cart");
        checkoutPage.clickToEmptyCartLink();
        checkoutPage.acceptAlert(driver);
        writeLog("Verify_Product_In_Cart - Step 10: Verify cart is empty");
        verifyEquals(checkoutPage.getCartEmptyMessage(),"SHOPPING CART IS EMPTY");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
