package product;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePO;
import pageObjects.MobileDetailPO;
import pageObjects.MobilePO;
import pageObjects.PageGenerator;

public class Verify_Product_Cost extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private MobilePO mobilePage;
    private MobileDetailPO mobileDetailPage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        writeLog("Verify_Product_Cost - Step 01: Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);
        writeLog("Verify_Product_Cost - Step 02: Set cookie and reload page");
        setCookieAndReloadPage();
    }

    @Test
    public void TC_04_Verify_Mobile_Cost() {
        writeLog("Verify_Product_Cost - Step 03: Click to Mobile link");
        mobilePage = homePage.clickToMobileLink();
        writeLog("Verify_Product_Cost - Step 04: Get product price");
        String productPrice = mobilePage.getPriceByProductName("Sony Xperia");
        writeLog("Verify_Product_Cost - Step 05: Open product in detail");
        mobileDetailPage = mobilePage.openProductDetailByName("Sony Xperia");
        writeLog("Verify_Product_Cost - Step 06: Get product price in detail");
        String productDetailPrice = mobileDetailPage.getDetailPrice();
        writeLog("Verify_Product_Cost - Step 07: Verify product price");
        verifyEquals(productPrice,productDetailPrice);
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
