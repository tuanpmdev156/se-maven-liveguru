package FE.user;

import common.BaseTest;
import common.CookiesArchive;
import common.User_Data_Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.MyAccountPO;
import pageObjects.PageGenerator;

public class User_Login extends BaseTest {

    private WebDriver driver;
    private HomePO homePage;
    private LoginPO loginPage;
    private MyAccountPO myAccountPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        writeLog("User_Login - Step 01: Open URL");
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

    }

    @Test
    public void TC_03_Login() {
        writeLog("User_Login - Step 02: Click on ACCOUNT menu");
        homePage.clickToAccountMenu();
        writeLog("User_Login - Step 03: Click on Login link");
        loginPage = homePage.clickToLoginLink();
        writeLog("User_Login - Step 04: Insert login email: " + User_Data_Test.EMAIL_ADDRESS);
        loginPage.enterToFirstNameTextbox(User_Data_Test.EMAIL_ADDRESS);
        writeLog("User_Login - Step 05: Insert login password: " + User_Data_Test.PASSWORD);
        loginPage.enterToPasswordTextbox(User_Data_Test.PASSWORD);
        loginPage.clickToLoginButton();
        myAccountPage = loginPage.confirmAlertPopup();
        writeLog("User_Login - Step 06: Verify login successfully");
        verifyEquals(myAccountPage.getDashboardWelcomeText(),"Hello, "+ User_Data_Test.FIRST_NAME +" "+ User_Data_Test.LAST_NAME +"!");
        writeLog("User_Login - Step 07: Get cookies after login");
        CookiesArchive.cookie = driver.manage().getCookies();
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
